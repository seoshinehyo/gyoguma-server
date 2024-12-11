package com.gyoguma.converter;

import com.gyoguma.domain.Member;
import com.gyoguma.web.dto.member.MemberResponseDTO;

public class MemberConverter {

    public static MemberResponseDTO.GetMemberDTO toGetMemberResultDTO(Member member) {
        return MemberResponseDTO.GetMemberDTO.builder()
                .nickname(member.getNickname())
                .rating(member.getRating())
                .build();
    }
}
