package main.entitys;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String name;
    private String description;
    @NotNull
    private LocalDateTime incomingDate;
    private LocalDate expirationDate;
    private int kCal;
    @NotNull
    private float price;

    public Product(String name, String description, float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(String name, String description,
                   LocalDateTime incomingDate, LocalDate expirationDate,
                   int kCal, float price) {
        this.name = name;
        this.description = description;
        this.incomingDate = incomingDate;
        this.expirationDate = expirationDate;
        this.kCal = kCal;
        this.price = price;
    }
}
