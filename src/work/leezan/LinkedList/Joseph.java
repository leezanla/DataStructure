package work.leezan.LinkedList;

public class Joseph {
    public static void main(String[] args) {
        //测试
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoyd(10);
        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(3, 2, 10);

    }
}

//创建一个环形的单向链表
class CircleSingleLinkedList {
    //创建一个first节点，当前没有编号
    private Boy first = new Boy(-1);

    //添加小孩，构建成一个环形的链表
    public void addBoyd(int nums) { //nums是有多少个小孩
        //对nums做一个校验
        if (nums < 1) {
            System.out.println("nums值不正确");
            return;
        }
        Boy cur = null; //辅助变量，帮助我们来创建环形链表
        //使用一个for来创建我们的环形链表
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if (i == 1) {
                first = boy;
                first.setNext(first); //这个是构建成一个环
                cur = first;
            } else {
                cur.setNext(boy);
                boy.setNext(first);
                cur = boy;
            }
        }
    }

    //遍历当前的环形链表
    public void showBoy() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("没有任何小孩");
            return;
        }
        //因为first不能动，因此我们需要一个辅助指针来完成遍历
        Boy cur = first;
        while (true) {
            System.out.println("小孩的编号为：" + cur.getNo());
            if (cur.getNext() == first) {
                break;
            }
            cur = cur.getNext(); //让当前辅助指针后移

        }
    }

    //根据用户的输入，计算出小孩出圈的顺序

    /**
     * @param startNo  表示从第几个小孩开始数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少个小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        // 先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("数据输入有误");
        }
        //创建一个辅助节点，帮助小孩出圈
        Boy helper = first;
        //创建一个辅助节点，事先应该指向环形链表的最后这个节点
        while (true) {
            if (helper.getNext() == first) { //说明helper指向最后小孩的节点
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让first和helper移到startNo-1次（first指向要第一个要开始数的小孩，helper指向的是要数小孩的前一个小孩）
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让first与helper指针同时移动m-1次，然后出圈
        //这里是一个循环操作，知道圈中只有一个节点就出圈
        while (true) {
            if (helper == first) {
                break;
            }
            //让first与helper指针同时移动countNum-1次
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点就是要出圈的小孩节点
            System.out.println("出圈的小孩数字为：" + first.getNo());
            //将小孩出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("圈中的最后一个小孩为：" + first.getNo());

    }


}


//先创建一个boy类
class Boy {
    private int no; //编号
    private Boy next; //指向下一个节点

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}