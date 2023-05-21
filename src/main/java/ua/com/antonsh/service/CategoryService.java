package ua.com.antonsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ua.com.antonsh.entity.Category;
import ua.com.antonsh.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Cacheable(cacheNames = "category")
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }
}
