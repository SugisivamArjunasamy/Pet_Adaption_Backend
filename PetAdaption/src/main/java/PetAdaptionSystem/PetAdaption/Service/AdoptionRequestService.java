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


    public AdoptionRequest createAdoptionRequest(AdoptionRequest request, int petId) {
        Pet pet = petRepository.findById((long) petId)
                .orElseThrow(() -> new RuntimeException("Pet not found"));

        request.setPet(pet);
        request.setStatus("Pending");
        return adoptionRequestRepository.save(request);
    }


    public List<AdoptionRequest> getAllRequests() {
        return adoptionRequestRepository.findAll();
    }


    public AdoptionRequest getRequestById(int requestId) {
        return adoptionRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Adoption Request not found"));
    }


    public List<AdoptionRequest> getPendingRequests() {
        return adoptionRequestRepository.findByStatus("Pending");
    }


    public AdoptionRequest updateRequestStatus(int requestId, String status) {
        AdoptionRequest request = adoptionRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Adoption Request not found"));

        request.setStatus(status);
        return adoptionRequestRepository.save(request);
    }
}
