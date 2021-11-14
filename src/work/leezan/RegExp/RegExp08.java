package work.leezan.RegExp;

public class RegExp08 {
    public static void main(String[] args) {
        //按照- 或者 # 或者 ~ 来分隔
        String content = "aji4-afji#jifa~ojg32";
        String[] split = content.split("-|#|~");
        for(String item : split) {
            System.out.print(item + "  ");
        }
    }
}
