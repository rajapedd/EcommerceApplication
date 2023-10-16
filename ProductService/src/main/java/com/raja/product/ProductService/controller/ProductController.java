package com.raja.product.ProductService.controller;

import com.raja.product.ProductService.model.ProductRequest;
import com.raja.product.ProductService.model.ProductResponce;
import com.raja.product.ProductService.service.ProductSerVice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductSerVice productSerVice;


    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){
        Long productId= productSerVice.createProduct(productRequest);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductResponce> getProductById(@PathVariable(name = "id") Long productId){
        ProductResponce productResponce= productSerVice.getProductById(productId);
        return new ResponseEntity<>(productResponce,HttpStatus.OK);
    }
}
