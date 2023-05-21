package ua.com.antonsh.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.antonsh.entity.Category;
import ua.com.antonsh.entity.Payments;
import ua.com.antonsh.service.PaymentService;

import java.util.List;

@Controller
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/category/{id}")
    public String getAllRoutesByCategory(@PathVariable(name = "id") Category category,
                                         Model model){

        List<Payments> routes = paymentService.getPaymentByCategory(category);
        model.addAttribute("allDoctorsByCategory", routes);

        return "doctor";
    }
}
