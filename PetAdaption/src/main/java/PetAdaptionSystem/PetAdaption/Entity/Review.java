package PetAdaptionSystem.PetAdaption.Entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "reviews")
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column(nullable = false)
    private Long userId;  // User who submitted the review

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Breed name is required")
    private String breed;

    @Column(nullable = false, length = 1000)
    @NotBlank(message = "Review content cannot be empty")
    private String reviewText;

    @Column(nullable = false)
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating cannot exceed 5")
    private int rating;

    @Column(nullable = false)
    private LocalDateTime timestamp = LocalDateTime.now();
}
