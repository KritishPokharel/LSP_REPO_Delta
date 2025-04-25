package org.howard.edu.lspfinal.question3;
//References Used:
//https://www.geeksforgeeks.org/java/
//https://www.programiz.com/java-programming
/**
 * Abstract base class that centralizes the common steps for generating any report.
 * <p>
 * Uses the Template Method pattern to enforce the sequence:
 *   1. loadData()
 *   2. formatData()
 *   3. printReport()
 * </p>
 */
public abstract class Report {

    /**
     * Executes the full report workflow in a fixed order.
     * <p>
     * This method is final to prevent subclasses from altering the sequence.
     * </p>
     */
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    /**
     * Loads the raw data needed for the report.
     * <p>
     * Subclasses must provide their own data-loading logic.
     * </p>
     */
    protected abstract void loadData();

    /**
     * Applies any necessary transformations or formatting to the loaded data.
     * <p>
     * Subclasses implement department-specific formatting here.
     * </p>
     */
    protected abstract void formatData();

    /**
     * Outputs the final, formatted report.
     * <p>
     * Subclasses decide how and where to print or export the report.
     * </p>
     */
    protected abstract void printReport();
}
