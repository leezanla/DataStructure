package work.leezan.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
//        int[] array = {4, 5, 7, 8, 1, 2, 3, 6};
//        int[] temp = new int[array.length];
//        mergeSort(array,0,array.length - 1,temp);
//        System.out.println(Arrays.toString(array));
        int[] nums = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            nums[i] = (int) (Math.random() * 800000);
        }
        long start = System.currentTimeMillis();
        int[] temp = new int[nums.length];
        mergeSort(nums,0,nums.length - 1,temp);
        System.out.println("花费的时间为" + (System.currentTimeMillis() - start));
////        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] array, int start, int end, int temp[]) {
        int middle = (start + end) / 2;
        if (start < end) {
            mergeSort(array, start, middle,temp);
            mergeSort(array, middle + 1, end, temp);
            merge(array, start, middle, end, temp);
        }

    }

    private static void merge(int[] array, int start, int middle, int end,int[] temp ) {
        int i = start;
        int j = middle + 1;
        int index = 0;
        while (i <= middle && j <= end) {
            if (array[i] < array[j]) {
                temp[index] = array[i];
                i++;
            } else {
                temp[index] = array[j];
                j++;
            }
            index++;
        }
        while (i <= middle) {
            temp[index] = array[i];
            i++;
            index++;
        }
        while (j <= end) {
            temp[index] = array[j];
            j++;
            index++;
        }

        int t = 0;
        int tempLeft = start; //
        //第一次合并 tempLeft = 0 , right = 1 //  tempLeft = 2  right = 3 // tL=0 ri=3
        //最后一次 tempLeft = 0  right = 7
        while(tempLeft <= end) {
            array[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
