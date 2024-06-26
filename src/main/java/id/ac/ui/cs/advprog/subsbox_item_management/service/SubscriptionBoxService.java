package id.ac.ui.cs.advprog.subsbox_item_management.service;

import java.util.List;

import id.ac.ui.cs.advprog.subsbox_item_management.model.SubscriptionBox;

public interface SubscriptionBoxService {
    public SubscriptionBox addBox(SubscriptionBox subscriptionBox);
    public SubscriptionBox editBox(Long boxId, SubscriptionBox subscriptionBox);
    public SubscriptionBox deleteBox(Long boxId);
    public SubscriptionBox viewDetails(Long boxId);
    public List<SubscriptionBox> filterByPrice(int price);
    public List<SubscriptionBox> getAllBoxes();
    public List<SubscriptionBox> getFilteredBoxesByPrice(int minPrice, int maxPrice);
    public List<SubscriptionBox> getFilteredBoxesByName(String name);
    public SubscriptionBox findBoxById(Long id);
}