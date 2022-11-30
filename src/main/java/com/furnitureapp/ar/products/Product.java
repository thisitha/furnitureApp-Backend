package com.furnitureapp.ar.products;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Product {
    @Id
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
