package PetAdaptionSystem.PetAdaption.Service;

import PetAdaptionSystem.PetAdaption.Entity.AdoptionRequest;
import PetAdaptionSystem.PetAdaption.Entity.Pet;
import PetAdaptionSystem.PetAdaption.Repository.AdoptionRequestRepository;
import PetAdaptionSystem.PetAdaption.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdoptionRequestService {

    @Autowired
    private AdoptionRequestRepository adoptionRequestRepository;

    @Autowired
    private PetRepository petRepository;

    // Create a new adoption request
    public AdoptionRequest createAdoptionRequest(AdoptionRequest request, int petId) {
        Pet pet = petRepository.findById((long) petId)
                .orElseThrow(() -> new RuntimeException("Pet not found"));

        request.setPet(pet);  // Set the existing pet
        request.setStatus("Pending");  // Default status
        return adoptionRequestRepository.save(request);
    }

    // Get all adoption requests
    public List<AdoptionRequest> getAllRequests() {
        return adoptionRequestRepository.findAll();
    }

    // Get adoption request by ID
    public AdoptionRequest getRequestById(int requestId) {
        return adoptionRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Adoption Request not found"));
    }

    // Get pending adoption requests
    public List<AdoptionRequest> getPendingRequests() {
        return adoptionRequestRepository.findByStatus("Pending");
    }

    // Approve or reject adoption request
    public AdoptionRequest updateRequestStatus(int requestId, String status) {
        AdoptionRequest request = adoptionRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Adoption Request not found"));

        request.setStatus(status);  // Update status (Approved or Rejected)
        return adoptionRequestRepository.save(request);
    }
}
