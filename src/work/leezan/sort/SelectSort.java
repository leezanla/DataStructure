package work.leezan.sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = new int[80000];
        for (int i = 0; i < 80000; i++) {
            nums[i] = (int)(Math.random() * 800000);
        }
        long start = System.currentTimeMillis();
        selectSort(nums);
        System.out.println("花费的时间为" + (System.currentTimeMillis() - start));
    }
    public static void selectSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
