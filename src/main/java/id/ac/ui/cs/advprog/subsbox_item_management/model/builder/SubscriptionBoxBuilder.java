package id.ac.ui.cs.advprog.subsbox_item_management.model.builder;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import id.ac.ui.cs.advprog.subsbox_item_management.model.SubscriptionBox;


@Component
public class SubscriptionBoxBuilder {
    private SubscriptionBox subscriptionBox;
    
    public SubscriptionBoxBuilder() {
        this.subscriptionBox = new SubscriptionBox();
    }

    public SubscriptionBoxBuilder setName(String name) {
        subscriptionBox.setName(name);
        return this;
    }

    public SubscriptionBoxBuilder setType(String type) {
        subscriptionBox.setType(type);
        return this;
    }

    public SubscriptionBoxBuilder setPrice(int price) {
        subscriptionBox.setPrice(price);
        return this;
    }

    public SubscriptionBoxBuilder setItems() {
        subscriptionBox.setItems(new ArrayList<>());
        return this;
    }

    public SubscriptionBoxBuilder setId(Long id) {
        subscriptionBox.setId(id);
        return this;
    }

}
