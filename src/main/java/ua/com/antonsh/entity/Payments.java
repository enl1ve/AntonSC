package ua.com.antonsh.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data

@Entity
@Table(name = "payment")
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;
    private String name;
    private String description;
    private int price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categories;
}
