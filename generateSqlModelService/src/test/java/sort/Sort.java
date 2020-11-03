package sort;

import java.util.Arrays;

/**
 * @Author: cjx
 * @Date: 2020-09-07 16:13
 * @Description;
 */
public class Sort {

    public static void main(String[] args) {

        int[] arr = {8, 3, 9, 6, 4, 2, 7,10};
        System.err.println("排序前：" + Arrays.toString(arr));
        System.err.println("排序后：" + Arrays.toString(bubbleSort(arr)));
    }


    public static int[] bubbleSort(int [] arr){
        if (arr.length<2) return arr;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i  - 1; j++) {
                if (arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
                System.err.println("第"+i+"次结果："+Arrays.toString(arr));
            }
        }

        return arr;
    }

    /**
     * @param arr
     * @return
     * 归并排序
     */
    public static int[] mergeSort(int[] arr) {
        if (arr.length < 2) return arr;
        int midIndex = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, midIndex);
        int[] right = Arrays.copyOfRange(arr, midIndex, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] newArr = new int[left.length + right.length];
        int lindex = 0;
        int rindex = 0;

        for (int i = 0; i < newArr.length; i++) {
            if (lindex >= left.length) {
                newArr[i] = right[rindex++];
            } else if (rindex >= right.length) {
                newArr[i] = left[lindex++];
            } else if (left[lindex] < right[rindex]) {
                newArr[i] = left[lindex++];
            } else  {
                newArr[i] = right[rindex++];
            }
        }

        return newArr;
    }



}
