package id.ac.ui.cs.advprog.subsbox_item_management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "subscription_box")
public class SubscriptionBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String name;
    String type;
    int price;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<Item> items;
}
