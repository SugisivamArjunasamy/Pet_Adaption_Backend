package PetAdaptionSystem.PetAdaption.Controller;

import PetAdaptionSystem.PetAdaption.Entity.AdoptionRequest;
import PetAdaptionSystem.PetAdaption.Service.AdoptionRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adoption-requests")
public class AdoptionRequestController {

    @Autowired
    private AdoptionRequestService adoptionRequestService;

    // Create a new adoption request
    @PostMapping("/create")
    public AdoptionRequest createRequest(@RequestBody AdoptionRequest request, @RequestParam int petId) {
        return adoptionRequestService.createAdoptionRequest(request, petId);
    }

    // Get all adoption requests
    @GetMapping("/all")
    public List<AdoptionRequest> getAllRequests() {
        return adoptionRequestService.getAllRequests();
    }

    // Get a specific adoption request by ID
    @GetMapping("/{id}")
    public AdoptionRequest getRequestById(@PathVariable int id) {
        return adoptionRequestService.getRequestById(id);
    }

    // Get pending adoption requests
    @GetMapping("/pending")
    public List<AdoptionRequest> getPendingRequests() {
        return adoptionRequestService.getPendingRequests();
    }

    // Approve or reject an adoption request
    @PutMapping("/{id}/status")
    public AdoptionRequest updateRequestStatus(@PathVariable int id, @RequestParam String status) {
        return adoptionRequestService.updateRequestStatus(id, status);
    }
}
