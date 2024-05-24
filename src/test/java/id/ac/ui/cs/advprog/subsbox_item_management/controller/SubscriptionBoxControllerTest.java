package id.ac.ui.cs.advprog.subsbox_item_management.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import id.ac.ui.cs.advprog.subsbox_item_management.model.SubscriptionBox;
import id.ac.ui.cs.advprog.subsbox_item_management.service.SubscriptionBoxService;
import io.micrometer.core.ipc.http.HttpSender.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class SubscriptionBoxControllerTest {
    
    private MockMvc mockMvc;

    @Mock
    private SubscriptionBoxService subscriptionBoxService;

    @InjectMocks
    private SubscriptionBoxController subscriptionBoxController;

    @Mock
    private Model model;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(subscriptionBoxController).build();
    }

    @Test
    public void testCreateSubscriptionBox() throws Exception {
        SubscriptionBox subscriptionBox = new SubscriptionBox();
        subscriptionBox.setId(UUID.randomUUID().toString());
        subscriptionBox.setName("Test Subscription Box");
        subscriptionBox.setPrice(100000);
        // subscriptionBox.setRating(5);

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
    public void testEditSubscriptionBox() throws Exception {
        SubscriptionBox subscriptionBox = new SubscriptionBox();
        subscriptionBox.setId(UUID.randomUUID().toString());
        subscriptionBox.setName("Test Subscription Box");
        subscriptionBox.setPrice(100000);
        // subscriptionBox.setRating(5);

        when( subscriptionBoxService.editBox(any(String.class), any(SubscriptionBox.class))).thenReturn(subscriptionBox);

        assertEquals(subscriptionBox, subscriptionBoxService.editBox(subscriptionBox.getId(), subscriptionBox));
    }

    @Test
    public void testDeleteSubscriptionBox() throws Exception {
        SubscriptionBox subscriptionBox = new SubscriptionBox();
        subscriptionBox.setId(UUID.randomUUID().toString());
        subscriptionBox.setName("Test Subscription Box");
        subscriptionBox.setPrice(100000);
        // subscriptionBox.setRating(5);

        ResponseEntity<SubscriptionBox> response = subscriptionBoxController.deleteBox(subscriptionBox.getId());

        assertEquals(response.getStatusCodeValue(), 200);

    }

    @Test
    public void testViewSubscriptionBox() throws Exception {
        SubscriptionBox subscriptionBox = new SubscriptionBox();
        subscriptionBox.setId("1");
        subscriptionBox.setName("Test Subscription Box");
        subscriptionBox.setPrice(100000);
        // subscriptionBox.setRating(5);

        given(subscriptionBoxService.viewDetails("1")).willReturn(subscriptionBox.getName());

        mockMvc.perform(get("/subscription-box/viewDetails/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(subscriptionBox.getName()));
    }

    @Test
    public void testViewAllSubscriptionBox() throws Exception {
        List<SubscriptionBox> subscriptionBoxes = new ArrayList<>();
        SubscriptionBox subscriptionBox = new SubscriptionBox();
        subscriptionBox.setId(UUID.randomUUID().toString());
        subscriptionBox.setName("Test Subscription Box");
        subscriptionBox.setPrice(100000);
        // subscriptionBox.setRating(5);
        subscriptionBoxes.add(subscriptionBox);

        given(subscriptionBoxService.viewAll()).willReturn(subscriptionBoxes);

        mockMvc.perform(get("/subscription-box/viewAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(subscriptionBox.getId()))
                .andExpect(jsonPath("$[0].name").value(subscriptionBox.getName()))
                .andExpect(jsonPath("$[0].price").value(subscriptionBox.getPrice()));
    }

    @Test
    public void testFilterByPrice() throws Exception {
        mockMvc.perform(get("/subscription-box/filterByPrice/100000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    // @Test
    // public void testFilterByRating() throws Exception {
    //     mockMvc.perform(get("/subscription-box/filterByRating/5"))
    //             .andExpect(status().isOk())
    //             .andExpect(view().name("viewHTML"));
    // }
}
