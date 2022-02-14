package orderservice.productCatalogue.service;

import javassist.NotFoundException;
import orderservice.productCatalogue.entity.Product;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.Optional;

public interface ProductService {
    Product addProduct(Product product);
    Product deleteProduct(long productId) throws ChangeSetPersister.NotFoundException;
    Product updateProduct(long productId, Product product) throws NotFoundException;
    Product searchProduct(Long productId);
}
