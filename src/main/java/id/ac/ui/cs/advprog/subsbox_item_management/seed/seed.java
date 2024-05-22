package id.ac.ui.cs.advprog.subsbox_item_management.seed;
import id.ac.ui.cs.advprog.subsbox_item_management.service.SubscriptionBoxService;
import id.ac.ui.cs.advprog.subsbox_item_management.model.SubscriptionBox;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class seed implements CommandLineRunner {

    @Autowired
    private SubscriptionBoxService SubscriptionBoxService;

    @Override
    public void run(String... args) throws Exception {
        String[] randomType = {"MTH","QTR","SAA"};
        for (int i = 0; i < 10000; i++) {
            SubscriptionBox box = new SubscriptionBox();
            box.setName("Box " + i);
            box.setPrice(10000);
            box.setType(randomType[(int) (Math.random() * 3)]);
//            box.setItems(null);

            SubscriptionBoxService.addBox(box);
        }
    }

}
