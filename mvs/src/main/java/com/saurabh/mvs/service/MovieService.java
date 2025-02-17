package com.saurabh.mvs.service;

import com.saurabh.mvs.entity.Movie;
import com.saurabh.mvs.entity.Review;
import com.saurabh.mvs.repository.MovieRepository;
import com.saurabh.mvs.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;

    public MovieService(MovieRepository movieRepository, ReviewRepository reviewRepository) {
        this.movieRepository = movieRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Review addReview(int movieId, Review review) {
        Optional<Movie> movieOptional = movieRepository.findById(movieId);
        if (movieOptional.isPresent()) {
            Movie movie = movieOptional.get();
            review.setMovie(movie); // Associate review with the movie
            return reviewRepository.save(review);
        } else {
            throw new RuntimeException("Movie not found with ID: " + movieId);
        }
    }
    public List<Movie> findAllMovies() {
        return movieRepository.findAll(); // Assuming you're using JPA Repository
    }

}
