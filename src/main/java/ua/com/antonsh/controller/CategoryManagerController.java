package ua.com.antonsh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.com.antonsh.entity.Category;
import ua.com.antonsh.service.CategoryManagerService;
import ua.com.antonsh.service.PaymentManagerService;

@Controller
public class CategoryManagerController {
    private final CategoryManagerService categoryService;
    private final PaymentManagerService paymentManagerService;

    @Autowired
    public CategoryManagerController(CategoryManagerService categoryService, PaymentManagerService paymentManagerService) {
        this.categoryService = categoryService;
        this.paymentManagerService = paymentManagerService;
    }


    @GetMapping("/categorymanager")
    public String getCategoryManagerPage(Model model,
                                         @RequestParam(name = "Err", defaultValue = "") String name,
                                         @RequestParam(name = "Error", defaultValue = "") String name1
    ) {
        model.addAttribute("allCategory", categoryService.getCategoryList());
        model.addAttribute("Err", name);
        model.addAttribute("Error", name1);

        return "categoryAdminPage";
    }

    @PostMapping("/saveNewCategory")
    public String saveNewCategoryToDB(@RequestParam(value = "name") String name,
                                      @RequestParam(value = "description") String description,
                                      @RequestParam(value = "image") String image
    ) {
        categoryService.saveCategory(name, description, image);
        return "redirect:/categorymanager";
    }


    @PostMapping("/updateCategory")
    public String updateCategory(@RequestParam(value = "id") Long id,
                                 @RequestParam(value = "name") String name,
                                 @RequestParam(value = "description") String description,
                                 @RequestParam(value = "image") String image) {
        categoryService.updateCategory(id, name, description, image);
        return "redirect:/categorymanager";
    }


    @PostMapping("/deleteCategory")
    public String deletecategory(@RequestParam(value = "id") Long id,
                                 @RequestParam(value = "id") Category category,
                                 RedirectAttributes redirectAttributes) {


        if (!paymentManagerService.sizeRoutesByCategory(category)) {
            categoryService.deleteCategory(id);
            return "redirect:/categorymanager";
        } else {
            redirectAttributes.addAttribute("Err", "Перед видаленням категорії,будь ласка, видаліть продукцію з категорії");
            return "redirect:/categorymanager";
        }
    }


    @PostMapping("/deleteAllCategory")
    public String deleteAllCategory(RedirectAttributes redirectAttributes) {

        if (paymentManagerService.findAllProduct().size() == 0) {
            categoryService.deleteAllCategory();
            return "redirect:/categorymanager";
        } else {
            redirectAttributes.addAttribute("Error", "Перед видаленням категорій, будь ласка, видаліть всю продукцію з категорій");
            return "redirect:/categorymanager";
        }
    }


    @GetMapping("/categorymanager/{id}")
    public String getCategoryById(@PathVariable("id") Long id,
                                  Model model) {
        Category category = categoryService.getCategoryById(id);

        model.addAttribute("category", category);

        return "categoryById";
    }
}
