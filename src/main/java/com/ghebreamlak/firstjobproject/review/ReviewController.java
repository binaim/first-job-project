package com.ghebreamlak.firstjobproject.review;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("companies/companyId")
@AllArgsConstructor
public class ReviewController {
    private ReviewService reviewService;
    @GetMapping("/reviews")
    public <T>ResponseEntity<T> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<T>((T) reviewService.getAllReviews(companyId), HttpStatus.OK);
    }
    @PostMapping
    public <T> ResponseEntity<T> addReview(@PathVariable Long companyId, @RequestBody Review review){
        return new ResponseEntity<T>((T) reviewService.addReview(companyId, review), HttpStatus.OK);
    }
}
