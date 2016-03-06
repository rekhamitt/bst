package com.bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rekhamittal on 3/1/16.
 */
public class QuickSort {
//    public static Integer[] input = {1,6,7,4,5,8,9,3};
    public static Integer[] input = {1,2,4,4,5,8,9,3};

    public static Integer[] sortIntegerArray(Integer[] inputArray, int low, int high) {
        //partition create a pivot
        //recursilvey sort left and right side
        if (low < high) {
            Integer index = partitionArray(inputArray, low, high);
            System.out.println("Partition index returned " + index);
            System.out.println("Partition array " + Arrays.asList(inputArray).toString());
            sortIntegerArray(inputArray, low, index-1);
            System.out.println("Finished sorting lower bound array");
            sortIntegerArray(inputArray, index + 1, high);
        }
        return inputArray;
    }

    public static int partitionArray(Integer[] arrA, int lo, int hi) {
        int pivot = arrA[hi];
        int pivIdx = hi;
        int j = hi - 1;
        for (int i = lo; i < j; i++) {
            while(arrA[j] > pivot) {
                swap(arrA, j, pivIdx);
                pivIdx = j;
                j--;
            }
            if (arrA[i] > arrA[j]) {
                swap(arrA, j, i);
            }

        }
        return (j+1);
    }

    private static void swap(Integer[] arr, Integer aIdx, Integer bIdx) {
        arr[bIdx] = arr[aIdx] + arr[bIdx];
        arr[aIdx] = arr[bIdx] - arr[aIdx];
        arr[bIdx] = arr[bIdx] - arr[aIdx];
    }

    public static void main(String[] args) {
        int hi = input.length - 1;
        Integer[] result = sortIntegerArray(input, 0 , hi);
        System.out.println("Sorted array " + Arrays.asList(result).toString());
    }
}

/**
 * Created by rekhamittal on 3/1/16.
 */
public class QuickSort {
//    public static Integer[] input = {1,6,7,4,5,8,9,3};
    public static Integer[] input = {1,2,4,4,5,8,9,3};

    public static Integer[] sortIntegerArray(Integer[] inputArray, int low, int high) {
        //partition create a pivot
        //recursilvey sort left and right side
        if (low < high) {
            Integer index = partitionArray(inputArray, low, high);
            System.out.println("Partition index returned " + index);
            System.out.println("Partition array " + Arrays.asList(inputArray).toString());
            sortIntegerArray(inputArray, low, index-1);
            System.out.println("Finished sorting lower bound array");
            sortIntegerArray(inputArray, index + 1, high);
        }
        return inputArray;
    }

    public static int partitionArray(Integer[] arrA, int lo, int hi) {
        int pivot = arrA[hi];
        int pivIdx = hi;
        int j = hi - 1;
        for (int i = lo; i < j; i++) {
            while(arrA[j] > pivot) {
                swap(arrA, j, pivIdx);
                pivIdx = j;
                j--;
            }
            if (arrA[i] > arrA[j]) {
                swap(arrA, j, i);
            }

        }
        return (j+1);
    }

    private static void swap(Integer[] arr, Integer aIdx, Integer bIdx) {
        arr[bIdx] = arr[aIdx] + arr[bIdx];
        arr[aIdx] = arr[bIdx] - arr[aIdx];
        arr[bIdx] = arr[bIdx] - arr[aIdx];
    }

    public static void main(String[] args) {
        int hi = input.length - 1;
        Integer[] result = sortIntegerArray(input, 0 , hi);
        System.out.println("Sorted array " + Arrays.asList(result).toString());
    }
}
