package others;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Random;

public class URLUtil {

    public static boolean isURLValid(String url) throws IOException {
        new URL(url).openStream();
        return true;
    }

    public static void main(String[] args) {
//        System.out.println("hello" + "\rddd");
//
//        try {
//            System.out.println(isURLValid("https://10.0.109.129:32788"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        StringBuilder sb = new StringBuilder();
        sb.append("abcdef");
        sb.append('\t');
        sb.append('\n');
        sb.append("edfadf");
        System.out.println(sb);
        int i = 0;
        Random random = new Random();
        while (i++ < 100) {
            System.out.print(random.nextInt(5) + " ");
        }
        String s = "hello";

        System.out.println();
        i = 0;
        int num = 1;
        while (i++ < 30) {
            num = num << 1;
            System.out.println(num);
        }

    }
}
