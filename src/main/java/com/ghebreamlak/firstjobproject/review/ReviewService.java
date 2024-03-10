package com.ghebreamlak.firstjobproject.review;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewService {
   List<Review> getAllReviews(Long copanyId);

   Review addReview(Long companyId, Review review);
}
