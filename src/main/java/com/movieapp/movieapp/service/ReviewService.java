package com.movieapp.movieapp.service;

import com.movieapp.movieapp.entity.Movie;
import com.movieapp.movieapp.entity.Review;
import com.movieapp.movieapp.entity.User;
import com.movieapp.movieapp.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserService userService;
    private final MovieService movieService;

    public ReviewService(ReviewRepository reviewRepository, UserService userService, MovieService movieService) {
        this.reviewRepository = reviewRepository;
        this.userService = userService;
        this.movieService = movieService;
    }

    public Review addReview(String username, Long movieId, String content) {
        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("Review content cannot be empty");
        }
        
        if (content.length() > 1000) {
            throw new IllegalArgumentException("Review content cannot exceed 1000 characters");
        }

        User user = userService.getUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        Movie movie = movieService.getMovieById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        Review review = Review.builder()
                .user(user)
                .movie(movie)
                .content(content.trim())
                .build();

        return reviewRepository.save(review);
    }

    public List<Review> getMovieReviews(Long movieId) {
        // Verify movie exists
        movieService.getMovieById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
                
        return reviewRepository.findByMovieIdOrderByCreatedAtDesc(movieId);
    }

    public List<Review> getUserReviews(String username) {
        User user = userService.getUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
                
        return reviewRepository.findByUserIdOrderByCreatedAtDesc(user.getId());
    }

    public Long getReviewCountForMovie(Long movieId) {
        return reviewRepository.countByMovieId(movieId);
    }

    public Optional<Review> getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId);
    }

    public void deleteReview(Long reviewId, String username) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found"));
                
        User user = userService.getUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Only allow user to delete their own review or admin to delete any review
        if (!review.getUser().getId().equals(user.getId()) && !user.getRole().name().equals("ADMIN")) {
            throw new RuntimeException("Unauthorized: You can only delete your own reviews");
        }

        reviewRepository.delete(review);
    }
}