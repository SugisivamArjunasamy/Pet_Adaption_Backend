package PetAdaptionSystem.PetAdaption.Controller;

import PetAdaptionSystem.PetAdaption.Entity.Pet;
import PetAdaptionSystem.PetAdaption.Service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable int id) {
        Optional<Pet> pet = petService.getPetById(id);
        return pet.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pet addPet(@RequestBody Pet pet) {
        return petService.addPet(pet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pet> deletePet(@PathVariable int id) {
        Optional<Pet> pet = petService.getPetById(id);
        if (pet.isPresent()) {
            petService.deletePet(id);
            return ResponseEntity.ok(pet.get()); // Return deleted pet as JSON
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Pet> updatePetPartially(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        Optional<Pet> updatedPet = petService.updatePetFields(id, updates);
        return updatedPet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
