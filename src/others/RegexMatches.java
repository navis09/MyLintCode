package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

    public static final String IP_REGEX = "(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)";
    public static final String PORT_REGEX = "([0-9]|[1-9]\\d{1,3}|[1-5]\\d{4}|6[0-4]\\d{4}|65[0-4]\\d{2}|655[0-2]\\d|6553[0-5])";

    String ipAndPortRegex = IP_REGEX + ":" + PORT_REGEX;
    String multiAddressRegex = ipAndPortRegex + "(;" + ipAndPortRegex + ")*";

    public static void main( String args[] ){

        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(.*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }

        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        list.toArray(new Integer[6]);
        int[] a = new int[5];
        Arrays.sort(a);
        list.hashCode();


        String ipAndPortRegex = IP_REGEX + ":" + PORT_REGEX;
        String multiAddressRegex = ipAndPortRegex + "(;" + ipAndPortRegex + ")*";

        System.out.println("127.0.0.1".matches(multiAddressRegex));
    }


}
