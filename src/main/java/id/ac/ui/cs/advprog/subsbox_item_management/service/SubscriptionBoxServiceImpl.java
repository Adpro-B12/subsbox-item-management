package id.ac.ui.cs.advprog.subsbox_item_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.advprog.subsbox_item_management.model.SubscriptionBox;
import id.ac.ui.cs.advprog.subsbox_item_management.repository.SubscriptionBoxRepository;

@Service
public class SubscriptionBoxServiceImpl implements SubscriptionBoxService{

    @Autowired
    private SubscriptionBoxRepository subscriptionBoxRepository;
    
    @Override
    public SubscriptionBox addBox(SubscriptionBox box){
        return subscriptionBoxRepository.save(box);
    }

    @Override
    public SubscriptionBox deleteBox(Long id) {
        SubscriptionBox box = subscriptionBoxRepository.findById(id).orElse(null);
        subscriptionBoxRepository.deleteById(id);
        return box;
    }

    @Override
    public SubscriptionBox editBox(Long id, SubscriptionBox box) {
        return subscriptionBoxRepository.findById(id).map(subscriptionBox -> {
            subscriptionBox.setName(box.getName());
            subscriptionBox.setPrice(box.getPrice());
            subscriptionBox.setType(box.getType());
            subscriptionBox.setItems(box.getItems());
            return subscriptionBoxRepository.save(subscriptionBox);
        }).orElse(null);
    }

    @Override
    public List<SubscriptionBox> viewAll() {
        return subscriptionBoxRepository.findAll();
    }

    @Override
    public List<SubscriptionBox> filterByPrice(int price) {
        return subscriptionBoxRepository.findAll().stream()
                .filter(var1 -> var1.getPrice() == price)
                .toList();
    }

    @Override
    public SubscriptionBox viewDetails(Long boxId) {
        return subscriptionBoxRepository.findById(boxId).orElse(null);
    }

    @Override
    public List<SubscriptionBox> getFilteredBoxesByPrice(int minPrice, int maxPrice) {
        return subscriptionBoxRepository.findByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public List<SubscriptionBox> getFilteredBoxesByName(String name) {
        return subscriptionBoxRepository.findByNameContaining(name);
    }

    @Override
    public SubscriptionBox findBoxById(Long id)  {
        return subscriptionBoxRepository.findById(id).orElse(null);
    }
    @Override
    public List<SubscriptionBox> getAllBoxes() {
        return subscriptionBoxRepository.findAll();
    }


}
