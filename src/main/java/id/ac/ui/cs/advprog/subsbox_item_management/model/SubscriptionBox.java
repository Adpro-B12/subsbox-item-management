package id.ac.ui.cs.advprog.subsbox_item_management.model;

//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.List;
//
//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;
//
//import jakarta.persistence.*;
//
//@Getter @Setter
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@Entity
//@Table(name = "subscription_box")
//public class SubscriptionBox {
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private String id;
//    private String name;
//    private String type;
//    private int price;
//
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    List<Item> items;
//
//    // private int rating
//}


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "subscription_boxes")
public class SubscriptionBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String name;
    String type;
    int price;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<Item> items;
    // Rating rating;
    public SubscriptionBox() {
    }

    public SubscriptionBox(String name,  String type, int price, Long id) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }
}
