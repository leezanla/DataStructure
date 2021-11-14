package work.leezan.search;

public class SquSearch {
    public static void main(String[] args) {
        int[] array = {1,2,34,5,66,24,7};
        int index = squSearch(array,7);
        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("找到的下标为：" + index);
        }
    }
    public static int  squSearch(int[] array,int value) {
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                return i + 1;
            }
        }
        return -1;
    }
}
