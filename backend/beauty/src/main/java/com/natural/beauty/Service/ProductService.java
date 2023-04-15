package com.natural.beauty.Service;

import com.natural.beauty.Model.Category;
import com.natural.beauty.Model.CategoryName;
import com.natural.beauty.Model.Product;
import com.natural.beauty.Model.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

@Autowired
private ProductRepository productRepository;

    public List<Product> findAll(){
            return productRepository.findAll();

    }

    public String saveOne(Product prod){
        productRepository.saveAndFlush(prod);
        return "saved";
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }
    public String updateById(Long id, Product product){
        if (productRepository.findById(id).isPresent()){
            product.setId(id);
            productRepository.saveAndFlush(product);
            return "good";
        }
        return "Not found";
    }

    public List<Product> findByCat(CategoryName categoryName){
        return productRepository.findByCategoryCategoryName(categoryName);
    }

    public String delOneById(Long id){
        if (productRepository.findById(id).isPresent()){
            productRepository.deleteById(id);
            productRepository.flush();
            return "deleted";
        }

        return "not del";
    }

}
