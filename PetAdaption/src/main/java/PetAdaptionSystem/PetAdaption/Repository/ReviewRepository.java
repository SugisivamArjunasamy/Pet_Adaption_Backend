package PetAdaptionSystem.PetAdaption.Repository;

import PetAdaptionSystem.PetAdaption.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByBreed(String breed);

    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.breed = :breed")
    double getAverageRatingByBreed(String breed);
}
