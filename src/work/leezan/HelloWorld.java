package work.leezan;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        List ints1 = new ArrayList<Integer>();
        int[] ints = {1,5,6,8,1,2,7,5,1,5,6,8};
        for (int i = 0; i < ints.length; i++) {
            if(ints1.indexOf(ints[i]) == -1) {
                ints1.add(ints[i]);
            }
        }
        Iterator it = ints1.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }

    }

}