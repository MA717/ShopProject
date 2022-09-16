package com.example.ShopProject.Controller;

import com.example.ShopProject.Entity.Category;
import com.example.ShopProject.Service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor

public class CategoryController {

    CategoryService categoryService ;

    @PostMapping("/category")
    Category saveCategory(@RequestBody Category category )
    {
       return categoryService.saveCategory(category);
    }

    @GetMapping("/category/{id}")
    Category getCategory(@PathVariable("id") UUID uuid)
    {
        return categoryService.getCategory(uuid);
    }
}
