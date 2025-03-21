package PetAdaptionSystem.PetAdaption.Repository;

import PetAdaptionSystem.PetAdaption.Entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet,Integer> {

}
