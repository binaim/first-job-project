package com.ghebreamlak.firstjobproject.company;

import com.ghebreamlak.firstjobproject.job.Job;
import com.ghebreamlak.firstjobproject.review.Review;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Job> jobs;
//    @OneToMany(mappedBy = "company", cascade = CascadeType.PERSIST)
//    private List<Review> reviews;


}
