package work.leezan.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {14, 62, 74, 75, 89, 90, 102};
        int index = binarySearch(array,0,array.length - 1, 102);
        if (index == -1) {
            System.out.println("数组中没有");
        } else {
            System.out.println("查找的下标为" + index);
        }
    }

    public static int binarySearch(int[] array, int left, int right, int value) {
        int middle = (left + right) / 2;
        while (left <= right) {
            if (value > array[middle]) {
                left = middle + 1;
                binarySearch(array, left, right, value);
            } else if (value < array[middle]) {
                right = middle - 1;
                binarySearch(array, left, right, value);
            } else {
                return middle + 1;
            }
        }
        return -1;
    }
}
