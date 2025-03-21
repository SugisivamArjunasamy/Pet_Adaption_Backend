package PetAdaptionSystem.PetAdaption.Repository;

import PetAdaptionSystem.PetAdaption.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {

}
