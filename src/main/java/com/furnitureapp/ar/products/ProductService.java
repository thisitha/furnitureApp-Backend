package com.furnitureapp.ar.products;
import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ModelMapper modelMapper;

    public List<ProductDto> gerProductList (String searchQuery){
        List<Product> uList = productRepo.productList(searchQuery);
        return modelMapper.map(uList,  new TypeToken<List<ProductDto>>(){}.getType());
    }

    public List<ProductDto> gerBestOfferProductList (){
        List<Product> uList = productRepo.getBestOfferProductList();
        return modelMapper.map(uList,  new TypeToken<List<ProductDto>>(){}.getType());
    }
    public List<ProductDto> getProductByID (int id){
        List<Product> uList = productRepo.getProductById(id);
        return modelMapper.map(uList,  new TypeToken<List<ProductDto>>(){}.getType());
    }

    
}
