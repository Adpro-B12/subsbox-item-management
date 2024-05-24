package id.ac.ui.cs.advprog.subsbox_item_management.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import id.ac.ui.cs.advprog.subsbox_item_management.model.Item;
import id.ac.ui.cs.advprog.subsbox_item_management.repository.ItemRepository;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

   @InjectMocks
   private ItemServiceImpl itemService;

   @Mock
   private ItemRepository itemRepository;

   @BeforeEach
   public void setUp() {

   }

   @Test
   public void testCreateItem() {
       Item item = new Item();
       item.setId(1L);
       item.setName("Item 1");
       item.setQuantity(100000);

       when(itemRepository.save(item)).thenReturn(item);

       assertEquals(item, itemService.createItem(item));
   }

   @Test
   public void testGetAllItems() {
       List<Item> items = new ArrayList<>();
       Item item1 = new Item();
       item1.setId(1L);
       item1.setName("Item 1");
       item1.setQuantity(100000);
       items.add(item1);

       Item item2 = new Item();
       item2.setId(2L);
       item2.setName("Item 2");
       item2.setQuantity(200000);
       items.add(item2);

       when(itemRepository.findAll()).thenReturn(items);

       assertEquals(items, itemService.getAllItems());
   }

   @Test
   public void testGetItemById() {
       Item item = new Item();
       item.setId(1L);
       item.setName("Item 1");
       item.setQuantity(100000);

       when(itemRepository.findById(1L)).thenReturn(java.util.Optional.of(item));

       assertEquals(item, itemService.getItemById(1L));
   }

   @Test
   public void testEditItem() {
        Item item = new Item();
        item.setId(1L);
        item.setName("Item 1");
        item.setQuantity(100000);

        when(itemRepository.findById(1L)).thenReturn(java.util.Optional.of(item));
        when(itemRepository.save(item)).thenReturn(item);

        assertEquals(item, itemService.editItem(item, 1L));
   }

   @Test
   public void testDeleteItem() {
       Item item = new Item();
       item.setId(1L);
       item.setName("Item 1");
       item.setQuantity(100000);

       itemService.deleteItem(item);

       assertEquals(null, itemService.getItemById(1L));
   }
}
