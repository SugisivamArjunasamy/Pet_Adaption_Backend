package PetAdaptionSystem.PetAdaption.Service;

import PetAdaptionSystem.PetAdaption.Entity.Pet;
import PetAdaptionSystem.PetAdaption.Repository.PetRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Optional<Pet> getPetById(int id) {
        return petRepository.findById(id);
    }

    public Pet addPet(Pet pet) {
        return petRepository.save(pet);
    }

    public void deletePet(int id) {
        petRepository.deleteById(id);
    }
}
