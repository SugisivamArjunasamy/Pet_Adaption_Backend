package PetAdaptionSystem.PetAdaption.Entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

@Data
@Entity
@Table(name = "pet_table")
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petId;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Pet name is required")
    private String petName;

    @Column(nullable = false)
    @Min(value = 0, message = "Pet age cannot be negative")
    private int petAge;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Category is required")
    private String category;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Breed is required")
    private String breed;

    @Column(nullable = false, length = 200)
    @NotBlank(message = "Description is required")
    private String description;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Status is required")
    private String status;

    @Column(nullable = false)
    @Min(value = 0, message = "Amount cannot be negative")
    private int amount;
}
