package com.movieapp.movieapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    // ✅ تغيير الاسم من year -> release_year في الـ DB
    @Column(name = "release_year")
    private String year;

    @Column(unique = true, nullable = false)
    private String imdbId;

    private String type;

    private String posterUrl;

    private String genre;

    private String director;

    private String actors;

    private String plot;

    // ---------------- Constructors ----------------

    public Movie() {
    }

    public Movie(Long id, String title, String year, String imdbId, String type,
                 String posterUrl, String genre, String director,
                 String actors, String plot) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.imdbId = imdbId;
        this.type = type;
        this.posterUrl = posterUrl;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.plot = plot;
    }

    // ---------------- Getters and Setters ----------------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    public String getImdbId() { return imdbId; }
    public void setImdbId(String imdbId) { this.imdbId = imdbId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getPosterUrl() { return posterUrl; }
    public void setPosterUrl(String posterUrl) { this.posterUrl = posterUrl; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public String getActors() { return actors; }
    public void setActors(String actors) { this.actors = actors; }

    public String getPlot() { return plot; }
    public void setPlot(String plot) { this.plot = plot; }

    // ---------------- toString ----------------

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", imdbId='" + imdbId + '\'' +
                ", type='" + type + '\'' +
                ", posterUrl='" + posterUrl + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", actors='" + actors + '\'' +
                ", plot='" + plot + '\'' +
                '}';
    }

    // ---------------- Builder ----------------
    public static class Builder {
        private Long id;
        private String title;
        private String year;
        private String imdbId;
        private String type;
        private String posterUrl;
        private String genre;
        private String director;
        private String actors;
        private String plot;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder year(String year) {
            this.year = year;
            return this;
        }

        public Builder imdbId(String imdbId) {
            this.imdbId = imdbId;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder posterUrl(String posterUrl) {
            this.posterUrl = posterUrl;
            return this;
        }

        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder director(String director) {
            this.director = director;
            return this;
        }

        public Builder actors(String actors) {
            this.actors = actors;
            return this;
        }

        public Builder plot(String plot) {
            this.plot = plot;
            return this;
        }

        public Movie build() {
            return new Movie(id, title, year, imdbId, type, posterUrl, genre, director, actors, plot);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
