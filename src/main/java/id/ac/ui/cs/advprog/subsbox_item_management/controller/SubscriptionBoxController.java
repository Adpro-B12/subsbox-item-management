package id.ac.ui.cs.advprog.subsbox_item_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import id.ac.ui.cs.advprog.subsbox_item_management.model.SubscriptionBox;
import id.ac.ui.cs.advprog.subsbox_item_management.service.SubscriptionBoxService;

import java.util.List;

@RestController
@RequestMapping("/subscription-box")
public class SubscriptionBoxController {
    
    @Autowired
    private SubscriptionBoxService subscriptionBoxService;
    String createHTML = "userCreate";
    @GetMapping("../")
    public String createUserPage(Model model) {
        return "<h1>Subscription box and Item Management sudah berhasil!</h1>";
    }

    @PostMapping("/create")
    public ResponseEntity<SubscriptionBox> createSubscriptionBox(@RequestBody SubscriptionBox subscriptionBox, Model model) {
        SubscriptionBox newBox = subscriptionBoxService.addBox(subscriptionBox);
        return ResponseEntity.ok(newBox);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SubscriptionBox>> viewAll() {
        List<SubscriptionBox> allBoxes = subscriptionBoxService.getAllBoxes();
        return ResponseEntity.ok(allBoxes);
    }

    @GetMapping("/viewDetails/{boxId}")
    public ResponseEntity<SubscriptionBox> viewDetails(@PathVariable Long boxId) {
        SubscriptionBox box = subscriptionBoxService.viewDetails(boxId);
        return ResponseEntity.ok(box);
    }

    @DeleteMapping("/delete/{boxId}")
    public ResponseEntity<SubscriptionBox> deleteBox(@PathVariable Long boxId) {
        SubscriptionBox deletedBox = subscriptionBoxService.deleteBox(boxId);
        return ResponseEntity.ok(deletedBox);
    }

    @PutMapping("/edit/{boxId}")
    public ResponseEntity<SubscriptionBox> editBox(@PathVariable Long boxId, @RequestBody SubscriptionBox subscriptionBox) {
        SubscriptionBox editedBox = subscriptionBoxService.editBox(boxId, subscriptionBox);
        return ResponseEntity.ok(editedBox);
    }

    @GetMapping("/price")
    public ResponseEntity<List<SubscriptionBox>> getFilteredSubscriptionBoxesByPrice(@RequestParam(required = false) int minPrice, @RequestParam(required = false) int maxPrice) {
        List<SubscriptionBox> boxes = subscriptionBoxService.getFilteredBoxesByPrice(minPrice, maxPrice);
        return ResponseEntity.ok(boxes);
    }

    @GetMapping("/name")
    public ResponseEntity<List<SubscriptionBox>> getFilteredSubscriptionBoxesByName(@RequestParam(required = false) String name) {
        List<SubscriptionBox> boxes = subscriptionBoxService.getFilteredBoxesByName(name);
        return ResponseEntity.ok(boxes);
    }
}