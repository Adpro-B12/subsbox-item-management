package id.ac.ui.cs.advprog.subsbox_item_management.controller;

import static org.mockito.ArgumentMatchers.any;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import id.ac.ui.cs.advprog.subsbox_item_management.model.Item;
import id.ac.ui.cs.advprog.subsbox_item_management.service.ItemService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
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
        public void testCreateItem() throws Exception {
            Item item = new Item();
            item.setId(1L);
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
        public void testGetAllItems() throws Exception {
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

            given(itemService.getAllItems()).willReturn(items);

            mockMvc.perform(get("/item/getAll"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].id").value(item1.getId()))
                    .andExpect(jsonPath("$[0].name").value(item1.getName()))
                    .andExpect(jsonPath("$[0].quantity").value(item1.getQuantity()))
                    .andExpect(jsonPath("$[1].id").value(item2.getId()))
                    .andExpect(jsonPath("$[1].name").value(item2.getName()))
                    .andExpect(jsonPath("$[1].quantity").value(item2.getQuantity()));   
        }

        @Test
        public void testGetItemById() throws Exception {
            Item item = new Item();
            item.setId(1L);
            item.setName("Item 1");
            item.setQuantity(100000);

            given(itemService.getItemById(any(Long.class))).willReturn(item);

            mockMvc.perform(get("/item/get/"+String.valueOf(1L)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value(item.getId()))
                    .andExpect(jsonPath("$.name").value(item.getName()))
                    .andExpect(jsonPath("$.quantity").value(item.getQuantity()));
        }

        @Test
        public void testEditItem() throws Exception {
            Item item = new Item();
            item.setId(1L);
            item.setName("Item 1");
            item.setQuantity(100000);

            given(itemService.editItem(any(Item.class), any(Long.class))).willReturn(item);

            mockMvc.perform(put("/item/edit/"+String.valueOf(1L))
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(item)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value(item.getId()))
                    .andExpect(jsonPath("$.name").value(item.getName()))
                    .andExpect(jsonPath("$.quantity").value(item.getQuantity()));
        }

        @Test
        public void testDeleteItem() throws Exception {
            Item item = new Item();
            item.setId(1L);
            item.setName("Item 1");
            item.setQuantity(100000);

            mockMvc.perform(delete("/item/delete/"+String.valueOf(1L)))
                    .andExpect(status().isOk());
        }

}
