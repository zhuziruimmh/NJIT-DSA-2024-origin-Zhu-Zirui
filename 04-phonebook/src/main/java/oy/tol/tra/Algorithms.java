package oy.tol.tra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class Algorithms {

    public static <T extends Comparable<T>> void sort(T [] array) {
        int n = array.length-1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                if (array[i].compareTo(array[j])>0) {
                    T tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static <T> void reverse(T [] array) {
        int i = 0;
        while (i < array.length/2) {
            T temp = array[i];
            array[i] = array[array.length-i-1];
            array[array.length-i-1] = temp;
            i++;
        }
    }


    public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {
        while (fromIndex <= toIndex) {
            int mid = fromIndex + (toIndex - fromIndex) / 2;
            int cmp = aValue.compareTo(fromArray[mid]);

            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                toIndex = mid - 1;
            } else {
                fromIndex = mid + 1;
            }
        }
        return -1;
    }

    public static <E extends Comparable<E>> void fastSort(E[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static <E extends Comparable<E>> void quickSort(E[] array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);
            quickSort(array, begin, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, end);
        }
    }

    private static <E extends Comparable<E>> int partition(E[] array, int begin, int end) {
        E pivot = array[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                E temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        E temp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = temp;

        return i + 1;
    }

    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T> int partitionByRule(T[] pairs, int count, Predicate judgeNullPredicate) {
        int left = 0;
        int right = count - 1;
        while (left <= right) {
            if (pairs[left] == null) {
                swap(pairs, left, right);
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    public static <T> void sortWithComparator(T[] array, Comparator<? super T> comparator) {
        Arrays.sort(array, comparator);
    }
}