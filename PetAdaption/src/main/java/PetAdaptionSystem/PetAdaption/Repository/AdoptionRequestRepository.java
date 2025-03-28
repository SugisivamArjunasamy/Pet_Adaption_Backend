package PetAdaptionSystem.PetAdaption.Repository;

import PetAdaptionSystem.PetAdaption.Entity.AdoptionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AdoptionRequestRepository extends JpaRepository<AdoptionRequest, Long> {
    List<AdoptionRequest> findByStatus(AdoptionRequest.RequestStatus status);
    List<AdoptionRequest> findByUser_UserId(Long userId);
    List<AdoptionRequest> findByPet_PetId(Long petId);
}
