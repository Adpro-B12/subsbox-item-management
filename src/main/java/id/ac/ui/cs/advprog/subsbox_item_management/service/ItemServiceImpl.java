package id.ac.ui.cs.advprog.subsbox_item_management.service;

import id.ac.ui.cs.advprog.subsbox_item_management.model.Item;
import id.ac.ui.cs.advprog.subsbox_item_management.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;
    
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    
    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }
    
    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
    
    @Override
    public Item getItemById(String itemId) {
        return itemRepository.findById(itemId).get();

    }

    @Override
    public Item editItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item deleteItem(Item item) {
        itemRepository.delete(item);
        return item;
    }


    
}
