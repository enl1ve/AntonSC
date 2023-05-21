package ua.com.antonsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.antonsh.entity.Category;
import ua.com.antonsh.entity.Payments;
import ua.com.antonsh.repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payments> getPaymentByCategory(Category category){
        return paymentRepository.findAllByCategories(category);
    }
}
