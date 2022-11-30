package com.furnitureapp.ar.cart.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartDetailsDto {
   int Id;
   int userId;
    int productId;
}
