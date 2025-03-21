package PetAdaptionSystem.PetAdaption.Entity;


import jakarta.persistence.*;

@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false,length = 100)
    private String userName;

    @Column(nullable = false,length = 200)
    private String address;

    @Column(nullable = false,length = 100)
    private String email;

    @Column(nullable = false)
    private int passWord;
}
