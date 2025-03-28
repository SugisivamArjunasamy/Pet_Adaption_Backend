package PetAdaptionSystem.PetAdaption.Service;

import PetAdaptionSystem.PetAdaption.Entity.AdoptionRequest;
import PetAdaptionSystem.PetAdaption.Entity.Pet;
import PetAdaptionSystem.PetAdaption.Entity.User;
import PetAdaptionSystem.PetAdaption.Repository.AdoptionRequestRepository;
import PetAdaptionSystem.PetAdaption.Repository.PetRepository;
import PetAdaptionSystem.PetAdaption.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdoptionRequestService {

    private final AdoptionRequestRepository adoptionRequestRepository;
    private final PetRepository petRepository;
    private final UserRepository userRepository;

    public AdoptionRequestService(
            AdoptionRequestRepository adoptionRequestRepository,
            PetRepository petRepository,
            UserRepository userRepository) {
        this.adoptionRequestRepository = adoptionRequestRepository;
        this.petRepository = petRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public AdoptionRequest createAdoptionRequest(Long petId, Long userId) {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new IllegalArgumentException("Pet not found with id: " + petId));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));

        AdoptionRequest request = new AdoptionRequest();
        request.setPet(pet);
        request.setUser(user);
        request.setStatus(AdoptionRequest.RequestStatus.PENDING);

        return adoptionRequestRepository.save(request);
    }

    @Transactional(readOnly = true)
    public List<AdoptionRequest> getAllRequests() {
        return adoptionRequestRepository.findAll();
    }

    @Transactional(readOnly = true)
    public AdoptionRequest getRequestById(Long requestId) {
        return adoptionRequestRepository.findById(requestId)
                .orElseThrow(() -> new IllegalArgumentException("Adoption Request not found with id: " + requestId));
    }

    @Transactional(readOnly = true)
    public List<AdoptionRequest> getPendingRequests() {
        return adoptionRequestRepository.findByStatus(AdoptionRequest.RequestStatus.PENDING);
    }

    @Transactional
    public AdoptionRequest updateRequestStatus(Long requestId, AdoptionRequest.RequestStatus status) {
        AdoptionRequest request = adoptionRequestRepository.findById(requestId)
                .orElseThrow(() -> new IllegalArgumentException("Adoption Request not found with id: " + requestId));

        request.setStatus(status);
        
        // If request is approved, update the pet's status and adopter
        if (status == AdoptionRequest.RequestStatus.APPROVED) {
            Pet pet = request.getPet();
            pet.setStatus(Pet.PetStatus.ADOPTED);
            pet.setAdoptedBy(request.getUser());
            petRepository.save(pet);
        }

        return adoptionRequestRepository.save(request);
    }
}
