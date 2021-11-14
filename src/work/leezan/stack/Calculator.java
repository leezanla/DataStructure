package work.leezan.stack;

public class Calculator {
    public static void main(String[] args) {
        //定义一个表达式
        String expression = "700+2*6-2";
        //创建两个栈，一个数栈，一个符号栈
        CalculatorStack numStack = new CalculatorStack(20);
        CalculatorStack operStack = new CalculatorStack(20);
        //定义需要的相关变量
        int index = 0; //用于扫描我们定义的表达式
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        int oper = 0;
        char ch = ' '; //每次扫描得到的char保存到ch中
        String keepNum = "";
        //开始while扫描expression表达式
        while (true) {
            //依次得到expression中的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么，然后做相应的处理
            if (operStack.isOper(ch)) { // 如果是一个运算符
                //判断当前的符号栈是否为空
                if (!operStack.isEmpty()) {
                    //这个是栈中有运算符，就进行比较，如果当前的操作符的优先级小于或者等于栈中的操作符
                    //就需要从数栈中pop出两个数，从符号栈中pop出一个符号，进行运算，将得到的结果入栈
                    //然后将当前的操作符入符号
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);  //把当前结果入数栈
                        operStack.push(ch);  //把当前运算符入符号栈
                    } else {
                        //如果当前操作符优先级大于栈中的操作符，就直接入栈
                        operStack.push(ch);
                    }
                } else { // 如果为空直接入符号栈
                    operStack.push(ch);
                }
            } else { //如果是数字，则直接入栈
                //numStack.push(ch - 48); //因为我们ch扫描之后的是字符，根据ASCII表可以看出，相差48个数字
                //1、当处理的是多位数时，不能发现是一们数我们就入栈，因为它可能是多位数
                //2、在处理数时，需要向expression表达式中的index的后再看一位（看看否是符号或数字）
                //如果是数字就继续进行扫描，如果是符号才入栈
                //3、因此我们需要定义一个字符串变量，用于拼接
                //处理多位数
                keepNum += ch;
                //如果ch已经是expression的最后一位，就直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {


                    //判断下一个字符是不是数字，如果是数字，就继续进行扫描，如果是运行符，则入栈
                    //注意只是看index的后一位，不是index++
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        //重要的!!!!!!, keepNum清空
                        keepNum = "";
                    }
                }
            }
            //让index+1，并且要判断是否到达了expression的最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        //当表达式扫描完毕之后，就顺序从数栈和符号栈中pop出相应的数和符号并运算
        while (true) {
            //如果符号栈为空，则计算到了最后的结果，数栈中只有一个数字了，这个就是我们所要的结果
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);  //把当前结果入数栈
        }
        System.out.println("结果为：" + numStack.pop());
    }
}

class CalculatorStack {
    private int maxSize; //栈的大小
    private int[] stack; //数组，数组模拟栈，数据就放在数组中
    private int top = -1; //top表示栈底，初始化为-1

    //构建一个构造器
    public CalculatorStack(int maxSize) {
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
        for (int i = top; i >= 0; i--) {
            System.out.println("stack[" + (i + 1) + "]=" + stack[i]);
        }
    }

    //返回运算符的优先级，优先级是程序员自己来确定的，优先级用数字来表示
    //数字越大，则优先级就越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //返回一个栈顶的值，不是出栈，只是看一眼
    public int peek() {
        return stack[top];
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1; //注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
