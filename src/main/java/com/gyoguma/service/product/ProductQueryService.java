package com.gyoguma.service.product;

import com.gyoguma.domain.Product;
import com.gyoguma.web.dto.product.ProductResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductQueryService {

    Product getProduct(Long productId);

    Page<Product> getProductList(Integer page);

    Page<ProductResponseDTO.ShowProductDTO> searchProducts(String keyword, Pageable pageable);
}
