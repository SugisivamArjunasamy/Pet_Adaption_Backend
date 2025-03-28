package PetAdaptionSystem.PetAdaption.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "adoption_requests")
@NoArgsConstructor
@AllArgsConstructor
public class AdoptionRequest {

    public enum RequestStatus {
        PENDING,
        APPROVED,
        REJECTED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "petId", nullable = false)
    private Pet pet;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private RequestStatus status;

    @Column(nullable = false)
    private LocalDateTime requestDate;

    @PrePersist
    protected void onCreate() {
        if (status == null) {
            status = RequestStatus.PENDING;
        }
        if (requestDate == null) {
            requestDate = LocalDateTime.now();
        }
    }

    public void setPetId(int petId) { }

    public  void setUserId(int userId) {}

}
