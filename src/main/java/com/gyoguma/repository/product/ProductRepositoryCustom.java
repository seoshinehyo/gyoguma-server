package com.gyoguma.repository.product;

import com.gyoguma.web.dto.product.ProductResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductRepositoryCustom {

    Page<ProductResponseDTO.ShowProductDTO> getSearchProductList(String keyword, Pageable pageable);
}
