package work.leezan.LinkedList;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","11");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.list();
    }
}
//定义一个SingleLinkedList来管理我们的英雄
class SingleLinkedList {
    //先初始化一个头节点，头节点不要动（不存放具体的数据）
    private HeroNode head = new HeroNode(0,"","");

    //添加节点到单向链表
    /*
    思路：当不考虑编号顺序时
            1、找到当前链表的最后节点
            2、将最后节点的next指向新的节点
    */
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助变量 temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找链表的最后


            if (temp.next == null) { //说明我们找到了链表的最后
                break;
            }
            //如果没有找到最后，就将temp后移
            temp = temp.next;
        }   //当退出while循环时，temp就指向了链表的最后
        temp.next = heroNode;
    }
    //显示链表（遍历）
    public void list() {
        //判断链表是否为空

        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表的最后
            if (temp == null){
                break;
            }
            //输入这个节点的内容
            System.out.println(temp);
            temp = temp.next;
        }

    }
}
class HeroNode {  //定义一个HeroNode对象，每一个HeroNode对象就是一个节点
    public int no;  //排名
    public String name;  //姓名
    public String nickName;  //外号
    public HeroNode next;  //指向下一个节点

    public HeroNode(int no, String name, String nickName) {  //定义一个构造器
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
    //重写一个toString方法

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}