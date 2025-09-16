package com.movieapp.movieapp.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "ratings",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "movie_id"})
)
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @Column(nullable = false)
    private int rating; // 1-10

    // ---------------- Constructors ----------------

    public Rating() {
    }

    public Rating(Long id, User user, Movie movie, int rating) {
        this.id = id;
        this.user = user;
        this.movie = movie;
        this.rating = rating;
    }

    // ---------------- Getters and Setters ----------------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    // ---------------- toString ----------------

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", user=" + (user != null ? user.getId() : null) +
                ", movie=" + (movie != null ? movie.getId() : null) +
                ", rating=" + rating +
                '}';
    }

    // ---------------- Builder ----------------

    public static class Builder {
        private Long id;
        private User user;
        private Movie movie;
        private int rating;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder movie(Movie movie) {
            this.movie = movie;
            return this;
        }

        public Builder rating(int rating) {
            this.rating = rating;
            return this;
        }

        public Rating build() {
            return new Rating(id, user, movie, rating);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
