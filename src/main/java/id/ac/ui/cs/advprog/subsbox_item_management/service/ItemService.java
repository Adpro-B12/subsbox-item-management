package id.ac.ui.cs.advprog.subsbox_item_management.service;

import id.ac.ui.cs.advprog.subsbox_item_management.model.Item;

import java.util.List;


public interface ItemService {
    public Item createItem(Item item);
    public List<Item> getAllItems();
    public Item getItemById(Long id);
    public Item editItem(Item item, Long id);
    public Item deleteItem(Item item);
}
