package beetle.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="ProductsInReceipts")
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ProductsInReseipt {
    @Id
    @GeneratedValue
    private long id;
    private long receipt_id;
    private long product_id;
    private String name;
    private String email;
    private String data;

    public ProductsInReseipt(long receipt_id, long product_id, String name, String email, String data) {
        this.receipt_id = receipt_id;
        this.product_id = product_id;
        this.name = name;
        this.email = email;
        this.data = data;
    }
}
