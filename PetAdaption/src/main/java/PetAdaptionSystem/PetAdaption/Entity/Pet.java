package PetAdaptionSystem.PetAdaption.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Pet_Table")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int petId;

    @Column(nullable = false,length = 100)
    private String petName;

    @Column(nullable = false)
    private int petAge;

    @Column(nullable = false,length = 100)
    private String catogori;

    @Column(nullable = false,length = 100)
    private String bread;

    @Column(nullable = false,length = 200)
    private String discription;

    @Column(nullable = false,length = 100)
    private String status;

    @Column(nullable = false)
    private int amount;

}
