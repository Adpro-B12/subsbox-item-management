package id.ac.ui.cs.advprog.subsbox_item_management.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import id.ac.ui.cs.advprog.subsbox_item_management.model.SubscriptionBox;
import id.ac.ui.cs.advprog.subsbox_item_management.service.SubscriptionBoxService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class SubscriptionBoxControllerTest {

   private MockMvc mockMvc;

   @Mock
   private SubscriptionBoxService subscriptionBoxService;

   @InjectMocks
   private SubscriptionBoxController subscriptionBoxController;

   @Mock
   private Model model;

   private final ObjectMapper objectMapper = new ObjectMapper();

   @BeforeEach
    void setUp() {
       MockitoAnnotations.initMocks(this);
       mockMvc = MockMvcBuilders.standaloneSetup(subscriptionBoxController).build();
   }

   @Test
    void testCreateSubscriptionBox() throws Exception {
       SubscriptionBox subscriptionBox = new SubscriptionBox();
       subscriptionBox.setId(generateRandomLong());
       subscriptionBox.setName("Test Subscription Box");
       subscriptionBox.setPrice(100000);

       given(subscriptionBoxService.addBox(any(SubscriptionBox.class))).willReturn(subscriptionBox);

       mockMvc.perform(post("/subscription-box/create")
               .contentType(MediaType.APPLICATION_JSON)
               .content(objectMapper.writeValueAsString(subscriptionBox)))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id").value(subscriptionBox.getId()))
               .andExpect(jsonPath("$.name").value(subscriptionBox.getName()))
               .andExpect(jsonPath("$.price").value(subscriptionBox.getPrice()));
   }

   @Test    
    void testEditSubscriptionBox() throws Exception {
       SubscriptionBox subscriptionBox = new SubscriptionBox();
       long id = 1L;
       subscriptionBox.setId(id);
       subscriptionBox.setName("Test Subscription Box");
       subscriptionBox.setPrice(100000);

       given(subscriptionBoxService.editBox(any(Long.class),any(SubscriptionBox.class))).willReturn(subscriptionBox);

         mockMvc.perform(put("/subscription-box/edit/"+String.valueOf(id))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(subscriptionBox)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(subscriptionBox.getId()))
                .andExpect(jsonPath("$.name").value(subscriptionBox.getName()))
                .andExpect(jsonPath("$.price").value(subscriptionBox.getPrice()));
   }

   @Test
    void testDeleteSubscriptionBox() throws Exception {
       SubscriptionBox subscriptionBox = new SubscriptionBox();
       subscriptionBox.setId(generateRandomLong());
       subscriptionBox.setName("Test Subscription Box");
       subscriptionBox.setPrice(100000);

       ResponseEntity<SubscriptionBox> response = subscriptionBoxController.deleteBox(subscriptionBox.getId());

       assertEquals(200,response.getStatusCodeValue() );

   }

   @Test
    void testViewSubscriptionBox() throws Exception {
       SubscriptionBox subscriptionBox = new SubscriptionBox();
       subscriptionBox.setId(1L);
       subscriptionBox.setName("Test Subscription Box");
       subscriptionBox.setPrice(100000);

       given(subscriptionBoxService.viewDetails(1L)).willReturn(subscriptionBox);

       mockMvc.perform(get("/subscription-box/viewDetails/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(subscriptionBox.getId()))
                .andExpect(jsonPath("$.name").value(subscriptionBox.getName()))
                .andExpect(jsonPath("$.price").value(subscriptionBox.getPrice()));
   }

   @Test
    void testViewAllSubscriptionBox() throws Exception {
       List<SubscriptionBox> subscriptionBoxes = new ArrayList<>();
       SubscriptionBox subscriptionBox = new SubscriptionBox();
       subscriptionBox.setId(generateRandomLong());
       subscriptionBox.setName("Test Subscription Box");
       subscriptionBox.setPrice(100000);
       subscriptionBoxes.add(subscriptionBox);

       given(subscriptionBoxService.getAllBoxes()).willReturn(subscriptionBoxes);

       mockMvc.perform(get("/subscription-box/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(subscriptionBox.getId()))
                .andExpect(jsonPath("$[0].name").value(subscriptionBox.getName()))
                .andExpect(jsonPath("$[0].price").value(subscriptionBox.getPrice()));
   }

   @Test
        void testGetFilteredSubscriptionBoxesByPrice() throws Exception {
         mockMvc.perform(get("/subscription-box/price")
                .param("minPrice", "100000")
                .param("maxPrice", "200000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
        void testGetFilteredSubscriptionBoxesByName() throws Exception {
        mockMvc.perform(get("/subscription-box/name")
                .param("name", "Test Subscription Box"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    Long generateRandomLong() {
       return (long) (Math.random() * 1000);
   }
}
