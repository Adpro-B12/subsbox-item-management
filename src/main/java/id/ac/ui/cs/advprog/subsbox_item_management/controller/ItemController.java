package id.ac.ui.cs.advprog.subsbox_item_management.controller;

import org.springframework.web.bind.annotation.RestController;

import id.ac.ui.cs.advprog.subsbox_item_management.model.Item;
import id.ac.ui.cs.advprog.subsbox_item_management.service.ItemService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/create")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item newItem = itemService.createItem(item);
        return ResponseEntity.ok(newItem);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/get/{itemId}")
    public ResponseEntity<Item> getItemById(@PathVariable Long itemId) {
        Item item = itemService.getItemById(itemId);
        return ResponseEntity.ok(item);
    }

    @PutMapping("/edit/{itemId}")
    public ResponseEntity<Item> editItem(@PathVariable Long itemId, @RequestBody Item item) {
        Item editedItem = itemService.editItem(item, itemId);
        return ResponseEntity.ok(editedItem);
    }

    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<Item> deleteItem(@PathVariable Long itemId) {
        Item item = itemService.getItemById(itemId);
        itemService.deleteItem(item);
        return ResponseEntity.ok(item);
    }

}
