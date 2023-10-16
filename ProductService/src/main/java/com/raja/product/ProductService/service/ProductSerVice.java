package com.raja.product.ProductService.service;

import com.raja.product.ProductService.model.ProductRequest;
import com.raja.product.ProductService.model.ProductResponce;

public interface ProductSerVice {
    Long createProduct(ProductRequest productRequest);

    ProductResponce getProductById(Long productId);
}
