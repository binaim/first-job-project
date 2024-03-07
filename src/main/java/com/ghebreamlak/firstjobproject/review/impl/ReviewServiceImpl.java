package com.ghebreamlak.firstjobproject.review.impl;

import com.ghebreamlak.firstjobproject.review.Review;
import com.ghebreamlak.firstjobproject.review.ReviewRepository;
import com.ghebreamlak.firstjobproject.review.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;
    @Override
    public List<Review> getAllReviews() {
        return null;
    }
}
