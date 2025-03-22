package PetAdaptionSystem.PetAdaption.Service;

import PetAdaptionSystem.PetAdaption.Entity.Adoption;
import PetAdaptionSystem.PetAdaption.Entity.Pet;
import PetAdaptionSystem.PetAdaption.Repository.AdoptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AdoptionService {
    private final AdoptionRepository adoptionRepository;

    public AdoptionService(AdoptionRepository adoptionRepository){this.adoptionRepository = adoptionRepository;}

    public List<Adoption> getAllPets() {
        return adoptionRepository.findAll();
    }

}
