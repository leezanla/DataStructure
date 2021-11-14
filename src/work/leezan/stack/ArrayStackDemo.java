package work.leezan.stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        CalculatorStack calculatorStack = new CalculatorStack(10);
        calculatorStack.push(78);
        calculatorStack.push(13);
        calculatorStack.push(25);
        calculatorStack.push(72);
        calculatorStack.push(68);
        calculatorStack.list();
        System.out.println(calculatorStack.pop());
        calculatorStack.list();
    }
}
//定义一个ArrayStack表示栈
class ArrayStack {
    private int maxSize; //栈的大小
    private int[] stack; //数组，数组模拟栈，数据就放在数组中
    private int top = -1; //top表示栈底，初始化为-1

    //构建一个构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }
    //栈满
    public boolean isFull() {
        return top == maxSize - 1; // -1 是因为数组的下标是从0开始的
    }
    //栈空
    public boolean isEmpty() {
        return top == -1;
    }
    //入栈
    public void push(int value) {
        //先判断栈是否已满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }
    //出栈
    public int pop() {
        if (isFull()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }
    //遍历栈  注意：遍历时，需要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.println("stack[" + (i + 1) + "]=" + stack[i]);
        }
    }
}
