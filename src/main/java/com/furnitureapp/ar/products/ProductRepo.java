package com.furnitureapp.ar.products;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    @Query(value = "SELECT * FROM product Where product_best_offer = true",nativeQuery = true)
    public List<Product> getBestOfferProductList();

    @Query(value = "SELECT * FROM product Where product_name LIKE ?1%",nativeQuery = true)
    public List<Product> productList(String searchQuery);

    @Query(value ="SELECT * FROM product WHERE product_id = ?1 ",nativeQuery = true )
    public List<Product> getProductById(int id);
}
