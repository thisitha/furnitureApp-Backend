package com.furnitureapp.ar.cart;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.furnitureapp.ar.cart.Dto.CartDetailsDto;
import com.furnitureapp.ar.cart.Dto.CartProductDto;
import com.furnitureapp.ar.cart.Dto.CartResponseDto;
import com.furnitureapp.ar.products.Product;
import com.furnitureapp.ar.products.ProductDto;
import com.furnitureapp.ar.products.ProductService;

@RestController
@CrossOrigin
@RequestMapping(value="api/v1/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;

    @GetMapping("/getCart")
    public ResponseEntity<Object> getCart(@RequestParam String cartType){
        System.out.println(cartType);
        List<cartDetails> cartList = cartService.getCartDetails();
        
        
        Map<String, Object> map = new HashMap<String, Object>();
      
        
       
        Map<String, Object> productmap = new HashMap<String, Object>();
        List<CartResponseDto> responseList = new ArrayList<>();
        
        
      
            
        
            for(int i=0; cartList.size() >i; i++){
               
    
               System.out.println(cartList.get(i).getProductId());
               CartResponseDto responseObject = new CartResponseDto();


               responseObject.setId(cartList.get(i).getId());
               responseObject.setUserId(cartList.get(i).getUserId());

               responseObject.setProductId(cartList.get(i).getProductId());
               responseObject.setProductName(productService.getProductByID(cartList.get(i).getProductId()).get(0).getProductName());
               responseObject.setProductColor(productService.getProductByID(cartList.get(i).getProductId()).get(0).getProductColor());
               responseObject.setProductType(productService.getProductByID(cartList.get(i).getProductId()).get(0).getProductType());
               responseObject.setProductImage1(productService.getProductByID(cartList.get(i).getProductId()).get(0).getProductImage1());
               responseObject.setProductImage2(productService.getProductByID(cartList.get(i).getProductId()).get(0).getProductImage2());
               responseObject.setProductImage3(productService.getProductByID(cartList.get(i).getProductId()).get(0).getProductImage3());
               responseObject.setProductPrice(productService.getProductByID(cartList.get(i).getProductId()).get(0).getProductPrice());
               responseObject.setProductTag(productService.getProductByID(cartList.get(i).getProductId()).get(0).getProductTag());
               responseObject.setProductDescription(productService.getProductByID(cartList.get(i).getProductId()).get(0).getProductDescription());
               responseObject.setProductBestOffer(productService.getProductByID(cartList.get(i).getProductId()).get(0).getProductBestOffer());
               responseObject.setProductQuantity("10");


               responseList.add(responseObject);
               
               

                // cartObjects.add(productService.getProductByID(cartList.get(i).getProductId()).get(0));
                // cartObjects.add(cartList.get(i));
           

          System.out.println(productService.getProductByID(cartList.get(i).getProductId()));
                
            
            }
            map.put("timestamp", new Date());
            map.put("isSuccess", true);
            map.put("productData", "Cart Fetched Successfully");
           map.put("data", responseList);
            // map.put("data", cartObjects);  
            return new ResponseEntity<Object>(map,HttpStatus.ACCEPTED);

       
    }

    @PostMapping("/addItems")
    public ResponseEntity<Object> addItemsToCart(@RequestBody CartDetailsDto cartDetailsDto){
        cartService.addCartItem(cartDetailsDto);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> cartObjects = new ArrayList<>();
            map.put("timestamp", new Date());
            map.put("isSuccess", true);
            map.put("productData", "Cart Fetched Successfully");
            map.put("data", cartObjects);  
            return new ResponseEntity<Object>(map,HttpStatus.ACCEPTED);
    }

    @GetMapping("/deleteCartItem")
    public ResponseEntity<Object> deleteCartItems(@RequestParam String userId, String productID){
        cartService.deletecartItem(userId, productID);
          Map<String, Object> map = new HashMap<String, Object>();
        List<Object> cartObjects = new ArrayList<>();
        
            map.put("timestamp", new Date());
            map.put("isSuccess", true);
            map.put("productData", "Cart Fetched Successfully");
            map.put("data", cartObjects);  
            return new ResponseEntity<Object>(map,HttpStatus.ACCEPTED);

    }
}
