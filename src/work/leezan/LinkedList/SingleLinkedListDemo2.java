package work.leezan.LinkedList;

public class SingleLinkedListDemo2 {

    public static void main(String[] args) {


        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "11");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        HeroNode2 hero5 = new HeroNode2(1,"李逵","jjj");
        SingleLinkedList2 singleLinkedList2 = new SingleLinkedList2();
        singleLinkedList2.addSingleLinkedList(hero1);
        singleLinkedList2.addSingleLinkedList(hero2);
        singleLinkedList2.addSingleLinkedList(hero3);
        singleLinkedList2.addSingleLinkedList(hero4);

        System.out.println("删除前的序列");
        singleLinkedList2.showSingleLinkedList();
        System.out.println("删除后的序列");
//        singleLinkedList2.delete(3);
////        singleLinkedList2.update(hero5);
//        singleLinkedList2.showSingleLinkedList();
        singleLinkedList2.delete(1);
        singleLinkedList2.delete(2);
        singleLinkedList2.delete(3);
        singleLinkedList2.delete(4);
        singleLinkedList2.showSingleLinkedList();
    }

}

class SingleLinkedList2 {

    private HeroNode2 head = new HeroNode2(0, "", "");

    public void showSingleLinkedList() {
        HeroNode2 temp = head.next;
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }


    //第二种方法代码实现（在添加英雄时，根据排名[按照从小到大的顺序]将英雄插入到指定位置）
    // (如果有这个排名，则添加失败，并给出提示)
    public void addByOrder(HeroNode2 heroNode2) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针（变量）来帮助我们找到添加的位置
        //因为是单链表，因此我们找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode2 temp = head;
        boolean flag = false; //flag标志添加位置是否存在，默认是false
        while (true) {
            if (temp.next == null) { //说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode2.no) { //位置找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode2.no) { //说明添加的HeroNode已经存在了
                flag = true;
                break;
            }
        }
        if (flag) { //不能添加，说明编号已经存在了
            System.out.println("该英雄的编号" + heroNode2.no + "已经存在了");
        } else { //插入到链表中，就在temp的后面
            heroNode2.next = temp.next;
            temp.next = heroNode2;
        }
    }


    //修改节点的信息，根据no编号来修改，即no编号不能改
    //说明根据newHeroNode中的no来修改即可
    public void update (HeroNode2 heroNode2) {
        if (head.next == null) { //判断是否为空
            System.out.println("链表为空");
            return;
        }
        //根据no编号，找到需要修改的节点，定义一个辅助变量
        HeroNode2 temp = head.next;
        boolean flag = false; //表示是否找到该节点
        while (true) {
            if (temp == null) { //已经遍历完成这个链表了
                break;
            }
            if (temp.no == heroNode2.no) { //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = heroNode2.name;
            temp.nickName = heroNode2.nickName;
        } else { //没有找到这个节点
            System.out.println("没有找到编号为" +heroNode2.no + "的节点");
        }
    }






    public void updateBySelf (HeroNode2 newHeroNode2) {
        HeroNode2 temp = head.next;
        while (true) {
            if (temp.no == newHeroNode2.no) {
                temp.name = newHeroNode2.name;
                temp.nickName = newHeroNode2.nickName;
                break;
            }
        }
    }



    public void addSingleLinkedList(HeroNode2 heroNode2) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = heroNode2;
                break;
            } else if (temp.next.no == heroNode2.no) {
                System.out.println("已经有相同的排名");
                break;
            } else if (temp.next.no > heroNode2.no) {
                heroNode2.next = temp.next;
                temp.next = heroNode2;
                break;
            }
            temp = temp.next;
        }
    }
    //删除节点的思路
    //1、head节点不能动，因此我们需要一个辅助节点找到待删除节点的前一个节点
    //2、说明我们在比较时，是temp.next.no和需要删除的节点的no比较
    public void del (int no) {
        HeroNode2 temp = head;
        boolean flag = false; //标志是否找到待删除的节点
        while (true) {
            if (temp.next == null) { //已经到链表的最后
                break;
            }
            if (temp.next.no == no){ //说明已经找到待删除节点的前一个节点
                flag = true;
                break;
            }
            temp = temp.next;
            if (flag) { //找到了
                temp.next = temp.next.next; //可以删除
            } else {
                System.out.println("删除节点不存在");
            }
        }
    }

    public void delete(int number) {
        HeroNode2 temp = head.next;
        HeroNode2 temp0 = head;
        boolean flag = false;
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        while (true) {
            if (temp.no == number) {
                flag = true;
                break;
            }
            if (temp.next == null) {
                System.out.println("链表中没有你要输入的序号");
                return;
            }
            temp0 = temp;
            temp = temp.next;
        }
        if (flag) {
            temp0.next= temp.next;
        }
    }

    //将单链表反转
    public static void reverseList(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，不需要反转，直接返回
        if(head.next == null || head.next.next == null) {
            return ;
        }
        HeroNode cur = head.next;  //定义一个辅助变量，帮助我们遍历原来的链表
        HeroNode next = null;// 指向当前节点cur的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", ""); //定义一个新的链表
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead链表当中
        while(cur != null) {
            next = cur.next; //先暂时保存一个当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur; //将cur连接到新的链表上面
            cur = next;//主cur后移
        }
        head.next = reverseHead.next;//把head.next指向reverseHead.next，实现链表的反转
    }

}


class HeroNode2 {  //定义一个HeroNode对象，每一个HeroNode对象就是一个节点
    public int no;  //排名
    public String name;  //姓名
    public String nickName;  //外号
    public HeroNode2 next;  //指向下一个节点

    public HeroNode2(int no, String name, String nickName) {  //定义一个构造器
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