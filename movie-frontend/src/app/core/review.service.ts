import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

export interface Review {
  id?: number;
  movieId: number;
  userId?: number;
  username?: string;
  content: string;
  createdAt?: string;
}

@Injectable({ providedIn: 'root' })
export class ReviewService {
  constructor(private http: HttpClient) {}

  // Get all reviews for a movie
  getMovieReviews(movieId: number): Observable<Review[]> {
    return this.http.get<Review[]>(`${environment.apiBaseUrl}/api/reviews/movie/${movieId}`);
  }

  // Add a review for a movie
  addReview(review: Review): Observable<Review> {
    return this.http.post<Review>(`${environment.apiBaseUrl}/api/reviews`, {
      movieId: review.movieId,
      content: review.content
    });
  }

  // Get reviews by current user
  getUserReviews(): Observable<Review[]> {
    return this.http.get<Review[]>(`${environment.apiBaseUrl}/api/reviews/user`);
  }

  // Get review count for a movie
  getMovieReviewCount(movieId: number): Observable<{count: number}> {
    return this.http.get<{count: number}>(`${environment.apiBaseUrl}/api/reviews/movie/${movieId}/count`);
  }

  // Delete a review
  deleteReview(reviewId: number): Observable<void> {
    return this.http.delete<void>(`${environment.apiBaseUrl}/api/reviews/${reviewId}`);
  }
}
