/*
package com.natural.beauty.Service;

import com.natural.beauty.Model.Category;
import com.natural.beauty.Model.CategoryName;
import com.natural.beauty.Model.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        // Your code to persist data goes here
        Category myEntity = new Category();
        myEntity.setCategoryName(CategoryName.valueOf("SOINS_DU_CORPS"));
        categoryRepository.save(myEntity);

        Category myEntit = new Category();
        myEntit.setCategoryName(CategoryName.valueOf("SOINS_DU_VISAGE"));
        categoryRepository.save(myEntit);

        Category myEnti = new Category();
        myEnti.setCategoryName(CategoryName.valueOf("MAQUILLAGE"));
        categoryRepository.save(myEnti);

        Category myEnt = new Category();
        myEnt.setCategoryName(CategoryName.valueOf("LA_BEAUTE_DES_MAINS"));
        categoryRepository.save(myEnt);


        categoryRepository.flush();


    }

}
*/
