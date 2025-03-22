package PetAdaptionSystem.PetAdaption.Controller;

import PetAdaptionSystem.PetAdaption.Entity.Pet;
import PetAdaptionSystem.PetAdaption.Service.AdoptionService;
import  PetAdaptionSystem.PetAdaption.Entity.Adoption;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/{id}/adopt")
public class AdoptionController {

    private final AdoptionService adoptionService;

    public AdoptionController(AdoptionService adoptionService){
        this.adoptionService = adoptionService;
    }

    @GetMapping
    public List<Adoption> getAllPets() {
        return adoptionService.getAllPets();
    }
}
