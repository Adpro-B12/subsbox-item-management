package id.ac.ui.cs.advprog.subsbox_item_management.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

import jakarta.persistence.*;


@Getter @Setter
@Entity
@Table(name = "subscription_box")
public class SubscriptionBox {
    @Id
            @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String name;
    String type;
    int price;
//     List<Item> items;
    // Rating rating;
}
