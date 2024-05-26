package id.ac.ui.cs.advprog.subsbox_item_management.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class SubscriptionBoxTest {
    List<Item> items;
    SubscriptionBox subscriptionBox;
    @BeforeEach
    void setUp() {
        this.subscriptionBox = new SubscriptionBox();
        this.subscriptionBox.setId(5L);
        this.subscriptionBox.setName("BOX1");
        this.subscriptionBox.setType("MTH");
        this.subscriptionBox.setPrice(100000);
    }

    @Test
    void testGetId() {
        assertEquals(5L, subscriptionBox.getId());
    }

    @Test
    void testGetName() {
        assertEquals("BOX1", subscriptionBox.getName());
    }

    @Test
    void testGetType() {
        assertEquals("MTH", subscriptionBox.getType());
    }

    @Test
    void testGetPrice() {
        assertEquals(100000, subscriptionBox.getPrice());
    }


    Long generateRandomLong() {
        return (long) (Math.random() * 1000);
    }
}
