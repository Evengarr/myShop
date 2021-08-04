package ru.geekbrains.order.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "address")
    private String address;

    @Column(name = "payment_status")
    private boolean paymentStatus;

    @Column(name = "delivery_status")
    private String deliveryStatus;

    @ManyToMany
    @JoinTable(name = "orders_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "items_id"))
    private Collection<OrderItem> OrderItems;
}
