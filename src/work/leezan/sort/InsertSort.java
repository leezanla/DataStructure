package work.leezan.sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[80000];
        for (int i = 0; i < 80000; i++) {
            nums[i] = (int)(Math.random() * 800000);
        }
        long start = System.currentTimeMillis();
        insertSort(nums);
        System.out.println("花费的时间为" + (System.currentTimeMillis() - start));
    }
    public static void insertSort(int[] nums) {
        int temp;
        int insertIndex;
        for (int i = 1; i < nums.length; i++) {
            temp = nums[i];
            insertIndex = i -1;
            while (insertIndex >= 0 && temp < nums[insertIndex]) {
                nums[insertIndex + 1] =nums[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                nums[insertIndex + 1] = temp;
            }
        }
    }
}
