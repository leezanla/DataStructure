package work.leezan.sort;


public class ShellSort {
    public static void main(String[] args) {
        int[] nums = new int[80000];
        for (int i = 0; i < 80000; i++) {
            nums[i] = (int) (Math.random() * 800000);
        }
        long start = System.currentTimeMillis();
        shellSort(nums);
        System.out.println("花费的时间为" + (System.currentTimeMillis() - start));
    }

    //    public static void shellSort(int[] array) {
//        int temp;
//        for (int gap = array.length / 2; gap > 0; gap = gap / 2) {
//            for (int i = gap; i < array.length; i++) {
//                for (int j = i - gap; j >= 0; j -= gap) {
//                    if (array[j] > array[j + gap]) {
//                        temp = array[j];
//                        array[j] = array[j + gap];
//                        array[j + gap] = temp;
//                    }
//                }
//            }
//        }
//    }
    public static void shellSort(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                int temp = array[j];
                if (array[j] < array[j - gap]) {
                    while (j - gap >= 0 && temp < array[j - gap]) {
                        //移动
                        array[j] = array[j-gap];
                        j -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    array[j] = temp;
                }
            }
        }
    }
}
