package com.example.ShopProject.Service;

import com.example.ShopProject.Entity.Category;
import com.example.ShopProject.Repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor
@Data
public class CategoryService {
    CategoryRepository categoryRepository;

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category getCategory(UUID category_id) {
        return categoryRepository.findById(category_id).get();
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Boolean deleteCategory(UUID uuid) {
        try {
            Category category = categoryRepository.findById(uuid).get();

            categoryRepository.deleteById(uuid);
            return  true ;

        }
        catch (NoSuchElementException e )
        {
            return false ;
        }

    }

}

