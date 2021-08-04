package ru.geekbrains.order.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "price_per_unit")
    private Double pricePerUnit;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private int quantity;
}
