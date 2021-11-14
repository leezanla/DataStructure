package work.leezan;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TestJava {
    public static void main(String[] args) {
        int a[] = {2, 4, 3, 1, 8, 9, 7, 6, 5};
        int length = a.length;
        System.out.println("Before ordering:");
        for (int i = 0; i < length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
        System.out.println("After ordering");

        //
        // TODO: 在此添加代码
        //
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
