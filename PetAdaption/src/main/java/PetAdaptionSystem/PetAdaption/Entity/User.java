package PetAdaptionSystem.PetAdaption.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long userId;

    @Getter
    @Setter
    @Column(nullable = false, length = 100)
    private String username;

    @Getter
    @Setter
    @Column(nullable = false, length = 200)
    private String address;

    @Getter
    @Setter
    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Getter
    @Setter
    @Column(nullable = false)
    private String password;

    @Getter
    @Setter
    @Column(nullable = false, length = 50)
    private String role;

    @OneToMany(mappedBy = "adoptedBy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pet> adoptedPets;

    public User() {}

    public User(String username, String address, String email, String password, String role) {
        this.username = username;
        this.address = address;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public void setUsername(Object userName) {
        this.username  = (String) userName;
    }

    public String getUserName() {
        return username;
    }
}
