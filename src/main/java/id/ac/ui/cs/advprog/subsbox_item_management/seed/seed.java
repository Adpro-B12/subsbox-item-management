//package id.ac.ui.cs.advprog.subsbox_item_management.seed;
//
//import id.ac.ui.cs.advprog.subsbox_item_management.service.ItemService;
//import id.ac.ui.cs.advprog.subsbox_item_management.service.SubscriptionBoxService;
//import id.ac.ui.cs.advprog.subsbox_item_management.model.Item;
//import id.ac.ui.cs.advprog.subsbox_item_management.model.SubscriptionBox;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class seed implements CommandLineRunner {
//
//    @Autowired
//    private SubscriptionBoxService subscriptionBoxService;
//
//    @Autowired
//    private ItemService itemService;
//
//    @Override
//    public void run(String... args) throws Exception {
//        String[] randomType = {"MTH", "QTR", "SAA"};
//        for (int i = 1; i <= 10000; i++) {
//            SubscriptionBox box = new SubscriptionBox();
//            box.setName("Box " + i);
//            box.setPrice(10000);
//            box.setType(randomType[(int) (Math.random() * 3)]);
//
//            List<Item> items = new ArrayList<>();
//
//            Item item = new Item();
//            item.setName("Item " + i);
//            item.setQuantity(100);
//            items.add(item);
//
//            Item item2 = new Item();
//            item2.setName("Item " + (i + 1));
//            item2.setQuantity(100);
//            items.add(item2);
//
//            box.setItems(items);
//            item.setSubscriptionBox(box);
//            item2.setSubscriptionBox(box);
//
//            subscriptionBoxService.addBox(box);
//            itemService.createItem(item);
//            itemService.createItem(item2);
//        }
//    }
//}
