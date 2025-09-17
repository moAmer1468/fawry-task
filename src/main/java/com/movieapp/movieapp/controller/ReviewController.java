package com.movieapp.movieapp.controller;

import com.movieapp.movieapp.entity.Review;
import com.movieapp.movieapp.service.ReviewService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addReview(@RequestBody ReviewRequest request) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Review review = reviewService.addReview(username, request.getMovieId(), request.getContent());
        
        Map<String, Object> response = new HashMap<>();
        response.put("id", review.getId());
        response.put("movieId", review.getMovie().getId());
        response.put("username", review.getUser().getUsername());
        response.put("content", review.getContent());
        response.put("createdAt", review.getCreatedAt());
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Map<String, Object>>> getMovieReviews(@PathVariable Long movieId) {
        List<Review> reviews = reviewService.getMovieReviews(movieId);
        
        List<Map<String, Object>> response = reviews.stream().map(review -> {
            Map<String, Object> reviewMap = new HashMap<>();
            reviewMap.put("id", review.getId());
            reviewMap.put("movieId", review.getMovie().getId());
            reviewMap.put("username", review.getUser().getUsername());
            reviewMap.put("content", review.getContent());
            reviewMap.put("createdAt", review.getCreatedAt());
            return reviewMap;
        }).toList();
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user")
    public ResponseEntity<List<Map<String, Object>>> getUserReviews() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Review> reviews = reviewService.getUserReviews(username);
        
        List<Map<String, Object>> response = reviews.stream().map(review -> {
            Map<String, Object> reviewMap = new HashMap<>();
            reviewMap.put("id", review.getId());
            reviewMap.put("movieId", review.getMovie().getId());
            reviewMap.put("movieTitle", review.getMovie().getTitle());
            reviewMap.put("username", review.getUser().getUsername());
            reviewMap.put("content", review.getContent());
            reviewMap.put("createdAt", review.getCreatedAt());
            return reviewMap;
        }).toList();
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("/movie/{movieId}/count")
    public ResponseEntity<Map<String, Long>> getMovieReviewCount(@PathVariable Long movieId) {
        Long count = reviewService.getReviewCountForMovie(movieId);
        return ResponseEntity.ok(Map.of("count", count));
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        reviewService.deleteReview(reviewId, username);
        return ResponseEntity.noContent().build();
    }

    @Data
    public static class ReviewRequest {
        private Long movieId;
        private String content;
    }
}