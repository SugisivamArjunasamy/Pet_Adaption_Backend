package PetAdaptionSystem.PetAdaption.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Adoption_table")
public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adoptionId;

    @Column(nullable = false,length = 100)
    private String adoptionDetails;
}
