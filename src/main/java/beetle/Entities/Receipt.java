package beetle.Entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Table(name="Receipts")
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Receipt {
    @Id
    @GeneratedValue
    private long id;
    private String date;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    private List<Product> product;

    public Receipt(String date, User user, List<Product> product) {
        this.date = date;
        this.user = user;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }
}
