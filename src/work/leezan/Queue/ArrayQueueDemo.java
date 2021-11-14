package work.leezan.Queue;

import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        //测试
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop) {
            System.out.println("s(show):查看队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):向队列中添加数据");
            System.out.println("g(get):从队列中取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);  //接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    queue.addQuery(value);
                    break;
                case 'e':
                    loop = false;
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的结果为：%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 'h':
                    try{
                        int i = queue.headQueue();
                        System.out.println("队列的头部为：" + i);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                default:
                    break;
            }

        }

    }

}
//使用数组模拟队列----编写一个ArrayQueue类
class ArrayQueue {
    private int maxSize;  //队列的最大容量
    private int front;  //队列的头部
    private int rear;   //队列的尾部
    private int[] arr;  //该数组用于存放数据，模拟队列
    //创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        front = -1;  //指向队列的头部（分析出front是指向队列头部的前一个位置）
        rear = -1;   //指向队列的尾部（rear是指向队列的尾部的具体位置，即就是队列的最后一个位置）
        arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }
    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }
    //添加数据到队列
    public void addQuery(int n) {
        if (isFull()){
            System.out.println("队列已满了");
            return;
        }
        rear++; //让rear后移一位
        arr[rear] = n;
    }
    //获取队列的数据，出队列
    public int getQueue() {
        if (isEmpty()) {
            //通过抛异常来处理
            throw new RuntimeException("队列已空，不能取数据");
        }
        front++; //front后移一位
        return arr[front];
    }
    //显示队列的所有数据
    public void showQueue() {
        //遍历
        if (isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    //显示队列的头数据，注意不是取出数据
    public int headQueue() {
        if (isEmpty()){
            throw new RuntimeException("队列为空,没有数据");
        }
        return arr[front + 1];
    }
}
