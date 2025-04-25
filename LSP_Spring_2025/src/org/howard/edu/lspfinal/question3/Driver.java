package org.howard.edu.lspfinal.question3;

/**
 * Demo class showing how to plug in different Report subclasses
 * without changing the core workflow.
 */
public class Driver {

    /**
     * Entry point: creates and runs two kinds of reports.
     * @param args command-line arguments (ignored)
     */
    public static void main(String[] args) {
        // Generate sales report
        Report salesReport = new SalesReport();
        salesReport.generateReport();

        // Generate inventory report
        Report inventoryReport = new InventoryReport();
        inventoryReport.generateReport();
    }
}
