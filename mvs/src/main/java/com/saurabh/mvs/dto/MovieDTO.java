package com.saurabh.mvs.dto;

import com.saurabh.mvs.entity.Movie;

import java.util.List;
import java.util.stream.Collectors;

public class MovieDTO {

    private int id;
    private String title;
    private String genre;
    private int releaseYear;
    private List<ReviewDTO> reviews;        //include only review information here

    public MovieDTO() {
    }

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.genre = movie.getGenre();
        this.releaseYear = movie.getReleaseYear();
        this.reviews = movie.getReviews().stream().map(ReviewDTO::new).collect(Collectors.toList());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<ReviewDTO> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewDTO> reviews) {
        this.reviews = reviews;
    }
}
