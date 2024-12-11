package com.gyoguma.service.product;

import com.gyoguma.domain.Product;
import com.gyoguma.repository.product.ProductRepository;
import com.gyoguma.web.dto.product.ProductResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductQueryServiceImpl implements ProductQueryService {

    private final ProductRepository productRepository;

    @Override
    public Product getProduct(Long productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public Page<Product> getProductList(Integer page) {
        return productRepository.findAll(PageRequest.of(page, 10));
    }

    @Override
    public Page<ProductResponseDTO.ShowProductDTO> searchProducts(String keyword, Pageable pageable) {
        Page<ProductResponseDTO.ShowProductDTO> searchProductPage = productRepository.getSearchProductList(keyword, pageable);
        return searchProductPage;
    }
}