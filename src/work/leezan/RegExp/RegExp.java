package work.leezan.RegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    public static void main(String[] args) {
        String content = "fa激3345发革s载载wgw5工2一a82s械shx";
        //1、先创建一个Pattern对象，模式对象，可以理解成就是一个正则表达式对象

        //Pattern pattern = Pattern.compile("[a-zA-Z]+");   匹配的是字母
        //Pattern pattern = Pattern.compile("[0-9]+");   匹配的是数字
        Pattern pattern = Pattern.compile("([0-9]+)|([a-zA-Z]+)");  //匹配字母与数字
        //2、创建一个匹配器对象
        //理解：就是matcher匹配器按照pattern（模式/样式），到content文本中去匹配
        Matcher matcher = pattern.matcher(content);
        //开始循环匹配
        while (matcher.find()) { //如果找到就返回一个true否则就返回一个false
            //匹配内容，文本，放到m.group(0)
            System.out.println("匹配到的内容是：" + matcher.group(0));
        }
    }
}
