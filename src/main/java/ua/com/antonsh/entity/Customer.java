package ua.com.antonsh.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String email;
    private String phone;

    @OneToOne
    @MapKey
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @OneToMany(mappedBy = "customer")
    private List<Category> categories;
}

