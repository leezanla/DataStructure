package work.leezan.RegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp03 {
    public static void main(String[] args) {
        String content = "mmabcabbcbabc";
        String regStr = "m+(abc)*";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到了：" + matcher.group(0));
        }
    }
}
