package com.raja.product.ProductService.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponce {
    private String productName;
    private long price;
    private long quantity;
    private long productId;

}
