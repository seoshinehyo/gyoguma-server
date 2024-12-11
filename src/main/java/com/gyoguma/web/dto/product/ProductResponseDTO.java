package com.gyoguma.web.dto.product;

import com.gyoguma.domain.enums.ProductStatus;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class ProductResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegistProductResultDTO {
        Long productId;
        LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EditProductResultDTO {
        Long productId;
        LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetProductResultDTO { // 단일 상품 응답 DTO
        String title;
        String nickname;
        Integer price;
        Long locationId;
        String description;
        ProductStatus status;
        LocalDateTime createdAt;
        LocalDateTime updatedAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    public static class ShowProductDTO { // 전체 상품 응답 DTO
        String title;
        String nickname;
        Integer price;
        Long productId;
        Long categoryId;
        ProductStatus status;
        LocalDateTime createdAt;
        LocalDateTime updatedAt;

        @QueryProjection
        public ShowProductDTO(String title, String nickname, Integer price, Long productId, Long categoryId, ProductStatus status, LocalDateTime createdAt, LocalDateTime updatedAt) {
            this.title = title;
            this.nickname = nickname;
            this.price = price;
            this.productId = productId;
            this.categoryId = categoryId;
            this.status = status;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetProductListDTO { // 전체 상품 응답 DTO
        List<ShowProductDTO> productList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchProductResultDTO { // 상품 검색 응답 DTO
        List<ShowProductDTO> productList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberProductListDTO { // 특정 회원 등록 상품 응답 DTO
        List<ShowProductDTO> productList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }
}
