package com.natural.beauty.Model.Repository;

import com.natural.beauty.Model.Category;
import com.natural.beauty.Model.CategoryName;
import com.natural.beauty.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //List<Product> findByCategoryName_Name(CategoryName categoryName);

    List<Product> findByCategoryCategoryName(CategoryName categoryName);
}
