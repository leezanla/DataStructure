package work.leezan.stack;

import java.net.Inet4Address;
import java.sql.Statement;
import java.util.Stack;

public class SelfCalculator {
    public static void main(String[] args) {

        String expression = "6+2*6-2";
        char[] charExpression = new char[expression.length()];
        charExpression = expression.toCharArray();

        char ch = ' ';
        char oper = ' ';
        int i = 0;
        int num1, num2, res;
        String keepNum = "";
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operStack = new Stack<>();
        while (true) {
            ch = charExpression[i];
            if (SelfCalculator.isOper(ch)) {
                if (operStack.empty()) {
                    operStack.push(ch);
                } else {
                    if (SelfCalculator.compareOper(ch) <= operStack.peek()) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = SelfCalculator.consequence(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                }
            } else {
                numStack.push(Integer.valueOf(ch));
            }
            if (operStack.empty()) {
                break;
            }
            i++;
        }
        System.out.println("结果为：" + numStack.peek());
    }

    public static boolean isOper(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static int compareOper(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else {
            return 0;
        }
    }

    public static int consequence(int num1, int num2, char ch) {
        if (ch == '+') {
            return num2 + num1;
        } else if (ch == '-') {
            return num2 + num1;
        } else if (ch == '*') {
            return num2 * num1;
        } else if (ch == '/') {
            return num2 / num1;
        } else {
            return 0;
        }
    }
}
