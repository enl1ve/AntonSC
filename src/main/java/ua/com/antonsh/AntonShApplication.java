package ua.com.antonsh;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.com.antonsh.entity.Roles;
import ua.com.antonsh.repository.RolesRepository;

@SpringBootApplication
public class AntonShApplication {

    public static void main(String[] args) {
        SpringApplication.run(AntonShApplication.class, args);
    }


    @Bean
    CommandLineRunner run(RolesRepository roleRepository) {
        return args -> {
            if (roleRepository.findAll().isEmpty()) {
                roleRepository.save(new Roles(1L, "ROLE_User"));
            }
        };
    }
}
