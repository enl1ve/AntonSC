package ua.com.antonsh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


//    @GetMapping("/")
//    public String getHomePage() {
//        return "home";
//    }

    @GetMapping("/")
    public String getHome(){
        return "home";
    }

    @GetMapping("/products")
    public String getProductAdmin(){
        return "routesAdminPage";
    }

    @GetMapping("/categories")
    public String getCategoryAdmin(){
        return "categoryAdminPage";
    }

    @GetMapping("/orders")
    public String getOrdersAdmin(){
        return "order";
    }

    @GetMapping("/customers")
    public String getCustomersAdmin(){
        return "customer";
    }
}
