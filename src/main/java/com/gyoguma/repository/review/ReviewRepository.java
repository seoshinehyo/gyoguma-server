package com.gyoguma.repository.review;

import com.gyoguma.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Double findByStarRating(Double starRating);
}
