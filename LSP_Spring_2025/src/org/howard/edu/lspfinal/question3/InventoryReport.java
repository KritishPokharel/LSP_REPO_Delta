package org.howard.edu.lspfinal.question3;
//References Used:
//https://www.geeksforgeeks.org/java/
//https://www.programiz.com/java-programming

/**
 * Concrete Report implementation for the Inventory department.
 * <p>
 * Responsible for retrieving stock levels, flagging shortages,
 * and delivering an inventory overview to stakeholders.
 * </p>
 */
public class InventoryReport extends Report {

    /**
     * Retrieves current stock and reorder thresholds.
     */
    @Override
    protected void loadData() {
        System.out.println("Loading inventory data...");
    }

    /**
     * Highlights low-stock items and groups by warehouse location.
     */
    @Override
    protected void formatData() {
        System.out.println("Formatting inventory data...");
    }

    /**
     * Dispatches the formatted inventory report via email or dashboard.
     */
    @Override
    protected void printReport() {
        System.out.println("Printing inventory report.\n");
    }
}
