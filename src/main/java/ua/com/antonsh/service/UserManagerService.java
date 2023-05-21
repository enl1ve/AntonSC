package ua.com.antonsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.antonsh.entity.Customer;
import ua.com.antonsh.entity.Roles;
import ua.com.antonsh.entity.User;
import ua.com.antonsh.repository.CustomerRepository;
import ua.com.antonsh.repository.UserRepository;

import java.util.Collections;
import java.util.List;

@Service
public class UserManagerService implements UserDetailsService {
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public UserManagerService(UserRepository userRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }


    public boolean getLogicByUser(String username) {

        return (!userRepository.findAllByUsername(username).isEmpty()) ? true : false;
    }


    public User saveNewUserToDB(User user){
        user.setRoles(Collections.singleton(new Roles(1L, "ROLE_User")));

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }


    public List<Customer> getCustomerList() {
        return customerRepository.findAll();
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {

        User user1 = userRepository.findByUsername(username);

        System.out.println(user1);

        if(user1==null){
            throw new UsernameNotFoundException("User not found!!!");
        }

        return user1;
    }
}
