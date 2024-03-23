package oy.tol.tra;

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
    }
