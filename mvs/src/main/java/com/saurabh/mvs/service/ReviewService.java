package com.saurabh.mvs.service;

import com.saurabh.mvs.entity.Movie;
import com.saurabh.mvs.entity.Review;
import com.saurabh.mvs.repository.MovieRepository;
import com.saurabh.mvs.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review updateReview(int reviewId, Review updatedReview) {
        Optional<Review> existingReview = reviewRepository.findById(reviewId);
        if (existingReview.isPresent()) {
            Review review = existingReview.get();
            review.setComment(updatedReview.getComment());
            review.setRating(updatedReview.getRating());
            return reviewRepository.save(review);
        } else {
            throw new RuntimeException("Review not found with ID: " + reviewId);
        }
    }
}
