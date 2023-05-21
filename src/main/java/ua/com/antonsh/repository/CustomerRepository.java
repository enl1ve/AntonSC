package ua.com.antonsh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.antonsh.entity.Customer;
import ua.com.antonsh.entity.User;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByUser (User users);

    Customer getCustomerById (Long id);
}
