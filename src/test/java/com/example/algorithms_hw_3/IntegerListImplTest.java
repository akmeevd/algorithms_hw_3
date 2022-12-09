package com.example.algorithms_hw_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class IntegerListImplTest {
    private IntegerListImpl expected;
    private IntegerListImpl actual;

    @BeforeEach
    public void setUp() {
        expected = new IntegerListImpl(4);
        expected.add(3);
        expected.add(1);
        expected.add(2);
        expected.add(4);
        actual = new IntegerListImpl(4);
        actual.add(3);
        actual.add(1);
        actual.add(2);
        actual.add(4);
    }

    @Test
    public void addString() {
        Assertions.assertTrue(expected.equals(actual));
    }

    @Test
    public void addByIndex() {
        expected.add(1, 1);
        actual.add(1, 1);
        Assertions.assertTrue(expected.equals(actual));
    }

    @Test
    public void set() {
        expected.set(1, 1);
        actual.set(1, 1);
        Assertions.assertTrue(expected.equals(actual));
    }

    @Test
    public void removeByIndex() {
        expected.remove(1);
        actual.remove(1);
        Assertions.assertTrue(expected.equals(actual));
    }

    @Test
    public void removeByString() {
        expected.remove(1);
        actual.remove(1);
        Assertions.assertTrue(expected.equals(actual));
    }

    @Test
    public void contains() {
        Assertions.assertEquals(expected.contains(1), 0);
    }

    @Test
    public void indexOf() {
        Assertions.assertEquals(expected.indexOf(1), 1);
    }

    @Test
    public void lastIndexOf() {
        Assertions.assertEquals(expected.indexOf(1), 1);
    }

    @Test
    public void get() {
        Assertions.assertEquals(expected.get(0), 3);
    }

    @Test
    public void equals() {
        Assertions.assertTrue(expected.equals(actual));
    }

    @Test
    public void size() {
        Assertions.assertEquals(expected.size(), actual.size());
    }

    @Test
    public void isEmpty() {
        Assertions.assertFalse(expected.isEmpty());
    }

    @Test
    public void clear() {
        expected.clear();
        Assertions.assertTrue(expected.isEmpty());
    }

    @Test
    public void toArray() {
        Integer [] integers1 = expected.toArray();
        Integer[] integers2 = new Integer[4];
        integers2[0] = 3;
        integers2[1] = 1;
        integers2[2] = 2;
        integers2[3] = 4;
        Assertions.assertArrayEquals(integers1,integers2);
    }

    @Test
    public void toRandomArray() {
        Integer[] integers = new Integer[]{};
        integers = IntegerListImpl.toRandomArray();
        Assertions.assertTrue(integers.length > 0);
    }

    @Test
    public void shouldThrowArrayIndexOutOfBoundsExceptionWhenUseMethodAdd() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> expected.add(11, 1));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenUseMethodAdd() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> expected.add(3, null));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> expected.add(null));
    }

    @Test
    public void shouldThrowArrayIndexOutOfBoundsExceptionWhenUseMethodSet() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> expected.set(5, 1));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenUseMethodSet() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> expected.set(1, null));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenUseMethodRemove() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> expected.remove(null));
    }
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenUseMethodContains() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> expected.contains(null));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenUseMethodEquals() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> expected.equals(null));
    }

    @Test
    public void quickSort() {
        IntegerListImpl.quickSort(expected.getIntegerList(),0,3);
        IntegerListImpl.quickSort(actual.getIntegerList(),0,3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void grow() {
        expected.grow();
        Assertions.assertEquals(expected.getIntegerList().length, (int)(4 * 1.5));
    }
}
