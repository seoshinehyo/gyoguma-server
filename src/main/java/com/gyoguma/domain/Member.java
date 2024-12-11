package com.gyoguma.domain;

import com.gyoguma.domain.common.BaseEntity;
import com.gyoguma.domain.enums.Gender;
import com.gyoguma.domain.enums.MemberStatus;
import com.gyoguma.domain.enums.Role;
import com.gyoguma.domain.mapping.ChatParticipate;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    String name; // 회원 이름

    @Column(nullable = false, length = 30)
    String email; // 회원 이메일

    @Column(nullable = false, length = 15)
    String password; // 회원 비밀번호

    @Enumerated(EnumType.STRING)
    Role role; // 회원 권한

    @Column(nullable = false, length = 20)
    String nickname; // 회원 닉네임

    @Column(nullable = false, length = 15)
    String phoneNumber; // 회원 전화번호

    @Column(nullable = false, length = 15)
    String studentNumber; // 회원 학번

    @ColumnDefault("3.5")
    Double rating; // 회원 학점(당근 온도와 같은 역할)

    @Enumerated(EnumType.STRING)
    Gender gender; // 회원 성별

    @Enumerated(EnumType.STRING)
    MemberStatus status; // 회원 상태

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Product> productList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<ReviewAlarm> reviewAlarmList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<ChatAlarm> chatAlarmList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<ChatParticipate> chatParticipateListList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<ChatMessage> chatMessageListList = new ArrayList<>();


    //==연관관계 메서드==// - 로직상 양쪽을 다 구현
    public void setMemberRating(Double changeRating) {
        this.rating += changeRating;
    }


}
