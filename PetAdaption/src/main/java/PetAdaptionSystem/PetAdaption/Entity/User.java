package PetAdaptionSystem.PetAdaption.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="User")
public class User {

    // Getters and Setters
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false, length = 100)
    private String username;

    @Setter
    @Getter
    @Column(nullable = false, length = 200)
    private String address;

    @Setter
    @Getter
    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Setter
    @Getter
    @Column(nullable = false)
    private String password = "default_password";

    @Setter
    @Getter
    @Column(nullable = false, length = 50)
    private String role;  // Can be "Admin" or "Adopter"

    // Constructors
    public User() {}

    public User(String userName, String address, String email, String password, String role) {
        this.username = userName;
        this.address = address;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getUserName() { return username; }
    public void setUserName(String userName) { this.username = userName; }

}
