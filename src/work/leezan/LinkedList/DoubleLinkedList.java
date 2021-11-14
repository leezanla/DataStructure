package work.leezan.LinkedList;

public class DoubleLinkedList {
    public static void main(String[] args) {
        StuInfoTest stuInfoTest = new StuInfoTest();
        StuInfo stuInfo1 = new StuInfo("zhangsan", 18, "male");
        StuInfo stuInfo2 = new StuInfo("lisi", 18, "male");
        StuInfo stuInfo3 = new StuInfo("wangwu", 18, "male");
        stuInfoTest.add(stuInfo1);
        stuInfoTest.add(stuInfo2);
        stuInfoTest.add(stuInfo3);
        System.out.println("修改前的顺序");
        stuInfoTest.showStuInfo();
        System.out.println("修改后的顺序");
        stuInfoTest.showStuInfo();
    }
}

class StuInfoTest {
    //添加信息在链表的尾部
    StuInfo head = new StuInfo("", 0, "");

    public void add(StuInfo stuInfo) {
        StuInfo temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = stuInfo;
        stuInfo.pre = temp;
    }

    public void showStuInfo() {
        StuInfo temp = head.next;
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

}


class StuInfo {
    String name;
    int age;
    String gender;
    StuInfo next;
    StuInfo pre;

    public StuInfo(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "StuInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
