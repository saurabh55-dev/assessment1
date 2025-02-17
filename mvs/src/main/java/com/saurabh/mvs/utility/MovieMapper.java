package com.saurabh.mvs.utility;

import com.saurabh.mvs.dto.MovieDTO;
import com.saurabh.mvs.dto.ReviewDTO;
import com.saurabh.mvs.entity.Movie;
import com.saurabh.mvs.entity.Review;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapper {

    public MovieDTO toMovieDTO(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setTitle(movie.getTitle());
        movieDTO.setGenre(movie.getGenre());
        movieDTO.setReleaseYear(movie.getReleaseYear());

        List<ReviewDTO> reviewDTOs = movie.getReviews().stream()
                .map(this::toReviewDTO)
                .collect(Collectors.toList());
        movieDTO.setReviews(reviewDTOs);

        return movieDTO;
    }

    private ReviewDTO toReviewDTO(Review review) {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(review.getId());
        reviewDTO.setReviewerName(review.getReviewerName());
        reviewDTO.setComment(review.getComment());
        reviewDTO.setRating(review.getRating());

        return reviewDTO;
    }

}
