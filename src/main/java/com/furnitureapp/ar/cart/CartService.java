package com.furnitureapp.ar.cart;
import java.util.*;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.internal.bytebuddy.utility.JavaConstant.Dynamic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import com.furnitureapp.ar.cart.Dto.CartDetailsDto;
import com.furnitureapp.ar.cart.Dto.CartProductDto;
import com.furnitureapp.ar.products.Product;
import com.furnitureapp.ar.products.ProductRepo;
import com.furnitureapp.ar.users.UserRepo;


@Service
@Transactional
public class CartService {
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private ModelMapper modelMapper;


    public List<cartDetails> getCartDetails(){
        List<cartDetails> cartDetailsList = cartRepo.getUserCart();
        return cartDetailsList;
    }
    
    public CartDetailsDto addCartItem(CartDetailsDto cartDetailsDto){
        System.out.println("bbbbbbbbb");
       cartRepo.save(modelMapper.map(cartDetailsDto, cartDetails.class));
       return cartDetailsDto;
       //return modelMapper.map(cartDetailsList,  new TypeToken<List<Product>>(){}.getType());
    }
    public int deletecartItem (String userId, String productId){
        System.out.println(userId);
        System.out.println(productId);
        return  cartRepo.deleteCartItem(userId, productId);
    }
}
