package com.ghebreamlak.firstjobproject.review.impl;

import com.ghebreamlak.firstjobproject.company.Company;
import com.ghebreamlak.firstjobproject.company.CompanyService;
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
    private CompanyService companyService;
    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Review addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyByID(companyId);
        review.setCompany(company);
        return reviewRepository.save(review);
    }
}
