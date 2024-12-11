package com.gyoguma.service.product;

import com.gyoguma.domain.Category;
import com.gyoguma.domain.Location;
import com.gyoguma.domain.Product;
import com.gyoguma.web.dto.product.ProductRequestDTO;

public interface ProductCommandService {

    Product registProduct(Product product);

    void editProduct(ProductRequestDTO.EditProductDTO request, Product product, Category category, Location location);

    void deleteProduct(Product product);
}
