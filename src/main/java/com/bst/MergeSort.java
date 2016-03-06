package com.bst;

import java.util.Arrays;

/**
 * Created by rekhamittal on 3/5/16.
 */
public class MergeSort {
    public static Integer[] array = {48,24, 8, 56, 77, 23, 12, 34, 98, 10};

    public static void mergeSort(Integer[] arr) {
        Integer[] b = new Integer[arr.length];
        mergeSort(arr, b, 0, arr.length-1);
    }

    public static void mergeSort(Integer[] arr, Integer[] rarr, int start, int end) {
        System.out.println("sorting from " + start +  " to end " + end);
        if ((end > start) && (end - start == 1)) {
            int temp = arr[start];
            if (arr[end] < arr[start]) {
                System.out.println("fixing the arr " +start +" end " +end);
                System.out.println("swapping the arr " +arr[start] +" end " +arr[end]);

                arr[start] = arr[end];
                arr[end] = temp;
            }
            return;
        }
        int mid = (start + end) / 2;
        if (start<end) {
            mergeSort(arr, rarr, start, mid);
            System.out.println("before mid, Finished sorting from  " + start + " to " + mid);
            mergeSort(arr, rarr, mid + 1, end);
            int x = mid + 1;
            System.out.println("after mid, Finished sorting from  " + x + " to " + end);
            System.out.println("Merging the arrays start " + start + " to " + end + " mid " +mid);
            merge(arr, rarr, start, mid+1, end);
        }
    }

    static int IKatoi(String strInput) {
        String input =  strInput.trim();
        char[] ch = input.toCharArray();
        String tmp = "";
        for (int i=0; i<ch.length; i++) {
            if (i==0 && Character.isDigit(ch[i]) || ch[i] == '+' || ch[i] == '-') {
                tmp += tmp;
            }
        }
        Long x = 123244534534L;
        Integer y = x.intValue();
        return 0;
    }

    public static boolean isPalindrome(String input) {
        String pattern1 = "^[a-zA-z0-9]*$";
        if (!input.matches(pattern1)) {
            return false;
        }
        input.replace("\\s","");
        char[] charArr = input.toCharArray();
        return isPalindrome(charArr, 0, charArr.length-1);
    }

    public static boolean isPalindrome(char[] charArr, int start, int end) {
        while (start <= end) {
            if (charArr[start] != charArr[end]) {
                return false;
            }
            isPalindrome(charArr, start+1, end-1);
        }
        return true;
    }

    public static int findDuplicate(Integer[] arr) {
        int num = 1;
        boolean firstTime = true;
        while (num<=arr.length) {
            if (arr[num-1] != num) {
                int nextNum = arr[num-1];
                num = arr[nextNum-1];
                arr[nextNum-1] = nextNum;
                firstTime = false;
            } else {
                if (!firstTime) {
                    return num;
                }
                num++;
                firstTime = true;
            }

        }
        return 0;
    }

    public static void merge(Integer[] arr, Integer[] barr, int ls, int rs, int end) {
        int leftStart = ls;
        int leftEnd = rs-1;
        int j = ls;
        while (ls <= leftEnd && rs<=end) {
            if(arr[ls] < arr[rs]) {
                barr[j++] = arr[ls++];
            } else {
                barr[j++] = arr[rs++];
            }
        }

        while(ls>leftEnd && rs <= end) {
            barr[j++] = arr[rs++];
        }
        while(rs>end && ls<=leftEnd) {
            barr[j++] = arr[ls++];
        }
        for (int i=leftStart; i<=end; i++) {
            arr[i] = barr[i];
        }
    }

    public static void main(String[] args) {
//        mergeSort(array);
//        System.out.println("Sorted array is" + Arrays.toString(array));
        Integer[] arr = {4,2,1,3,4,5};
        int dup = findDuplicate(arr);
        System.out.println("Duplicate number found is " +dup);
    }
}
