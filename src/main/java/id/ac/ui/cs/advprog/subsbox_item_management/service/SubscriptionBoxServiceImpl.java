package id.ac.ui.cs.advprog.subsbox_item_management.service;

import java.util.List;
import java.util.stream.Collectors;

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
    public SubscriptionBox deleteBox(String id) {
        SubscriptionBox box = subscriptionBoxRepository.findById(id).orElse(null);
        subscriptionBoxRepository.deleteById(id);
        return box;
    }

    @Override
    public SubscriptionBox editBox(String id, SubscriptionBox box) {
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
        List<SubscriptionBox> boxes =  subscriptionBoxRepository.findAll().stream().filter(var1 -> {return var1.getPrice()==price;}).collect(Collectors.toList()) ;
        return boxes;
    }

    @Override
    public String viewDetails(String boxId) {
        return subscriptionBoxRepository.findById(boxId).get().getName();
    }


    // need Rating
    // @Override
    // public CompletableFuture<List<SubscriptionBox>> getFilteredBoxesByRatingAsync(String name) {
    //     return CompletableFuture.supplyAsync(() -> subscriptionBoxRepository.findByNameContaining(name));
    // }
}
