package ua.com.antonsh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.antonsh.entity.Category;
import ua.com.antonsh.entity.Payments;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payments, Long> {
    Payments findByName(String name);
    List<Payments> findAllByCategories(Category category);
}
