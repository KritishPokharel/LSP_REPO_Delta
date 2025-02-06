package org.howard.edu.lsp.assignment2;

/**
 * InventoryItem represents a product from the given dataset.
 * So this file contains product details and methods to manage its attributes.
 */
public class InventoryItem {
    private int id;
    private String title;
    private double cost;
    private String category;
    private String priceBand; // Renamed price range to make it unique

    /**
     * Constructs an InventoryItem.
     */
    public InventoryItem(int id, String title, double cost, String category) {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.category = category;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getPriceBand() { return priceBand; }
    public void setPriceBand(String priceBand) { this.priceBand = priceBand; }

    @Override
    public String toString() {
        return id + "," + title + "," + String.format("%.2f", cost) + "," + category + "," + priceBand;
    }
}
