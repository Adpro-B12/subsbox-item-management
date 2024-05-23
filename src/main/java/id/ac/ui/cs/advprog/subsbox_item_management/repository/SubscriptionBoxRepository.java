package id.ac.ui.cs.advprog.subsbox_item_management.repository;

import id.ac.ui.cs.advprog.subsbox_item_management.model.SubscriptionBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionBoxRepository extends JpaRepository<SubscriptionBox, String> {
    
}