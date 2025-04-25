package org.howard.edu.lspfinal.question1;

//References Used:
//https://www.javacodegeeks.com/junit-tutorials
//https://www.vogella.com/tutorials/JUnit/article.html

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    private ShoppingCart cart;
    private static final double DELTA = 1e-6;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    // 1. Test adding items

    @Test
    @DisplayName("Test for adding valid item")
    void testAddValidItem() {
        cart.addItem("Book", 12.99);
        assertEquals(1, cart.getCartSize());
        assertEquals(12.99, cart.getTotalCost(), DELTA);
    }

    @Test
    @DisplayName("Test for adding item with empty name (expect exception)")
    void testAddEmptyName() {
        assertThrows(IllegalArgumentException.class,
            () -> cart.addItem("", 5.00));
    }

    @Test
    @DisplayName("Test for adding item with 0 price (expect exception)")
    void testAddZeroPrice() {
        assertThrows(IllegalArgumentException.class,
            () -> cart.addItem("FreeSample", 0.0));
    }

    @Test
    @DisplayName("Test for adding item with negative price (expect exception)")
    void testAddNegativePrice() {
        assertThrows(IllegalArgumentException.class,
            () -> cart.addItem("ErrorItem", -5.00));
    }


    // 2. Test removing items

    @Test
    @DisplayName("Test removing existing item")
    void testRemoveExistingItem() {
        cart.addItem("Pen", 1.50);
        assertEquals(1, cart.getCartSize());
        cart.removeItem("Pen");
        assertEquals(0, cart.getCartSize());
        assertEquals(0.0, cart.getTotalCost(), DELTA);
    }

    @Test
    @DisplayName("Test removing non-existent item (expect exception)")
    void testRemoveNonExistentItem() {
        assertThrows(IllegalArgumentException.class,
            () -> cart.removeItem("Notebook"));
    }


    // 3. Test total cost

    @Test
    @DisplayName("Test total cost without discount")
    void testTotalCostNoDiscount() {
        cart.addItem("Pen", 1.50);
        cart.addItem("Notebook", 2.50);
        assertEquals(4.00, cart.getTotalCost(), DELTA);
    }

    @Test
    @DisplayName("Test total cost with empty cart")
    void testTotalCostEmptyCart() {
        assertEquals(0.0, cart.getTotalCost(), DELTA);
    }


    // 4. Test applying discount codes

    @Test
    @DisplayName("Test for applying \"SAVE10\"")
    void testApplySave10() {
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage(), DELTA);
    }

    @Test
    @DisplayName("Test for applying \"SAVE20\"")
    void testApplySave20() {
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage(), DELTA);
    }

    @Test
    @DisplayName("Test for applying invalid code (expect exception)")
    void testApplyInvalidCode() {
        assertThrows(IllegalArgumentException.class,
            () -> cart.applyDiscountCode("SAVE50"));
    }

    @Test
    @DisplayName("Test for applying invalid code (empty string)")
    void testApplyInvalidCodeEmpty() {
        assertThrows(IllegalArgumentException.class,
            () -> cart.applyDiscountCode(""));
    }


    // 5. Test total cost with discount & cart size behavior

    @Test
    @DisplayName("Test total cost with discount")
    void testTotalCostWithDiscount() {
        cart.addItem("Chair", 100.00);
        cart.addItem("Table", 200.00);
        assertEquals(2, cart.getCartSize());

        cart.applyDiscountCode("SAVE10"); 
        assertEquals(270.00, cart.getTotalCost(), DELTA);

        // ensure cart size didn't change
        assertEquals(2, cart.getCartSize());
    }
}
