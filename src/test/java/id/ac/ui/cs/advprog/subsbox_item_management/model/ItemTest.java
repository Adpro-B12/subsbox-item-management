package id.ac.ui.cs.advprog.subsbox_item_management.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

   @Test
    void testItemId() {
       Item item = new Item();
       item.setId(1L);
       assertEquals(1L, item.getId());
   }

   @Test
    void testItemName() {
       Item item = new Item();
       item.setName("Test Item");
       assertEquals("Test Item", item.getName());
   }

   @Test
    void testItemQuantity() {
       Item item = new Item();
       item.setQuantity(10);
       assertEquals(10, item.getQuantity());
   }


}
