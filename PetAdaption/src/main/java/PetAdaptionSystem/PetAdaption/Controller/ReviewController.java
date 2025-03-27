package PetAdaptionSystem.PetAdaption.Controller;

import PetAdaptionSystem.PetAdaption.Entity.Review;
import PetAdaptionSystem.PetAdaption.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;


    @PostMapping("/submit")
    public Review submitReview(@RequestBody Review review) {
        return reviewService.submitReview(review);
    }


    @GetMapping("/{breed}")
    public List<Review> getReviewsByBreed(@PathVariable String breed) {
        return reviewService.getReviewsByBreed(breed);
    }


    @GetMapping("/{breed}/average-rating")
    public double getAverageRating(@PathVariable String breed) {
        return reviewService.getAverageRating(breed);
    }
}
