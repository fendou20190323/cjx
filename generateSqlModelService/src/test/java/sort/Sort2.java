package sort;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: cjx
 * @Date: 2020-09-24 14:19
 * @Description;
 */
@Slf4j
public class Sort2 {

    public static void main(String[] args) {
        int[] arr = {8, 3, 9, 6, 4, 1, 2, 7, 10, 5};
        log.debug(Arrays.toString(arr));
//        System.out.println(Arrays.toString(mergeSort(arr)));
//        System.out.println(Arrays.toString(selectSort(arr)));
        log.debug(Arrays.toString(test1(arr)));
//        quickSort(arr, 0, arr.length - 1);
//        QuickSort quickSort = new QuickSort();
//        quickSort.quickSort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));

    }


    public static int[] test1(int[] arr) {
        int len = arr.length;
        if (len <= 1) return arr;
//       冒泡
//        for (int i = 0; i < len; i++) {
//            for (int j = i; j < len; j++) {
//                if (arr[i]>arr[j]){
//                    int tem=arr[i];
//                    arr[i]=arr[j];
//                    arr[j]=tem;
//                }
//            }
//        }
//      选择
//        for (int i = 0; i < len; i++) {
//            int current = arr[i];
//            int minIndex = i;
//            for (int j = i; j < len; j++) {
//                if (arr[minIndex] > arr[j]) {
//                    minIndex=j;
//                }
//            }
//            arr[i]=arr[minIndex];
//            arr[minIndex]=current;
//        }
//        插入
//        for (int i = 1; i < len; i++) {
//            int current=arr[i];
//            int preIndex=i-1;
//            while (preIndex>=0&&current<arr[preIndex]){
//                arr[preIndex+1]=arr[preIndex];
//                preIndex--;
//            }
//            arr[preIndex+1]=current;
//        }
        int midIndex=len/2;
        int [] left=Arrays.copyOfRange(arr,0, midIndex);
        int [] right=Arrays.copyOfRange(arr, midIndex,len);
         return mergeTest(test1(left),test1(right));

    }

    private static int[] mergeTest(int[] left, int[] right) {
        int[] arr=new int[left.length+right.length];
        int lIndex=0;
        int rIndex=0;
        for (int i = 0; i < arr.length; i++) {
            if (lIndex>=left.length){
                arr[i]=right[rIndex++];
            }else if (rIndex>= right.length){
                arr[i]=left[lIndex++];
            }else if (left[lIndex]>right[rIndex]){
                arr[i]=right[rIndex++];
            }else {
                arr[i]=left[lIndex++];
            }
        }

        return arr;
    }

    public static int[] merge2(int[] left, int[] right) {
        int arr[] = new int[left.length + right.length];
        int li = 0;
        int ri = 0;
        for (int i = 0; i < arr.length; i++) {
            if (li >= left.length) {
                arr[i] = right[ri++];
            } else if (ri >= right.length) {
                arr[i] = left[li++];
            } else if (left[li] < right[ri]) {
                arr[i] = left[li++];
            } else {
                arr[i] = right[ri++];
            }
        }
        return arr;
    }


    public static void quickSort(int[] arr, int begin, int end) {
        if (arr.length <= 1 || begin >= end) {
            return;
        }
        int pivotIndex = partition(arr, begin, end);
        quickSort(arr, begin, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, end);
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int pivotIndex = begin;
        for (int i = begin; i < end; i++) {
            if (arr[i] < pivot) {
                if (i > pivotIndex) {
                    swap(arr, i, pivotIndex);
                }
                pivotIndex++;
            }
        }
        swap(arr, pivotIndex, end);
        return pivotIndex;
    }

    private static void swap(int[] arr, int i, int j) {
//        int temp=arr[i];
//        arr[i]=arr[j];
//        arr[j]=temp;
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


    public static int[] selectSort(int[] arr) {
        int len = arr.length;
        if (len <= 1) return arr;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int current = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = current;
        }
        return arr;
    }

    public static int[] insertSort(int[] arr) {
        int len = arr.length;
        if (len <= 1) return arr;
        for (int i = 1; i < arr.length; i++) {
            int preIndex = i - 1;
            int current = arr[i];
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }

    public static int[] bubbleSort(int[] arr) {
        if (arr.length < 2) return arr;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] mergeSort(int[] arr) {
        int length = arr.length;
        if (length < 2) return arr;
        int mid = length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, length);

        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] arr = new int[left.length + right.length];
        int lIndex = 0;
        int rIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (lIndex >= left.length) {
                arr[i] = right[rIndex++];
            } else if (rIndex >= right.length) {
                arr[i] = left[lIndex++];
            } else if (left[lIndex] > right[rIndex]) {
                arr[i] = right[rIndex++];
            } else {
                arr[i] = left[lIndex++];
            }

        }
        return arr;
    }
}
