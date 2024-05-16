package id.ac.ui.cs.advprog.subsbox_item_management.model.builder;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import id.ac.ui.cs.advprog.subsbox_item_management.model.SubscriptionBox;
import id.ac.ui.cs.advprog.subsbox_item_management.repository.SubscriptionBoxRepository;

@Component
public class SubscriptionBoxBuilder {
    private SubscriptionBox subscriptionBox;

    @Autowired
    private SubscriptionBoxRepository subscriptionBoxRepository;
    
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

//    public SubscriptionBoxBuilder setItems() {
//        subscriptionBox.setItems(new ArrayList<>());
//        return this;
//    }

    public SubscriptionBoxBuilder setId(String id) {
        subscriptionBox.setId(id);
        return this;
    }

}
