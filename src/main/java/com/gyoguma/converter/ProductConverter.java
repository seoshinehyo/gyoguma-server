package com.gyoguma.converter;

import com.gyoguma.domain.Category;
import com.gyoguma.domain.Location;
import com.gyoguma.domain.Member;
import com.gyoguma.domain.Product;
import com.gyoguma.web.dto.product.ProductRequestDTO;
import com.gyoguma.web.dto.product.ProductResponseDTO;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.stream.Collectors;

public class ProductConverter {

    public static Product toRegistProduct(ProductRequestDTO.RegistProductDTO request, Member member, Category category, Location location) { // 등록 받아오기
        return Product.builder()
                .member(member)
                .category(category)
                .title(request.getTitle())
                .description(request.getDescription())
                .price(request.getPrice())
                .location(location)
                .build();
    }

    public static Product toEditProduct(ProductRequestDTO.EditProductDTO request, Member member, Category category, Location location) { // 수정 받아오기
        return Product.builder()
                .member(member)
                .category(category)
                .title(request.getTitle())
                .description(request.getDescription())
                .price(request.getPrice())
                .location(location)
                .build();
    }

    public static ProductResponseDTO.RegistProductResultDTO toRegistProductResultDTO(Product product) { // 상품 등록 결과
        return ProductResponseDTO.RegistProductResultDTO.builder()
                .productId(product.getId())
                .createdAt(product.getCreatedAt())
                .build();
    }

    public static ProductResponseDTO.EditProductResultDTO toEditProductResultDTO(Product product) { // 상품 수정 결과
        return ProductResponseDTO.EditProductResultDTO.builder()
                .productId(product.getId())
                .createdAt(product.getCreatedAt())
                .build();
    }

    public static ProductResponseDTO.GetProductResultDTO toProductResultDTO(Product product) { // 특정 상품 조회 결과
        Member member = product.getMember();
        Long locationId = product.getLocation().getId();

        return ProductResponseDTO.GetProductResultDTO.builder()
                .title(product.getTitle())
                .nickname(member.getNickname())
                .price(product.getPrice())
                .locationId(locationId)
                .description(product.getDescription())
                .status(product.getStatus())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }

    public static ProductResponseDTO.ShowProductDTO toShowProductDTO(Product product) { // 상품 썸네일 정보
        Member member = product.getMember();
        Category category = product.getCategory();

        return ProductResponseDTO.ShowProductDTO.builder()
                .title(product.getTitle())
                .nickname(member.getNickname())
                .price(product.getPrice())
                .productId(product.getId())
                .categoryId(category.getId())
                .status(product.getStatus())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }

    public static ProductResponseDTO.GetProductListDTO toProductListDTO(Page<Product> productPage) { // 특정 회원이 올린 상품 목록
        List<ProductResponseDTO.ShowProductDTO> productDTOList = productPage.stream()
                .map(ProductConverter::toShowProductDTO).collect(Collectors.toList());

        return ProductResponseDTO.GetProductListDTO.builder()
                .isLast(productPage.isLast())
                .isFirst(productPage.isFirst())
                .totalPage(productPage.getTotalPages())
                .totalElements(productPage.getTotalElements())
                .listSize(productDTOList.size())
                .productList(productDTOList)
                .build();
    }

    public static ProductResponseDTO.SearchProductResultDTO toSearchProductListDTO(Page<ProductResponseDTO.ShowProductDTO> searchProductPage) { // 검색 상품
        return ProductResponseDTO.SearchProductResultDTO.builder()
                .isLast(searchProductPage.isLast())
                .isFirst(searchProductPage.isFirst())
                .totalPage(searchProductPage.getTotalPages())
                .totalElements(searchProductPage.getTotalElements())
                .listSize(searchProductPage.getNumberOfElements())
                .productList(searchProductPage.getContent())
                .build();
    }

    public static ProductResponseDTO.MemberProductListDTO toMemberProductListDTO(Page<Product> productPage) { // 특정 회원이 올린 상품 목록
        List<ProductResponseDTO.ShowProductDTO> productDTOList = productPage.stream()
                .map(ProductConverter::toShowProductDTO).collect(Collectors.toList());

        return ProductResponseDTO.MemberProductListDTO.builder()
                .isLast(productPage.isLast())
                .isFirst(productPage.isFirst())
                .totalPage(productPage.getTotalPages())
                .totalElements(productPage.getTotalElements())
                .listSize(productDTOList.size())
                .productList(productDTOList)
                .build();
    }
}
