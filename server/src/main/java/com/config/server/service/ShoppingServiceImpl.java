package com.config.server.service;

import com.config.server.entity.*;
import com.config.server.repository.CustomerCartRepo;
import com.config.server.repository.CustomerOrderRepo;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ShoppingServiceImpl implements ShoppingService{

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Autowired
    EurekaClient eurekaClient;

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    CustomerCartRepo customerCartRepo;

    @Autowired
    CustomerOrderRepo customerOrderRepo;

    @Override
    @HystrixCommand(fallbackMethod="defaultHystrixProduct")
    public ResponseEntity<?> createProduct(Product product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("shopping-server", false);
        String baseUrl =instanceInfo.getHomePageUrl();
        String productUrl = baseUrl+"api/productservice/api/products/";
        System.out.println(baseUrl);

        ResponseEntity<Product> response = restTemplate.postForEntity(productUrl, product, Product.class);

        if (response.getStatusCode()==HttpStatus.CREATED){

            Inventory inventory = new Inventory();
            inventory.setProductId(response.getBody().getProductId());
            inventory.setQuantity(product.getQuantity());

            String inventoryUrl = baseUrl + "api/inventoryservice/api/inventory/";
            ResponseEntity<Inventory> inventoryResponse = restTemplate.postForEntity(inventoryUrl, inventory, Inventory.class);

        }

        return response;
    }

    public ResponseEntity<?> defaultHystrixProduct(Product product){
        return new ResponseEntity<>("Server is down! Please after some time. ", HttpStatus.NO_CONTENT);
    }

    @Override
    @HystrixCommand(fallbackMethod="defaultHystrixCustomer")
    public ResponseEntity<?> createCustomer(Customer customer) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("shopping-server", false);

        String baseUrl =instanceInfo.getHomePageUrl();
        baseUrl = baseUrl+"api/customerservice/api/customer/create";
        System.out.println(baseUrl);

        ResponseEntity<Integer> response = restTemplate.postForEntity(baseUrl, customer, Integer.class);

        /*Customer customer1 = new Customer();
        customer1.setCustomerId(100);
        customer1.setCustomerName("customer1");
        customer1.setCustomerEmail("email1@mail.com");
        Set<Address> addressList1 = new HashSet<Address>();
        Set<Address> addressList2 = new HashSet<Address>();
        Address address = new Address();
        address.setAddressId(51);
        address.setDoorNo("No1");
        address.setStreetName("Street1");
        address.setLayout("Layout1");
        address.setCity("City1");
        address.setPincode(12345);
        addressList1.add(address);
        customer1.setCustomerBillingAddress(addressList1);
        Address address1 = new Address();
        address.setAddressId(52);
        address.setDoorNo("No2");
        address.setStreetName("Street2");
        address.setLayout("Layout2");
        address.setCity("City2");
        address.setPincode(12345);
        addressList2.add(address1);
        customer1.setCustomerShippingAddress(addressList2);*/

        if(response.getBody()!=0){

           /* String cartUrl =instanceInfo.getHomePageUrl();
            cartUrl = cartUrl + "api/cartservice/addtocart";
            System.out.println(cartUrl);

            ResponseEntity<Cart> cart = restTemplate.postForEntity(cartUrl, new Cart(), Cart.class);
*/
                CustomerCart customerCart = new CustomerCart();
                customerCart.setCustomerId(response.getBody());
                CustomerCart ccr = customerCartRepo.save(customerCart);
        }
        return response;
    }

    public ResponseEntity<?> defaultHystrixCustomer(Customer customer){
        return new ResponseEntity<>("Server is down! Please after some time. ", HttpStatus.NO_CONTENT);
    }

    @Override
    @HystrixCommand(fallbackMethod="defaultHystrixCart")
    public ResponseEntity<?> addProductToCart(Cart cart, int customerId) {
        ResponseEntity<?> response = null;
        Optional<CustomerCart> cart1 = customerCartRepo.findAll().stream().filter(customerCart -> customerCart.getCustomerId() == customerId).findFirst();
        if(cart1.isPresent()){
            cart.setCartId(cart1.get().getCartId());

            RestTemplate restTemplate = restTemplateBuilder.build();
            InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("shopping-server", false);
            String baseUrl =instanceInfo.getHomePageUrl();
            baseUrl = baseUrl+"api/cartservice/addtocart";
            System.out.println(baseUrl);

            response = restTemplate.postForEntity(baseUrl, cart, Cart.class);

        }else {
            response = new ResponseEntity<>("Invalid Customer", HttpStatus.NOT_FOUND);
        }

       return response;
    }

    public ResponseEntity<?> defaultHystrixCart(Cart cart, int customerId){
        return new ResponseEntity<>("Server is down! Please after some time. ", HttpStatus.NO_CONTENT);
    }

    @Override
    @HystrixCommand(fallbackMethod="defaultHystrixOrder")
    public ResponseEntity<?> createOrder(int customerId) throws Exception {

        RestTemplate restTemplate = restTemplateBuilder.build();
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("shopping-server", false);

        ResponseEntity<?> response = null;
        Optional<CustomerCart> cart = customerCartRepo.findAll().stream().filter(customerCart -> customerCart.getCustomerId() == customerId).findFirst();
        if(cart.isPresent()){
            int cartId = cart.get().getCartId();

            String baseUrl =instanceInfo.getHomePageUrl();

            String cartUrl = baseUrl+"api/cartservice/getcartbyid/"+cartId;
            ResponseEntity<Cart> cartResponse = restTemplate.getForEntity(cartUrl, Cart.class);

            if (cartResponse.getStatusCode()!=HttpStatus.OK){
                throw new Exception("Cart is Empty");
            }

            String orderUrl = baseUrl + "api/orderservice/api/order/";
            System.out.println(baseUrl);

            ResponseEntity<Cart> orderResponse = restTemplate.postForEntity(orderUrl, cartResponse.getBody(), Cart.class);
            response = orderResponse;
            if (orderResponse.getStatusCode()==HttpStatus.CREATED){
                String deleteCartUrl = baseUrl + "api/cartservice/deleteCart/" + cartId;
                System.out.println(deleteCartUrl);

                restTemplate.delete(deleteCartUrl, String.class);

                cartResponse.getBody().getLineItems().forEach(lineItems -> {
                    String inventoryUrl = baseUrl + "api/inventoryservice/api/inventory/" + lineItems.getProductId();
                    System.out.println(inventoryUrl);
                    Inventory inventory = new Inventory();
                    inventory.setProductId(lineItems.getProductId());
                    inventory.setQuantity(lineItems.getQuantity());
                    restTemplate.put(inventoryUrl, inventory);

                });

                CustomerOrder customerOrder = new CustomerOrder();
                customerOrder.setOrderId(orderResponse.getBody().getOrderId());
                customerOrder.setCustomerId(customerId);

                customerOrderRepo.save(customerOrder);
            }
        }
        return response;
    }

    @Override
    @HystrixCommand(fallbackMethod="defaultHystrixOrder")
    public ResponseEntity<?> getOrders(int customerId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("shopping-server", false);

        Set<CustomerOrder> orders = customerOrderRepo.getOrders(customerId);

        Set<Object> carts = new HashSet<Object>();
        Set<Object> ordersList = new HashSet<Object>();
        if(orders.size()>0){
            String baseUrl =instanceInfo.getHomePageUrl();
            String customerUrl = baseUrl + "api/customerservice/api/customer/"+customerId+"/search";
            System.out.println(customerUrl);

            ResponseEntity<Customer> customerResponse = restTemplate.getForEntity(customerUrl, Customer.class);
            ordersList.add(customerResponse.getBody());

            if (customerResponse.getBody()!=null){

                orders.forEach(o ->{

                    String orderUrl = baseUrl + "api/orderservice/api/order/"+o.getOrderId();
                    System.out.println(orderUrl);
                    ResponseEntity<Cart> resp = restTemplate.getForEntity(orderUrl, Cart.class);
                    carts.add(resp.getBody().getOrderId());
                    carts.add(resp.getBody().getLineItems());
                });
            }

        }
        ordersList.add(carts);
        return new ResponseEntity<>(ordersList, HttpStatus.FOUND);
    }

    public ResponseEntity<?> defaultHystrixOrder(int customerId){
        return new ResponseEntity<>("Server is down! Please after some time. ", HttpStatus.NO_CONTENT);
    }

}
