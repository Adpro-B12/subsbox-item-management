package id.ac.ui.cs.advprog.subsbox_item_management.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import id.ac.ui.cs.advprog.subsbox_item_management.model.SubscriptionBox;
import id.ac.ui.cs.advprog.subsbox_item_management.repository.SubscriptionBoxRepository;

@ExtendWith(MockitoExtension.class)
public class SubscriptionBoxServiceTest {

   @InjectMocks
   private SubscriptionBoxServiceImpl subscriptionBoxService;

   @Mock
   private SubscriptionBoxRepository subscriptionBoxRepository;

   @BeforeEach
   public void setUp() {
       SubscriptionBox box1 = new SubscriptionBox();
       box1.setId(1L); // Change the argument to a long value
       box1.setName("Box 1");
       box1.setPrice(100000);
       box1.setType("MTH");
       subscriptionBoxService.addBox(box1);
   }

   @Test
   public void testAddBox() {
       SubscriptionBox box2 = new SubscriptionBox();
       box2.setId(2L); // Change the argument to a long value
       box2.setName("Box 2");
       box2.setPrice(200000);
       box2.setType("MTH");

       when(subscriptionBoxRepository.save(box2)).thenReturn(box2);
       subscriptionBoxService.addBox(box2);

       when(subscriptionBoxRepository.findAll()).thenReturn(List.of(box2, box2));
       assertEquals(2, subscriptionBoxService.viewAll().size());
   }

   @Test
   public void testEditBox() {
       SubscriptionBox box = new SubscriptionBox();
       box.setId(1L); // Change the argument to a long value
       box.setName("Box 1");
       box.setPrice(100000);
       box.setType("MTH");

       SubscriptionBox updatedBox = new SubscriptionBox();
       updatedBox.setId(1L); // Change the argument to a long value
       updatedBox.setName("Updated Box 1");
       updatedBox.setPrice(150000);
       updatedBox.setType("SAA");

       when(subscriptionBoxRepository.findById(1L)).thenReturn(Optional.of(box)); // Change the argument to a long value
       when(subscriptionBoxRepository.save(box)).thenReturn(updatedBox);

       SubscriptionBox result = subscriptionBoxService.editBox(1L, updatedBox); // Change the argument to a long value

       assertEquals("Updated Box 1", result.getName());
       assertEquals(150000, result.getPrice());
       assertEquals("SAA", result.getType());
       assertEquals(box.getItems(), result.getItems());
   }

   @Test
   public void testDeleteBox() {
       SubscriptionBox box1 = new SubscriptionBox();
       box1.setId(1L); // Change the argument to a long value
       box1.setName("Box 1");
       box1.setPrice(100000);
       box1.setType("MTH");

       doNothing().when(subscriptionBoxRepository).deleteById(1L); // Change the argument to a long value
       subscriptionBoxService.deleteBox(1L); // Change the argument to a long value
       assertEquals(0, subscriptionBoxService.viewAll().size());
   }

   @Test
   public void testViewAll() {
       SubscriptionBox box1 = new SubscriptionBox();
       box1.setId(1L); // Change the argument to a long value
       box1.setName("Box 1");
       box1.setPrice(100000);
       box1.setType("MTH");

       when(subscriptionBoxRepository.findAll()).thenReturn(List.of(box1));
       assertEquals(1, subscriptionBoxService.viewAll().size());
   }

   @Test
   public void testViewDetails() {
       SubscriptionBox box = new SubscriptionBox();
       box.setId(1L); // Change the argument to a long value
       box.setName("Box 1");
       box.setPrice(100000);
       box.setType("MTH");

       when(subscriptionBoxRepository.findById(1L)).thenReturn(java.util.Optional.of(box)); // Change the argument to a long value
       assertEquals("Box 1", subscriptionBoxService.viewDetails(1L)); // Change the argument to a long value
   }

   @Test
   public void testFilterByPrice() {
       SubscriptionBox box1 = new SubscriptionBox();
       box1.setId(1L);
       box1.setName("Box 1");
       box1.setPrice(100000);
       box1.setType("MTH");

       SubscriptionBox box2 = new SubscriptionBox();
       box2.setId(2L);
       box2.setName("Box 2");
       box2.setPrice(200000);
       box2.setType("MTH");

       when(subscriptionBoxRepository.findAll()).thenReturn(List.of(box1, box2));
       List<SubscriptionBox> boxes = subscriptionBoxService.filterByPrice(100000);
       assertEquals(1, boxes.size());
   }
}
