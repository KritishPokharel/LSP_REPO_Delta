package org.howard.edu.lsp.assignment6;

import org.howard.edu.lsp.assignment5.IntegerSet;

/**
 * The Driver class is used to test the functionality of the IntegerSet class.
 * It demonstrates various operations as specified in the requirements.
 */
public class Driver {

    /**
     * The main method that runs tests on the IntegerSet methods.
     *
     * @param args command line arguments (not used).
     */
    public static void main(String[] args) {

        // Testing add() and toString() methods.
        System.out.println("Testing add and toString:");
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("Set1: " + set1.toString());

        // Testing smallest() and largest() methods.
        System.out.println("\nTesting smallest and largest:");
        System.out.println("Smallest in Set1: " + set1.smallest());
        System.out.println("Largest in Set1: " + set1.largest());

        // Testing union() method.
        System.out.println("\nTesting union:");
        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        System.out.println("Set1 before union: " + set1.toString());
        System.out.println("Set2: " + set2.toString());
        set1.union(set2);
        System.out.println("Set1 after union with Set2: " + set1.toString());

        // Testing intersect() method.
        System.out.println("\nTesting intersection:");
        IntegerSet set3 = new IntegerSet();
        set3.add(2);
        set3.add(3);
        set3.add(6);
        System.out.println("Set1 before intersection: " + set1.toString());
        System.out.println("Set3: " + set3.toString());
        set1.intersect(set3);
        System.out.println("Set1 after intersection with Set3: " + set1.toString());

        // Testing diff() method.
        System.out.println("\nTesting difference:");
        IntegerSet set4 = new IntegerSet();
        set4.add(3);
        System.out.println("Set1 before difference: " + set1.toString());
        System.out.println("Set4: " + set4.toString());
        set1.diff(set4);
        System.out.println("Set1 after difference with Set4 (removing 3): " + set1.toString());

        // Testing complement() method.
        System.out.println("\nTesting complement:");
        // Assume set5 is the universal set.
        IntegerSet set5 = new IntegerSet();
        set5.add(1);
        set5.add(2);
        set5.add(3);
        set5.add(4);
        set5.add(5);
        System.out.println("Set1 before complement: " + set1.toString());
        System.out.println("Universal Set (Set5): " + set5.toString());
        set1.complement(set5);
        System.out.println("Set1 after complement relative to Set5: " + set1.toString());

        // Testing isEmpty() and clear() methods.
        System.out.println("\nTesting isEmpty and clear:");
        IntegerSet set6 = new IntegerSet();
        System.out.println("Set6 is empty: " + set6.isEmpty());
        set6.add(10);
        System.out.println("Set6 after adding 10: " + set6.toString());
        set6.clear();
        System.out.println("Set6 after clear: " + set6.toString());
        System.out.println("Set6 is empty: " + set6.isEmpty());

        // Testing equals() method.
        System.out.println("\nTesting equals:");
        IntegerSet set7 = new IntegerSet();
        set7.add(1);
        set7.add(2);
        set7.add(3);
        IntegerSet set8 = new IntegerSet();
        set8.add(3);
        set8.add(2);
        set8.add(1);
        System.out.println("Set7: " + set7.toString());
        System.out.println("Set8: " + set8.toString());
        System.out.println("Set7 equals Set8: " + set7.equals(set8));
    }
}
