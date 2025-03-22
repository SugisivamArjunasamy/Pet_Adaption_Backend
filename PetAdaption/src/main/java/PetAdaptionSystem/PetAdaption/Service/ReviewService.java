package PetAdaptionSystem.PetAdaption.Service;

import PetAdaptionSystem.PetAdaption.Entity.Review;
import PetAdaptionSystem.PetAdaption.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // Submit a review
    public Review submitReview(Review review) {
        return reviewRepository.save(review);
    }

    // Get reviews for a specific breed
    public List<Review> getReviewsByBreed(String breed) {
        return reviewRepository.findByBreed(breed);
    }

    // Get average rating for a breed
    public double getAverageRating(String breed) {
        return reviewRepository.getAverageRatingByBreed(breed);
    }
}
