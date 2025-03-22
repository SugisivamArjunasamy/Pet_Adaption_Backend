package PetAdaptionSystem.PetAdaption.Controller;

import PetAdaptionSystem.PetAdaption.Entity.Review;
import PetAdaptionSystem.PetAdaption.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Submit a review
    @PostMapping("/submit")
    public Review submitReview(@RequestBody Review review) {
        return reviewService.submitReview(review);
    }

    // Get all reviews for a breed
    @GetMapping("/{breed}")
    public List<Review> getReviewsByBreed(@PathVariable String breed) {
        return reviewService.getReviewsByBreed(breed);
    }

    // Get average rating for a breed
    @GetMapping("/{breed}/average-rating")
    public double getAverageRating(@PathVariable String breed) {
        return reviewService.getAverageRating(breed);
    }
}
