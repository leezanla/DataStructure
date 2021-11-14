package work.leezan.RegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTheory {
    public static void main(String[] args) {

        String content = "1998年12月8日，第二代Java平台的企业版J2EE发布。1999年6月，Sun公司发布了第二代Java平台（简称为Java2）" +
                "的3个版本：J2ME（Java2 Micro Edition，Java2平台的微型版），应用于移动、无线及有限资源的环境；J2SE（Java 2 " +
                "Standard Edition，Java 2平台的标准版），应用于桌面环境；J2EE（Java 2Enterprise Edition，Java 2平台的" +
                "企业版），应用于基于Java的应用服3443务器。Java 2平台的发9889布，是Java发展过程中最重要的一个里程碑，标志着Java的应" +
                "用开始普及。";
        //目标：匹配所有的四个数字
        //说明：
        //1、\\d表示任意的一个数字（0-9）
        String regStr = "(\\d\\d)(\\d\\d)";
        //2、创建模式对象[即正则表达式对象]
        Pattern pattern = Pattern.compile(regStr);
        //3、创建匹配器
        //说明：创建匹配器matcher，按照正则表达式的规则去匹配content字符串
        Matcher matcher = pattern.matcher(content);

        //4、开始匹配
        /**
         * matcher.find()完成的任务
         * 1、根据指定的规则，定位满足规则的子字符串（比如1998）
         * 2、找到后，将子字符串的开始索引记录到matcher对象的属性中  int[] groups 中;
         *      groups[0] = 0;把该子字符串的结束的索引+1的值记录到groups[1] = 4;
         * 3、同时记录oldLast的值为子字符串的结束的索引+1的值即4，即下次执行find时，就从4开始匹配
         *
         * matcher.group(0)
         * 源代码
         *       public String group(int group) {
         *         if (first < 0)
         *             throw new IllegalStateException("No match found");
         *         if (group < 0 || group > groupCount())
         *             throw new IndexOutOfBoundsException("No group " + group);
         *         if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
         *             return null;
         *         return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
         *     }
         * 1、根据groups[0]=0和groups[1]=4的记录位置，从content开始截取子字符串返回就是[0,4),包含0但是不包含4
         *
         */
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
            System.out.println("第一组匹配到的值为：" + matcher.group(1));
            System.out.println("第二组匹配到的值为：" + matcher.group(2));
        }

    }
}
