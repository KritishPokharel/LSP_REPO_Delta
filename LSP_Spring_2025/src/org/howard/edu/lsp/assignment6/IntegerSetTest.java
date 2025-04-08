package org.howard.edu.lsp.assignment6;

//References Used:
// https://www.javacodegeeks.com/junit-tutorials
// https://www.vogella.com/tutorials/JUnit/article.html

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * JUnit test cases for the IntegerSet class.
 * Every test method uses the two instance variables, set1 and set2,
 * which are re-initialized before each test.
 */
public class IntegerSetTest {

    private IntegerSet set1;
    private IntegerSet set2;

    @BeforeEach
    public void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }
    
    @Test
    @DisplayName("Test case for clear()")
    public void testClear() {
        set1.add(1);
        set1.add(2);
        set1.clear();
        assertTrue(set1.isEmpty(), "After clear(), the set should be empty.");
        assertEquals(0, set1.length(), "After clear(), the length should be 0.");
    }

    @Test
    @DisplayName("Test case for length()")
    public void testLength() {
        assertEquals(0, set1.length(), "Newly created set should have length 0.");
        set1.add(5);
        set1.add(10);
        assertEquals(2, set1.length(), "After adding two elements, length should be 2.");
    }

    @Test
    @DisplayName("Test case for equals()")
    public void testEquals() {
        set1.add(1);
        set1.add(2);
        set1.add(3);
        // Adding elements in a different order in set2.
        set2.add(3);
        set2.add(1);
        set2.add(2);
        assertTrue(set1.equals(set2), "Sets with the same elements should be equal.");
        set2.add(4);
        assertFalse(set1.equals(set2), "Sets with different elements should not be equal.");
    }

    @Test
    @DisplayName("Test case for contains()")
    public void testContains() {
        set1.add(10);
        set1.add(20);
        assertTrue(set1.contains(10), "Set should contain 10.");
        assertFalse(set1.contains(5), "Set should not contain 5.");
    }

    @Test
    @DisplayName("Test case for largest()")
    public void testLargest() {
        //IntegerSetException is an unchecked exception extending RuntimeException.
        set1.add(5);
        set1.add(15);
        set1.add(10);
        assertEquals(15, set1.largest(), "The largest element should be 15.");
    }

    @Test
    @DisplayName("Test exception for largest() on an empty set")
    public void testLargestException() {
        // Expect an IntegerSetException when largest() is called on an empty set.
        IntegerSetException exception = assertThrows(IntegerSetException.class, () -> {
            set1.largest();
        }, "Calling largest() on an empty set should throw an IntegerSetException.");
        assertTrue(exception.getMessage().toLowerCase().contains("empty"), 
                   "Exception message should indicate that the set is empty.");
    }

    @Test
    @DisplayName("Test case for smallest()")
    public void testSmallest() {
        set1.add(12);
        set1.add(4);
        set1.add(7);
        assertEquals(4, set1.smallest(), "The smallest element should be 4.");
    }

    @Test
    @DisplayName("Test exception for smallest() on an empty set")
    public void testSmallestException() {
        // Expect an IntegerSetException when smallest() is called on an empty set.
        IntegerSetException exception = assertThrows(IntegerSetException.class, () -> {
            set1.smallest();
        }, "Calling smallest() on an empty set should throw an IntegerSetException.");
        assertTrue(exception.getMessage().toLowerCase().contains("empty"), 
                   "Exception message should indicate that the set is empty.");
    }

    @Test
    @DisplayName("Test case for add()")
    public void testAdd() {
        set1.add(8);
        assertTrue(set1.contains(8), "After add(), the set should contain 8.");
        int sizeBefore = set1.length();
        // Attempt to add a duplicate element.
        set1.add(8);
        assertEquals(sizeBefore, set1.length(), "Adding a duplicate should not change the set length.");
    }

    @Test
    @DisplayName("Test case for remove()")
    public void testRemove() {
        set1.add(3);
        set1.add(6);
        set1.remove(3);
        assertFalse(set1.contains(3), "After removal, set should not contain 3.");
        int sizeBefore = set1.length();
        // Attempt to remove a non-existent element.
        set1.remove(10);
        assertEquals(sizeBefore, set1.length(), "Removing a non-existent element should not change the set length.");
    }

    @Test
    @DisplayName("Test case for union()")
    public void testUnion() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.union(set2);
        IntegerSet expected = new IntegerSet();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        assertTrue(set1.equals(expected), "Union should combine both sets without duplicates.");
    }

    @Test
    @DisplayName("Test case for intersect()")
    public void testIntersect() {
        set1.add(5);
        set1.add(10);
        set1.add(15);
        set2.add(10);
        set2.add(15);
        set2.add(20);
        set1.intersect(set2);
        IntegerSet expected = new IntegerSet();
        expected.add(10);
        expected.add(15);
        assertTrue(set1.equals(expected), "Intersect should retain only the common elements.");
    }

    @Test
    @DisplayName("Test case for diff()")
    public void testDiff() {
        set1.add(2);
        set1.add(4);
        set1.add(6);
        set2.add(4);
        set2.add(8);
        set1.diff(set2);
        IntegerSet expected = new IntegerSet();
        expected.add(2);
        expected.add(6);
        assertTrue(set1.equals(expected), "Diff should remove elements from set1 that are present in set2.");
    }

    @Test
    @DisplayName("Test case for complement()")
    public void testComplement() {
        // In this test, set1 represents the current set,
        // and set2 represents the universal set.
        set1.add(3);
        set1.add(5);
        set2.add(1);
        set2.add(3);
        set2.add(5);
        set2.add(7);
        set1.complement(set2);
        IntegerSet expected = new IntegerSet();
        expected.add(1);
        expected.add(7);
        assertTrue(set1.equals(expected), "Complement should yield the elements in the universal set not in the current set.");
    }

    @Test
    @DisplayName("Test case for isEmpty()")
    public void testIsEmpty() {
        assertTrue(set1.isEmpty(), "A newly created set should be empty.");
        set1.add(9);
        assertFalse(set1.isEmpty(), "The set should not be empty after adding an element.");
    }

    @Test
    @DisplayName("Test case for toString()")
    public void testToString() {
        set1.add(11);
        set1.add(22);
        String str = set1.toString();
        assertTrue(str.contains("11"), "toString should include the element 11.");
        assertTrue(str.contains("22"), "toString should include the element 22.");
        assertTrue(str.startsWith("["), "toString should start with '['.");
        assertTrue(str.endsWith("]"), "toString should end with ']'.");
    }
}
