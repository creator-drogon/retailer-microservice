package orderservice.productCatalogue;

import com.fasterxml.jackson.databind.util.JSONPObject;
import javassist.NotFoundException;
import orderservice.productCatalogue.entity.Product;
import orderservice.productCatalogue.service.ProductService;
import orderservice.productCatalogue.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping(path = "/api/products")
//@RefreshScope
public class ProductController {

    @Autowired
    ProductService productService;


    @PostMapping(path = "/"/*, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE*/)
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Random random = new Random();
        int low = 5;
        int high = 1000;
        int result = random.nextInt(high-low) + low;
        product.setProductId(result);
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);

    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product ) throws NotFoundException {
        Product productData = productService.updateProduct(id,product);
        if(productData != null){

            return new ResponseEntity<Product>(productData,HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id) throws NotFoundException, ChangeSetPersister.NotFoundException {
        Product productData = productService.deleteProduct(id);
        if(productData == null){

            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    @GetMapping(path="/{id}",
            produces =  {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            } )
    public ResponseEntity<Product> searchProduct(@PathVariable("id") long id ) {
        Product productData = productService.searchProduct(id);

        if (productData != null) {
            return new ResponseEntity<Product>(productData, HttpStatus.OK);
        }

        else return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);


    }



}
