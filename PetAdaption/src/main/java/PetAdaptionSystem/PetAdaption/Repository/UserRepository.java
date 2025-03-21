package PetAdaptionSystem.PetAdaption.Repository;

import PetAdaptionSystem.PetAdaption.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
