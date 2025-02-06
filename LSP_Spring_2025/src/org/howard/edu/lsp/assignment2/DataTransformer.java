/**
 * Name: Kritish Pokharel
 */
package org.howard.edu.lsp.assignment2;

import java.util.List;

/**
 * DataTransformer handles all required transformation logic separately.
 */
public class DataTransformer {

    /**
     * Transforms a list of InventoryItem objects according to given rules in the assignment.
     */
    public static void processItems(List<InventoryItem> items) {
        for (InventoryItem item : items) {
            // Convert product name to uppercase
            item.setTitle(item.getTitle().toUpperCase());

            // Apply discount for Electronics category first
            if (item.getCategory().equalsIgnoreCase("Electronics")) {
                double initialCost = item.getCost();
                double updatedCost = initialCost * 0.90; // Apply 10% discount
                updatedCost = Math.round(updatedCost * 100.0) / 100.0;
                item.setCost(updatedCost);

                // Now check if it qualifies as Premium Electronics
                if (updatedCost > 500) {
                    item.setCategory("Premium Electronics");
                }
            }

            // Assign Price Band Range
            double finalCost = item.getCost();
            if (finalCost <= 10) {
                item.setPriceBand("Low");
            } else if (finalCost <= 100) {
                item.setPriceBand("Medium");
            } else if (finalCost <= 500) {
                item.setPriceBand("High");
            } else {
                item.setPriceBand("Premium");
            }
        }
    }
}
