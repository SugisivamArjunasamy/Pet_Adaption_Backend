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

}
