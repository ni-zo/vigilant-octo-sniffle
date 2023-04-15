package com.natural.beauty.Controller;

import com.natural.beauty.Model.Category;
import com.natural.beauty.Model.CategoryName;
import com.natural.beauty.Model.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cats")
@CrossOrigin(origins = "*")
public class CategoryController {
    private final CategoryRepository categoryRepository;


    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/r")
    public @ResponseBody List<Category> getAll(){
        return categoryRepository.findAll();
    }

    @PostMapping("/c") //!! impossible
    public @ResponseBody String saveOne(@RequestParam CategoryName categoryName) {
        Category category = new Category();
        category.setCategoryName(categoryName);
        categoryRepository.saveAndFlush(category);
        return "saved";
    }

   /* @DeleteMapping("d{id}")
    public @ResponseBody String */
}
