package id.ac.ui.cs.advprog.subsbox_item_management.service;

import java.util.List;

import id.ac.ui.cs.advprog.subsbox_item_management.model.SubscriptionBox;

public interface SubscriptionBoxService {
    public SubscriptionBox addBox(SubscriptionBox subscriptionBox);
    public SubscriptionBox editBox(Long boxId, SubscriptionBox subscriptionBox);
    public SubscriptionBox deleteBox(Long boxId);
    public List<SubscriptionBox> viewAll();
    public SubscriptionBox viewDetails(Long boxId);
    public List<SubscriptionBox> filterByPrice(int price);
}