package orderservice.productCatalogue.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "product")
@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @TableGenerator(name = "productId", initialValue = 6, allocationSize = 1000)
    private long productId;

    @Column(name = "productName" ,nullable = false, length = 50)
    private String productName;

    @Column(nullable = false, length = 150)
    private String productDescription;
    @Column(updatable = true)
    private double productPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;

        return Objects.equals(productId, product.productId);
    }

    @Override
    public int hashCode() {
        return 2042274511;
    }
}
