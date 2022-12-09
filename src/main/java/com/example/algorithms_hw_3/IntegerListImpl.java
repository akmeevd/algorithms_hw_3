package com.example.algorithms_hw_3;

import java.util.Arrays;
import java.util.Random;

public class IntegerListImpl implements IntegerList {
    private Integer[] integerList;


    public IntegerListImpl(Integer[] integerList) {
        this.integerList = integerList;
    }

    public IntegerListImpl(int size) {
        this.integerList = new Integer[size];
    }

    public IntegerListImpl() {
        this.integerList = new Integer[10];
    }

    @Override
    public Integer add(Integer item) {
        checkItem(item);
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i] == null) {
                integerList[i] = item;
                return item;
            } else if (integerList[integerList.length - 1] != null) {
                this.integerList = Arrays.copyOf(integerList, (int) (integerList.length * 1.5));
            }
        }return null;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkLength(index);
        checkItem(item);
        for (int i = integerList.length - 1; i >= 0; i--) {
            if (i > index) {
                integerList[i] = integerList[i - 1];
            }
        }integerList[index] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkLength(index);
        checkItem(item);
        integerList[index] = item;
        return null;
    }

    @Override
    public Integer remove(Integer item) {
        checkItem(item);
        for (int i = 0; i < integerList.length; i++) {
            if (!integerList[i].equals(item)) {
                throw new IllegalArgumentException("нет такого значения в массиве");
            } else {
                integerList[i] = null;
                return item;
            }
        }return null;
    }

    @Override
    public Integer remove(int index) {
        checkLength(index);
        return integerList[index] = null;
    }

    @Override
    public int contains(Integer item) {
        checkItem(item);
        return IntegerListImpl.binarySearch(integerList,item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i] != null && integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = integerList.length - 1; i >= 0; i--) {
            if (integerList[i] != null && integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        return integerList[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("некорректно введены данные");
        }
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i] != null || otherList.get(i) != null) {
                if (!integerList[i].equals(otherList.get(i))) {
                    return false;
                }
            }
        }return true;
    }

    @Override
    public int size() {
        int factSize = 0;
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i] != null) {
                factSize++;
            }
        }
        return factSize;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(integerList, null);
    }

    @Override
    public Integer[] toArray() {
        Integer [] integers = Arrays.copyOf(integerList, integerList.length);
        return integers;
    }

    private void checkItem(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("некорректно введены данные");
        }
    }

    private void checkLength(int index) {
        if (index > integerList.length) {
            throw new ArrayIndexOutOfBoundsException("элемент выходит за рамки массива");
        }
    }

    @Override
    public String toString() {
        return "IntegerListImpl{" +
                "integerList=" + Arrays.toString(integerList) +
                '}';
    }

    public static Integer[] toRandomArray() {
        Integer [] integers = new Integer[100000];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = new Random().nextInt(1000);
        }
        return integers;
    }


    ///сортировка выбором
    public static void sortSelection(Integer[] integers) {
        for (int i = 0; i < integers.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < integers.length; j++) {
                if (integers[j] < integers[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(integers, i, minElementIndex);
        }
    }
    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private static int binarySearch(Integer[] integers, Integer item) {
        IntegerListImpl.sortSelection(integers);
        return Arrays.binarySearch(integers, item);
    }

    public void grow() {
        this.integerList = Arrays.copyOf(integerList, (int) (integerList.length * 1.5));
    }


    public static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private static void swapElements(Integer[] arr, Integer left, Integer right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public Integer[] getIntegerList() {
        return integerList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerListImpl that = (IntegerListImpl) o;
        return Arrays.equals(integerList, that.integerList);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(integerList);
    }
}
