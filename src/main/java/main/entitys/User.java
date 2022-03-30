package main.entitys;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String firstName;
    @NotNull
    private String secondName;
    @NotNull
    private LocalDateTime registrationDay;
    private LocalDate birthDay;

    @NotNull
    private String mail;

    private boolean mailSubscription;
    @ManyToOne
    private Cart cart;

    public User(String firstName, String secondName, String mail) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.mail = mail;
    }

    public User(String firstName, String secondName, LocalDate birthDay, String mail, Cart cart) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDay = birthDay;
        this.mail = mail;
        this.cart = cart;
    }
}
