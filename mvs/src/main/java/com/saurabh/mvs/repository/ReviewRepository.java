package com.saurabh.mvs.repository;

import com.saurabh.mvs.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    //custom query method
    List<Review> findByMovieId(int movieId);    //find reviews by movie Id
}
