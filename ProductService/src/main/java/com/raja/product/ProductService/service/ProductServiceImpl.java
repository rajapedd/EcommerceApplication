package com.raja.product.ProductService.service;

import com.raja.product.ProductService.entity.Product;
import com.raja.product.ProductService.error.ProductServiceCustomException;
import com.raja.product.ProductService.model.ProductRequest;
import com.raja.product.ProductService.model.ProductResponce;
import com.raja.product.ProductService.repository.ProductRepository;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductSerVice {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Long createProduct(ProductRequest productRequest) {
    log.info("Adding Product");
        Product product= Product.builder()
                .productName(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();
        productRepository.save(product);
        log.info("Created a Product");
        return product.getProductId();
    }

    @Override
    public ProductResponce getProductById(Long productId) {
        log.info("Get the Product With the ID: "+productId);
        Product product= productRepository.findById(productId)
                .orElseThrow(() -> new ProductServiceCustomException("The product Id is does not exist.", "PRODUCT_NOT_FOUND"));
        ProductResponce productResponce= new ProductResponce();
        BeanUtils.copyProperties(product,productResponce);
        log.info("Fetched the Product with ID: "+productId);
        return productResponce;
    }
}
