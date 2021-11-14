package work.leezan.RegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchesMethod {
    public static void main(String[] args) {
        String content = " hello world";
        String regStr = "hello";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("查找到的初始位置为" + (matcher.start() + 1));
            break;
        }
    }
}
