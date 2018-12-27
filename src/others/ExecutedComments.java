package others;


/**
 * The reason for this is that the Java compiler parses the unicode character \u000d as a new line and gets transformed into:
 */
public class ExecutedComments {

    public static void main(String... args) {
        // The comment below will be executed.
        // \u000d System.out.println("This Comment Executed!");

        String s = "a_b_ccc";
        String[] arr = s.split("_");
        for (String str : arr) {
            System.out.println(str);
        }
    }

}
