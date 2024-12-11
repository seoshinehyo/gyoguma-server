package com.gyoguma.config.security;//package _bit.gyoguma.config.security;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Service;
//import umc.spring.domain.Member;
//import umc.spring.domain.enums.Gender;
//import umc.spring.domain.enums.Role;
//import umc.spring.repository.member.MemberRepository;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
//@Service
//@RequiredArgsConstructor
//public class CustomOAuth2UserService extends DefaultOAuth2UserService {
//
//    private final MemberRepository memberRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//        OAuth2User oAuth2User = super.loadUser(userRequest);
//        String registrationId = userRequest.getClientRegistration().getRegistrationId();
//        Map<String, Object> attributes = oAuth2User.getAttributes();
//
//        // 제공자별로 nickname과 email 추출
//        Map<String, String> userInfo = extractUserInfo(registrationId, attributes);
//        String email = userInfo.get("email");
//        String nickname = userInfo.get("nickname");
//
//        // 사용자 정보 저장 또는 업데이트
//        Member member = saveOrUpdateUser(email, nickname);
//
//        // 이메일을 Principal로 사용하기 위해 attributes 수정
//        Map<String, Object> modifiedAttributes = new HashMap<>(attributes);
//        modifiedAttributes.put("email", email);
//
//        return new DefaultOAuth2User(
//                oAuth2User.getAuthorities(),
//                modifiedAttributes,
//                "email" // email을 Principal로 설정
//        );
//    }
//
//    private Map<String, String> extractUserInfo(String registrationId, Map<String, Object> attributes) {
//        String nickname;
//        String email;
//
//        switch (registrationId) {
//            case "kakao":
//                Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
//                Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");
//                nickname = (String) properties.get("nickname");
//                email = kakaoAccount != null && kakaoAccount.get("email") != null
//                        ? (String) kakaoAccount.get("email")
//                        : nickname + "@kakao.com"; // 이메일이 없으면 임시 생성
//                break;
//            case "google":
//                nickname = (String) attributes.get("name");
//                email = (String) attributes.get("email");
//                break;
//            case "naver":
//                Map<String, Object> response = (Map<String, Object>) attributes.get("response");
//                nickname = (String) response.get("nickname");
//                email = (String) response.get("email");
//                break;
//            default:
//                throw new OAuth2AuthenticationException("Unsupported provider: " + registrationId);
//        }
//
//        Map<String, String> userInfo = new HashMap<>();
//        userInfo.put("nickname", nickname);
//        userInfo.put("email", email);
//
//        return userInfo;
//    }
//
//    private Member saveOrUpdateUser(String email, String nickname) {
//        Member member = memberRepository.findByEmail(email)
//                .orElse(Member.builder()
//                        .email(email)
//                        .name(nickname)
//                        .password(passwordEncoder.encode("OAUTH_USER_" + UUID.randomUUID()))
//                        .gender(Gender.NONE)  // 기본값 설정
//                        .address("소셜로그인")  // 기본값 설정
//                        .specAddress("소셜로그인")  // 기본값 설정
//                        .role(Role.USER)
//                        .build());
//
//        return memberRepository.save(member);
//    }
//}