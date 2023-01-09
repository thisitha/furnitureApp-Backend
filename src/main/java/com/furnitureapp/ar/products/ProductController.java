package com.furnitureapp.ar.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/productList")
    public ResponseEntity<Object> getProducts(@RequestParam String searchQuery){
        System.out.print(searchQuery); 
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("items", productService.gerProductList(searchQuery));
        return new ResponseEntity<Object>(map,HttpStatus.ACCEPTED);
    }

    @GetMapping("/bestOfferProductList")
    public List<ProductDto> getBestOfferProducts(){
            return productService.gerBestOfferProductList();
    }
    
}
