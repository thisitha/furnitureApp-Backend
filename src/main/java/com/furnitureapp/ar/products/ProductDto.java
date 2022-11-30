package com.furnitureapp.ar.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {
    private int productId;
    private String productName;
    private String productColor;
    private String productType;
    private String productImage1;
    private String productImage2;
    private String productImage3;
    private String productPrice;
    private String productTag;
    private String productDescription;
    private Boolean productBestOffer;
}
