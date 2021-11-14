package work.leezan.RegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp04 {
    public static void main(String[] args) {
        String content = "world韩顺平教育 hello韩顺平老师 hel韩顺平同学";
        //找到content中有韩顺平教育的韩顺平，韩顺平老师的韩顺平，不包括韩顺平同学的韩顺平
        String regStr = "韩顺平(?=教育|老师)";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到了：" + matcher.group(0));
            //System.out.println("分组为：" + matcher.group(1));
        }
    }
}
