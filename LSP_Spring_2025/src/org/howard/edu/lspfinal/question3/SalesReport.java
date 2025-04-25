package org.howard.edu.lspfinal.question3;
//References Used:
//https://www.geeksforgeeks.org/java/
//https://www.programiz.com/java-programming
/**
 * Concrete Report implementation tailored to the Sales department.
 * <p>
 * Handles loading sales figures, formatting currency and totals,
 * and printing out a sales summary.
 * </p>
 */
public class SalesReport extends Report {

    /**
     * Fetches sales metrics from the data source.
     */
    @Override
    protected void loadData() {
        System.out.println("Loading sales data...");
    }

    /**
     * Aggregates and decorates sales numbers (currency symbols, decimals).
     */
    @Override
    protected void formatData() {
        System.out.println("Formatting sales data...");
    }

    /**
     * Sends the sales report to the printer or generates a PDF.
     */
    @Override
    protected void printReport() {
        System.out.println("Printing sales report.\n");
    }
}
