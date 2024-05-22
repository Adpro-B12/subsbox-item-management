package id.ac.ui.cs.advprog.subsbox_item_management.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter @Setter
@Entity
@Table(name = "item")
public class Item {

    private String id;
    private String name;
    private int quantity;
}
