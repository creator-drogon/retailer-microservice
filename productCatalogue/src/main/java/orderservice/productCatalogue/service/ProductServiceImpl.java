package orderservice.productCatalogue.service;

import javassist.NotFoundException;
import orderservice.productCatalogue.entity.Product;
import orderservice.productCatalogue.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product addProduct(Product product){

        Random random = new Random();
        int low = 5;
        int high = 1000;
        int result = random.nextInt(high-low) + low;
        product.setProductId(result);
        Product newProduct = productRepository.save(product);

        return newProduct;
    }


    @Override
    public Product deleteProduct(long productId) throws ChangeSetPersister.NotFoundException {
        Optional<Product> productData = productRepository.findById(productId);

        if(productData.isPresent()) {
            productRepository.deleteById(productId);
        }

        else throw new ChangeSetPersister.NotFoundException();
        return null;
    }


    @Override
    public Product updateProduct(long productId, Product product) throws NotFoundException{

        Optional<Product> productData = productRepository.findById(productId);
        Product updated = productData.get();

        if(productData.isPresent()){

            updated.setProductId(productId);
            updated.setProductPrice(product.getProductPrice());
            updated.setProductDescription(product.getProductDescription());

            return productRepository.save(updated);
        }

        else throw new NotFoundException("No such product exists");



    }

    @Override
    public Product searchProduct(Long productId){
        Product product = new Product();
        Optional<Product> productData = productRepository.findById(productId);
        if(productData.isPresent()) {
            product = productData.get();
            return product;
        }
        else return null;
    }


}
