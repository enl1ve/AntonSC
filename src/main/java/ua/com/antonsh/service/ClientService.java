package ua.com.antonsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.antonsh.entity.Customer;
import ua.com.antonsh.entity.User;
import ua.com.antonsh.repository.CustomerRepository;

@Service
public class ClientService {
    private final CustomerRepository customerRepository;

    @Autowired
    public ClientService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getClientByUser(User users) {
        return customerRepository.findByUser(users);
    }
}
