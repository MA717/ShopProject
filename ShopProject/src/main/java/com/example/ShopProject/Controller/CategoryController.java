package com.example.ShopProject.Controller;

import com.example.ShopProject.Entity.Category;
import com.example.ShopProject.Service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor

public class CategoryController {

    CategoryService categoryService ;


    // Only employee can add new category
    @PostMapping("/category")
    Category saveCategory(@RequestBody Category category )
    {
       return categoryService.saveCategory(category);
    }

    @GetMapping ("/category/showall")
    List<Category>getAllCategory(){
        return  categoryService.getAllCategories();
    }
    @GetMapping("/category/{id}")
    Category getCategory(@PathVariable("id") UUID uuid)
    {
        return categoryService.getCategory(uuid);
    }

    @DeleteMapping("category/delete_category/{id}")
    Boolean deleteCategory(@PathVariable("id") UUID uuid ){
        return  categoryService.deleteCategory(uuid);
    }
}
