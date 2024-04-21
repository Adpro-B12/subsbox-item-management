package id.ac.ui.cs.advprog.subsbox_item_management.model;

import lombok.Builder;
import lombok.Getter;
import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

@Builder
@Getter
public class SubscriptionBox {
    String id;
    String name;
    String type;
    int price;
    List<Item> items;

    public SubscriptionBox(String name, String type, int price, List<Item> items) {
        
    }
}
