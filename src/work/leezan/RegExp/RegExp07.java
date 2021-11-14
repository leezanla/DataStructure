package work.leezan.RegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp07 {
    public static void main(String[] args) {

        String content = "我...我要...要要...学学学学...编程Java";
        String regStr = "\\.";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        //1、先去除所有的.
        content = matcher.replaceAll("");
        System.out.println(content);
        //2、去除所有的重复字
        //思路
        //(1)、使用(.)\\1+
        //(2)、使用反向引用$1来替换匹配到的内容
        //注意：因为正则表达式发生了变化，因此需要重置matcher
//        pattern = Pattern.compile("(.)\\1+");
//        matcher = pattern.matcher(content);
//        content = matcher.replaceAll("$1");
//        System.out.println(content);
        //将以上合成一句话
        content =  Pattern.compile("(.)\\1+").matcher(content).replaceAll("$1");
        System.out.println(content);
    }
}
