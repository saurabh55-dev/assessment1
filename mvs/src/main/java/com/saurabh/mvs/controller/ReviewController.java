package com.saurabh.mvs.controller;

import com.saurabh.mvs.entity.Review;
import com.saurabh.mvs.service.ReviewService;
import org.springframework.web.bind.annotation.*;


@RestController @RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    //update review for a movie
    @PutMapping("/{reviewId}")
    public Review updateReview(@PathVariable int reviewId, @RequestBody Review updatedReview) {
        return reviewService.updateReview(reviewId, updatedReview);
    }

}
