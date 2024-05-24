package id.ac.ui.cs.advprog.subsbox_item_management.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter @Setter
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "subscription_box_id")
    @JsonIdentityReference(alwaysAsId = true)
    private SubscriptionBox subscriptionBox;
}
