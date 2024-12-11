package com.gyoguma.service.product;

import com.gyoguma.domain.Category;
import com.gyoguma.domain.Location;
import com.gyoguma.domain.Product;
import com.gyoguma.repository.product.ProductRepository;
import com.gyoguma.web.dto.product.ProductRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductCommandServiceImpl implements ProductCommandService {

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public Product registProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public void editProduct(ProductRequestDTO.EditProductDTO request, Product product, Category category, Location location) {
        product.updateProduct(request.getTitle(), request.getDescription(), request.getPrice(), category, location);
    }

    @Override
    @Transactional
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}
