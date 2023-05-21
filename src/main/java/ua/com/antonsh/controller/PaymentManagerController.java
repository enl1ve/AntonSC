package ua.com.antonsh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.antonsh.entity.Category;
import ua.com.antonsh.entity.Payments;
import ua.com.antonsh.service.CategoryManagerService;
import ua.com.antonsh.service.PaymentManagerService;

@Controller
public class PaymentManagerController {
    private final PaymentManagerService paymentManagerService;

    private final CategoryManagerService categoryManagerService;

    @Autowired
    public PaymentManagerController(PaymentManagerService paymentManagerService, CategoryManagerService categoryManagerService) {
        this.paymentManagerService = paymentManagerService;
        this.categoryManagerService = categoryManagerService;
    }


    @GetMapping("/productmanager")
    public String getAllProduct(Model model) {
        model.addAttribute("allProduct", paymentManagerService.findAllProduct());
        model.addAttribute("allCategory", categoryManagerService.getCategoryList());
        return "routesAdminPage";
    }


    @PostMapping("/saveNewProduct")
    public String saveNewProductToDB(
            @RequestParam(value = "description") String description,
            @RequestParam(value = "image") String image,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "price") int price,
            @RequestParam(value = "categoryId") Category category
    ) {

        paymentManagerService.saveNewProductToDB(description, name, image, price, category);

        return "redirect:/productmanager";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "image") String image,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "price") int price,
            @RequestParam(value = "categoryId") Category category
    ) {

        paymentManagerService.updateProduct(id,description, name, image, price, category);

        return "redirect:/productmanager";
    }


    @PostMapping("/deleteProduct")
    public String deleteProduct(@RequestParam(value = "id") Long id){

        try {
        paymentManagerService.deleteProductById(id);

        return "redirect:/productmanager";
        } catch (Exception e) {
            return "redirect:/productmanager";
        }
    }


    @PostMapping("/deleteAllProduct")
    public String deleteAllProduct(){
        try {
            paymentManagerService.deleteAllProduct();

            return "redirect:/productmanager";
        } catch (Exception e) {
            return "redirect:/productmanager";
        }
    }

    @GetMapping("/productmanager/{id}")
    public String getCategoryPageById(@PathVariable("id") Long id,
                                      Model model){

        Payments payments = paymentManagerService.findProductById(id);
        model.addAttribute("product", payments);

        return "productDet";
    }
}
