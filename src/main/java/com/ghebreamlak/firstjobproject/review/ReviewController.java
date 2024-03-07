package com.ghebreamlak.firstjobproject.review;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
@AllArgsConstructor
public class ReviewController {
    private ReviewService reviewService;
    public <T>ResponseEntity<T> getAllReviews(){
        return (ResponseEntity<T>) reviewService.getAllReviews();
    }
}
