package id.ac.ui.cs.advprog.subsbox_item_management.service;

import id.ac.ui.cs.advprog.subsbox_item_management.model.Item;
import id.ac.ui.cs.advprog.subsbox_item_management.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);

    }

    @Override
    public Item editItem(Item item, Long id) {
        return itemRepository.findById(id).map(updatedItem -> {
            updatedItem.setName(item.getName());
            updatedItem.setQuantity(item.getQuantity());
            return itemRepository.save(updatedItem);
        }).orElse(null);
    }   

    @Override
    public Item deleteItem(Item item) {
        itemRepository.delete(item);
        return item;
    }



}
