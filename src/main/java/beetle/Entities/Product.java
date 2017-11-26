package beetle.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Products")
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private Double price;
    private String image;

    @OneToMany(mappedBy="products", cascade= CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    public Product( String name, Double price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
