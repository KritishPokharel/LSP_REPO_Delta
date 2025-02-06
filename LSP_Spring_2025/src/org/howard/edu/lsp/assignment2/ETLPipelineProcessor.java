package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ETLPipelineProcessor arrange the entire ETL pipeline.
 */
public class ETLPipelineProcessor {
    private static final String INPUT_FILE = "data/products.csv";
    private static final String OUTPUT_FILE = "data/transformed_products.csv";

    public static void main(String[] args) {
        List<InventoryItem> productList = extractData();
        if (productList.isEmpty()) {
            System.err.println("No valid data found in source file! Exiting.");
            return;
        }

        DataTransformer.processItems(productList); // Call Transformer

        loadData(productList);
    }

    /**
     * Extracts data from CSV file into a list of InventoryItem objects.
     */
    private static List<InventoryItem> extractData() {
        List<InventoryItem> items = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE))) {
            String line;
            boolean isFirstRow = true;

            while ((line = br.readLine()) != null) {
                if (isFirstRow) { 
                    isFirstRow = false;
                    continue;
                }
                String[] fields = line.split(",");
                if (fields.length < 4) continue;

                int id = Integer.parseInt(fields[0].trim());
                String name = fields[1].trim();
                double price = Double.parseDouble(fields[2].trim());
                String category = fields[3].trim();

                items.add(new InventoryItem(id, name, price, category));
            }
        } catch (IOException e) {
            System.err.println("ERROR: Unable to read input file '" + INPUT_FILE + "'. Ensure it exists.");
        }
        return items;
    }

    /**
     * Loads transformed data into the output CSV file.
     */
    private static void loadData(List<InventoryItem> items) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            bw.write("ProductID,Name,Price,Category,PriceRange");
            bw.newLine();

            for (InventoryItem item : items) {
                bw.write(item.toString());
                bw.newLine();
            }
            System.out.println("SUCCESS: Processed data saved to '" + OUTPUT_FILE + "'");
        } catch (IOException e) {
            System.err.println("ERROR: Unable to write to output file '" + OUTPUT_FILE + "'.");
        }
    }
}
