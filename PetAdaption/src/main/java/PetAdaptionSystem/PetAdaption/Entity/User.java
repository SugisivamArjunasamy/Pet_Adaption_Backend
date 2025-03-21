package PetAdaptionSystem.PetAdaption.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false, length = 100)
    private String userName;

    @Column(nullable = false, length = 200)
    private String address;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false)
    private String password = "default_password";

    @Column(nullable = false, length = 50)
    private String role;  // Can be "Admin" or "Adopter"

    // Constructors
    public User() {}

    public User(String userName, String address, String email, String password, String role) {
        this.userName = userName;
        this.address = address;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
