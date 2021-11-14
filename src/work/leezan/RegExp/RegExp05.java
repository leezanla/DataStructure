package work.leezan.RegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp05 {
    public static void main(String[] args) {
        //判断字符串的是否全部是汉字
        String content = "我们要输入的内容";
        String regStr = "^[\\u4e00-\\u9fa5]+$";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            System.out.println("符合要求");
        } else {
            System.out.println("不符合要求");
        }
    }
}
