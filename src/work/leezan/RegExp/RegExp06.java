package work.leezan.RegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp06 {
    public static void main(String[] args) {
        //验证邮政编码
        //要求：是1-9 开头的一个六位数
        String content = "400300";
        String regStr = "^[1-9]\\d{5}$";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            System.out.println("符合要求");
        } else {
            System.out.println("不符合要求");
        }
    }
}
