package com.saurabh.mvs.dto;

import com.saurabh.mvs.entity.Review;

public class ReviewDTO {
    private int id;
    private String reviewerName;
    private String comment;
    private int rating;

    public ReviewDTO() {
    }

    public ReviewDTO(Review review) {
        this.id = review.getId();
        this.reviewerName = review.getReviewerName();
        this.comment = review.getComment();
        this.rating = review.getRating();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
