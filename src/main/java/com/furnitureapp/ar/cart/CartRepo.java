package com.furnitureapp.ar.cart;

import org.modelmapper.internal.bytebuddy.utility.JavaConstant.Dynamic;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.furnitureapp.ar.cart.Dto.CartProductDto;
import com.furnitureapp.ar.products.Product;

import java.util.*;

import javax.transaction.Transactional;

public interface CartRepo  extends JpaRepository<cartDetails,Integer>{
    
    @Query(value ="SELECT * FROM cart_details",nativeQuery = true )
    public List<cartDetails> getUserCart();

    @Modifying
    @Query
    (value ="DELETE FROM cart_details WHERE user_id=:userId AND product_id=:productId",nativeQuery = true )
    public int deleteCartItem(@Param("userId") String userId, @Param("productId") String productIs);
}
