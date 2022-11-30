package com.furnitureapp.ar.cart;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class cartDetails {
    @Id
    @GeneratedValue
    private int Id;
    private int userId;
    private int productId;
    
}
