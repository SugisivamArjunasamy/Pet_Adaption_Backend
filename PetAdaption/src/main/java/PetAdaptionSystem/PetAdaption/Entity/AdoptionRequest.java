package PetAdaptionSystem.PetAdaption.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Entity
@Table(name = "Adoption_Requests")
@NoArgsConstructor
@AllArgsConstructor
public class AdoptionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestId;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Adopter name is required")
    private String adopterName;

    @Column(nullable = false, length = 100)
    @Email(message = "Invalid email format")
    @NotBlank(message = "Adopter email is required")
    private String adopterEmail;

    @Column(nullable = false, length = 20)
    private String status = "Pending";

}
