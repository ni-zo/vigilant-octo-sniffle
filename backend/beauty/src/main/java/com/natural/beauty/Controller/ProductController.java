package com.natural.beauty.Controller;

import com.natural.beauty.Model.Category;
import com.natural.beauty.Model.CategoryName;
import com.natural.beauty.Model.Product;
import com.natural.beauty.Service.ProductService;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("get")
    public @ResponseBody List<Product> getRes() {
        List<Product> productList = productService.findAll();
        for (Product product : productList) {
            String unescapedName = StringEscapeUtils.unescapeHtml4(product.getName());
            String unescapedDescription = StringEscapeUtils.unescapeHtml4(product.getDescription());
            product.setName(unescapedName);
            product.setDescription(unescapedDescription);
        }
        return productList;
    }

    @PostMapping("pos")
    public @ResponseBody String storeOne(@RequestBody @Validated Product prod) {
        //Product product = new Product();
        prod.setName(StringEscapeUtils.escapeHtml4(prod.getName()));
        prod.setDescription(StringEscapeUtils.escapeHtml4(prod.getDescription()));

        productService.saveOne(prod);
        return "good";
    }

    @PutMapping("put/{id}")
    public @ResponseBody String upOne(@RequestBody @Validated Product product, @PathVariable("id") Long id) {
        return productService.updateById(id, product);
    }

    @GetMapping("get/{id}")
    public @ResponseBody Optional<Product> getOne(@RequestBody @Validated @PathVariable("id") Long id) {
        return productService.findById(id);
    }

    @GetMapping("get/cat/{cat}")
    public @ResponseBody List<Product> getCat(@RequestBody @Validated @PathVariable("cat") CategoryName categoryName){
        return productService.findByCat(categoryName);
    }

    @DeleteMapping("del/{id}")
    public @ResponseBody String delOne(@RequestBody @Validated @PathVariable("id") Long id) {
        return productService.delOneById(id);
    }
}
