package PetAdaptionSystem.PetAdaption.Service;

import PetAdaptionSystem.PetAdaption.Entity.Pet;
import PetAdaptionSystem.PetAdaption.Repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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
        return petRepository.findById((long) id);
    }

    public Pet addPet(Pet pet) {
        return petRepository.save(pet);
    }

    public void deletePet(int id) {
        petRepository.deleteById((long) id);
    }

    public Optional<Pet> updatePetFields(int id, Map<String, Object> updates) {
        Optional<Pet> optionalPet = petRepository.findById((long) id);
        if (optionalPet.isPresent()) {
            Pet pet = optionalPet.get();

            updates.forEach((key, value) -> {
                switch (key) {
                    case "petName": pet.setPetName((String) value); break;
                    case "petAge": pet.setPetAge((Integer) value); break;
                    case "catogori": pet.setCategory((String) value); break;
                    case "bread": pet.setBreed((String) value); break;
                    case "discription": pet.setDescription((String) value); break;
                    case "status": pet.setStatus((String) value); break;
                    case "amount": pet.setAmount((Integer) value); break;
                }
            });

            return Optional.of(petRepository.save(pet));
        }
        return Optional.empty();
    }
}
