package ua.com.antonsh.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.antonsh.entity.Customer;
import ua.com.antonsh.entity.User;
import ua.com.antonsh.service.CustomerManagerService;
import ua.com.antonsh.service.UserManagerService;

@Controller
public class UserManagerController {
    private final CustomerManagerService customerService;
    private final UserManagerService userService;

    @Autowired
    public UserManagerController(CustomerManagerService customerService, UserManagerService userService) {
        this.customerService = customerService;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }


    @GetMapping("/registration")
    public String getRegistrationPage(@Valid User users,
                                      BindingResult bindingResult,
                                      @Valid Customer customer,
                                      BindingResult bindingResult1,
                                      Model model){

        model.addAttribute("users", new User());
        model.addAttribute("customer", new Customer());

        return "registration";
    }


    @PostMapping("/registration")
    public String saveNewCustomer(User users,
                                  BindingResult bindingResult,
                                  Customer customer,
                                  BindingResult bindingResult1,
                                  Model model
    ){

        if(bindingResult.hasErrors()){
            return "/registration";
        }

        if(bindingResult1.hasErrors()){
            return "/registration";
        }

        /* Перевірка користувача в системі  */

        if(userService.getLogicByUser(users.getUsername())){
            //  model.addAttribute("err", "Користувач з таким іменем вже існує!");
            return "/registration";
        }


        User user1 = userService.saveNewUserToDB(users);

        customer.setUser(user1);

        customerService.saveCustomerToDB(customer);

        return "redirect:/login";
    }

    @GetMapping("/customermanager")
    public String getCustomerList(Model model){

        model.addAttribute("customers",  userService.getCustomerList());

        return "customerAdmin";
    }
}
