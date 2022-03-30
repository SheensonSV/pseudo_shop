package main.entitys;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String name;
    @NotNull
    private LocalDate dateCreation;

    public Cart(String name, LocalDate dateCreation, List<Product> productList) {
        this.name = name;
        this.dateCreation = dateCreation;
        this.productList = productList;
    }

    public Cart(String name, List<Product> productList) {
        this.name = name;
        this.productList = productList;
    }

    @OneToMany()
    private List<Product> productList;

    private double totalPrice;

    public void addProduct(Product product) {
        this.productList.add(product);
    }
}
