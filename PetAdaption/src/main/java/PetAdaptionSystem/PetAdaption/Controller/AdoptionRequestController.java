package PetAdaptionSystem.PetAdaption.Controller;

import PetAdaptionSystem.PetAdaption.Entity.AdoptionRequest;
import PetAdaptionSystem.PetAdaption.Service.AdoptionRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/adoption-requests")
public class AdoptionRequestController {

    @Autowired
    private AdoptionRequestService adoptionRequestService;


    @PostMapping("/create")
    public AdoptionRequest createRequest(@RequestBody AdoptionRequest request, @RequestParam int petId) {
        return adoptionRequestService.createAdoptionRequest(request, petId);
    }


    @GetMapping("/all")
    public List<AdoptionRequest> getAllRequests() {
        return adoptionRequestService.getAllRequests();
    }


    @GetMapping("/{id}")
    public AdoptionRequest getRequestById(@PathVariable int id) {
        return adoptionRequestService.getRequestById(id);
    }


    @GetMapping("/pending")
    public List<AdoptionRequest> getPendingRequests() {
        return adoptionRequestService.getPendingRequests();
    }


    @PutMapping("/{id}/status")
    public AdoptionRequest updateRequestStatus(@PathVariable int id, @RequestParam String status) {
        return adoptionRequestService.updateRequestStatus(id, status);
    }
}
