package id.ac.ui.cs.advprog.subsbox_item_management.repository;

import org.springframework.stereotype.Repository;
import id.ac.ui.cs.advprog.subsbox_item_management.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
    
}
