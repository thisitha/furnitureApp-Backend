package com.furnitureapp.ar.cart.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartResponseDto {
  private  int Id;
  private int userId;
 //private   int productId;
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
    private String productQuantity;
}
