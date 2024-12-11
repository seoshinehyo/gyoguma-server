package com.gyoguma.service.review;

import com.gyoguma.domain.Member;

public interface ReviewCommandService {

    void changeRating(Member member, Double starRating);
}
