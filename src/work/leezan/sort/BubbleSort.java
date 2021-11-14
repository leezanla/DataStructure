package work.leezan.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[80000];
        for (int i = 0; i < 80000; i++) {
            nums[i] = (int)(Math.random() * 800000);
        }
        long start = System.currentTimeMillis();
        bubbleSort(nums);
        System.out.println("花费的时间为" + (System.currentTimeMillis() - start));
    }
    public static void bubbleSort(int[] nums) {
        int temp;
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = true;
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                }
            }
            if (!flag) { // 在一趟排序中，一次交换都没有发生过
                break;
            } else {
                flag = false; // 重置flag!!!, 进行下次判断
            }
        }
    }
}
