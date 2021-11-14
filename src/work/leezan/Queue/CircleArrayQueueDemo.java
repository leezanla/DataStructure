package work.leezan.Queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CirCleArray circle = new CirCleArray(10);
        Scanner sc = new Scanner(System.in);
        char key = ' ';
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):查看队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):向队列中添加数据");
            System.out.println("g(get):从队列中取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = sc.next().charAt(0);  //接收一个字符
            switch (key) {
                case 's':
                    try {
                        circle.showQueue();
                    } catch (RuntimeException e) {
                        System.out.println(e);
                        break;
                    }
                    break;
                case 'e':
                    loop = false;
                    break;
                case 'a':
                    try {
                        System.out.println("请输入一个数字");
                        int value = sc.nextInt();
                        circle.addQueue(value);
                    } catch (RuntimeException e) {
                        System.out.println(e);
                        break;
                    }
                case 'h':
                    try {
                        circle.headQueue();
                    } catch (RuntimeException e) {
                        System.out.println(e);
                        break;
                    }
                case 'g':
                    try {
                        circle.getQueue();
                    } catch (RuntimeException e) {
                        System.out.println(e);
                        break;
                    }

                default:
                    break;
            }
        }
    }
}

class CirCleArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CirCleArray(int maxSize) {
        this.maxSize = maxSize;
        front = 0;
        rear = 0;
        arr = new int[maxSize];
    }

    //判断是否为空
    public boolean isEmpty() {
//        System.out.println("empty------>rear:" + rear);
//        System.out.println("empty------>front:" + front);
        return rear == front;
    }

    //判断是否为满
    public boolean isFull() {
//        System.out.println("full------>rear:" + rear);
//        System.out.println("full------>front:" + front);
        return (rear + 1) % maxSize == front;
    }

    //查看队列中的有效数据
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //查看队列中的所有数据
    public void showQueue() {
        System.out.println("rear:" + rear);
        System.out.println("front:" + front);
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("取出数据时队列已空");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void addQueue(int number) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        arr[rear] = number;
        rear = (rear + 1) % maxSize;
        System.out.println("rear:" + rear);
        System.out.println("front:" + front);
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空");
        }
        return arr[front];
    }
}
