package id.ac.ui.cs.advprog.subsbox_item_management.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SubscriptionBoxTest {
    List<Item> items;
    SubscriptionBox subscriptionBox;
    @BeforeEach
    public void setUp() {
        this.subscriptionBox = new SubscriptionBox();
        this.subscriptionBox.setId(5L);
        this.subscriptionBox.setName("BOX1");
        this.subscriptionBox.setType("MTH");
        this.subscriptionBox.setPrice(100000);
    }

    @Test
    public void testGetId() {
        assertEquals(5L, subscriptionBox.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("BOX1", subscriptionBox.getName());
    }

    @Test
    public void testGetType() {
        assertEquals("MTH", subscriptionBox.getType());
    }

    @Test
    public void testGetPrice() {
        assertEquals(100000, subscriptionBox.getPrice());
    }


    public Long generateRandomLong() {
        return (long) (Math.random() * 1000);
    }
}
