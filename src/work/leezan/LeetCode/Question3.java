package work.leezan.LeetCode;

import java.util.PriorityQueue;
import java.util.Queue;

public class Question3 {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>(10);
        queue.add(78);
        queue.add(15);
        queue.add(14);
        queue.add(37);
        System.out.println(queue.peek());
        System.out.println(queue.size());

    }
}