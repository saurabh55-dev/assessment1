package com.saurabh.mvs.controller;

import com.saurabh.mvs.dto.MovieDTO;
import com.saurabh.mvs.entity.Movie;
import com.saurabh.mvs.entity.Review;
import com.saurabh.mvs.service.MovieService;
import com.saurabh.mvs.service.ReviewService;
import com.saurabh.mvs.utility.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController @RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    @Autowired
    private MovieMapper movieMapper;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    //get all movies with their reviews
    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMoviesWithReviews() {
        List<Movie> movies = movieService.findAllMovies();  // Fetch all movies from the database
        List<MovieDTO> movieDTOs = movies.stream()
                .map(movie -> movieMapper.toMovieDTO(movie)) // Convert each movie to MovieDTO
                .collect(Collectors.toList()); // Collect all MovieDTOs in a list
        return ResponseEntity.ok(movieDTOs); // Return list of MovieDTOs
    }

    //add movie
    @PostMapping
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

    //add a review to movie
    @PostMapping("/{movieId}/reviews")
    public Review addReviewToMovie(@PathVariable int movieId, @RequestBody Review review) {
        return movieService.addReview(movieId, review);
    }
}
