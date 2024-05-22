package id.ac.ui.cs.advprog.subsbox_item_management.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import id.ac.ui.cs.advprog.subsbox_item_management.model.Item;
import id.ac.ui.cs.advprog.subsbox_item_management.service.ItemService;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



public class ItemControllerTest {
        
        private MockMvc mockMvc;
    
        @Mock
        private ItemService itemService;
    
        @InjectMocks
        private ItemController itemController;

        private ObjectMapper objectMapper = new ObjectMapper();
    
        @BeforeEach
        public void setUp() {
            MockitoAnnotations.initMocks(this);
            mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();
        }
    
        @Test
        public void testCreateItem() throws JsonProcessingException, Exception {
            Item item = new Item();
            item.setId(UUID.randomUUID().toString());
            item.setName("Test Item");
            item.setQuantity(100000);
    
            given(itemService.createItem(any(Item.class))).willReturn(item);
    
            mockMvc.perform(post("/item/create")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(item)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value(item.getId()))
                    .andExpect(jsonPath("$.name").value(item.getName()))
                    .andExpect(jsonPath("$.quantity").value(item.getQuantity()));
        }
    

        @Test
        public void testGetAllItems() {
            List<Item> items = new ArrayList<>();
            Item item1 = new Item();
            item1.setId("1");
            item1.setName("Item 1");
            item1.setQuantity(100000);
            items.add(item1);
    
            Item item2 = new Item();
            item2.setId("2");
            item2.setName("Item 2");
            item2.setQuantity(200000);
            items.add(item2);
    
            when(itemService.getAllItems()).thenReturn(items);
    
            assertEquals(items, itemService.getAllItems());
        }

        @Test
        public void testGetItemById() {
            Item item = new Item();
            item.setId("1");
            item.setName("Item 1");
            item.setQuantity(100000);
    
            when(itemService.getItemById("1")).thenReturn(item);
    
            assertEquals(item, itemService.getItemById("1"));
        }

        @Test
        public void testEditItem() {
            Item item = new Item();
            item.setId("1");
            item.setName("Item 1");
            item.setQuantity(100000);
    
            when(itemService.editItem(item)).thenReturn(item);
    
            assertEquals(item, itemService.editItem(item));
        }

        @Test
        public void testDeleteItem() {
            Item item = new Item();
            item.setId("1");
            item.setName("Item 1");
            item.setQuantity(100000);
    
            when(itemService.deleteItem(item)).thenReturn(item);
    
            assertEquals(item, itemService.deleteItem(item));
        }

}
