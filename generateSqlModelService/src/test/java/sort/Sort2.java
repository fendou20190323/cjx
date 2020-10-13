package sort;


import org.junit.Test;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: cjx
 * @Date: 2020-09-24 14:19
 * @Description;
 */
public class Sort2 {

    public static void main(String[] args) {
        int[] arr = {8, 3, 9, 6, 4, 2, 7, 10};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    @Test
    public void test() {
        List<String> list = Arrays.asList("A","B","C","D");
        List<Integer> num = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
//        Double collect = num.stream().collect(Collectors.averagingDouble(d -> d));
//        Double collect = num.stream().collect(Collectors.collectingAndThen(Collectors.averagingDouble(d->d),s->s+1));
        String collect = list.stream().collect(Collectors.joining(",", "(", ")"));
        System.out.println(collect);
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
