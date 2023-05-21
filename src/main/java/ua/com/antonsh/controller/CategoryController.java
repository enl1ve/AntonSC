package ua.com.antonsh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.antonsh.entity.Category;
import ua.com.antonsh.service.CategoryService;

import java.util.List;

@Controller
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public String getPageCategory(Model model) {
        List<Category> categories = categoryService.getAllCategory();

        model.addAttribute("allCategory", categories);

        return "category";
    }
}
