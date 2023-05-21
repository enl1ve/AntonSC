package ua.com.antonsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.antonsh.entity.Category;
import ua.com.antonsh.entity.Payments;
import ua.com.antonsh.repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentManagerService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentManagerService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void saveNewProductToDB(String description, String image, String name, int price, Category category){
        Payments payments = new Payments();
        payments.setDescription(description);
        payments.setImage(image);
        payments.setName(name);
        payments.setPrice(price);
        payments.setCategories(category);

        paymentRepository.save(payments);
    }

    public void updateProduct(Long id, String description, String image, String name, int price, Category category){
        Payments payments = new Payments();
        payments.setId(id);
        payments.setDescription(description);
        payments.setImage(image);
        payments.setName(name);
        payments.setPrice(price);
        payments.setCategories(category);

        paymentRepository.save(payments);
    }


    public void deleteProductById(Long id){
        paymentRepository.deleteById(id);
    }

    public void deleteAllProduct(){
        paymentRepository.deleteAll();
    }

    public List<Payments> findAllProduct(){
        return paymentRepository.findAll();
    }

    public Payments findProductById(Long id){
        return paymentRepository.findById(id).get();
    }

    public Payments findProductByName(String name){
        return paymentRepository.findByName(name);
    }

    public boolean sizeRoutesByCategory(Category category){
        List<Payments> payments  = paymentRepository.findAllByCategories(category);
        if(payments.size()>0){
            return true;
        } else {
            return false;
        }
    }

}
