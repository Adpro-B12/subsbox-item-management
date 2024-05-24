package id.ac.ui.cs.advprog.subsbox_item_management.controller;

import org.springframework.web.bind.annotation.RestController;

import id.ac.ui.cs.advprog.subsbox_item_management.model.Item;
import id.ac.ui.cs.advprog.subsbox_item_management.model.builder.ItemBuilder;
import id.ac.ui.cs.advprog.subsbox_item_management.service.ItemService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/create")
    public Item createItem(@RequestParam String name) {
        return itemService.createItem(new ItemBuilder().setName(name));
    }

    @GetMapping("/getAll")
    public Iterable<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/getById")
    public Item getItemById(@RequestParam String itemId) {
        return itemService.getItemById(itemId);
    }

    @GetMapping("/edit")
    public Item editItem(@RequestParam String itemId, @RequestParam int quantity) {
        Item item = itemService.getItemById(itemId);
        item.setQuantity(quantity);
        return itemService.editItem(item, itemId);
    }

    @GetMapping("/delete")
    public Item deleteItem(@RequestParam String itemId) {
        Item item = itemService.getItemById(itemId);
        return itemService.deleteItem(item);
    }

}
