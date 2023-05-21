package ua.com.antonsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.antonsh.entity.Customer;
import ua.com.antonsh.repository.CustomerRepository;

@Service
public class CustomerManagerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerManagerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void saveCustomerToDB(Customer client){
        customerRepository.save(client);
    }

    public Customer getClientById (Long id) {
        return customerRepository.getCustomerById(id);
    }
}
