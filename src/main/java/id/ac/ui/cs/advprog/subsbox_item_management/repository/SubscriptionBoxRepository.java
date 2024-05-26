package id.ac.ui.cs.advprog.subsbox_item_management.repository;

import id.ac.ui.cs.advprog.subsbox_item_management.model.SubscriptionBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionBoxRepository extends JpaRepository<SubscriptionBox, Long> {
    List<SubscriptionBox> findByPriceBetween(int minPrice, int maxPrice);
    List<SubscriptionBox> findByNameContaining(String name);
}