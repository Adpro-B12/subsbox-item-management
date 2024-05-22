package id.ac.ui.cs.advprog.subsbox_item_management.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;

@Getter @Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "subscription_box")
public class SubscriptionBox {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String type;
    private int price;

    @OneToMany(mappedBy = "subscriptionBox", fetch = FetchType.LAZY)
    private List<Item> items;

    // private int rating
}
