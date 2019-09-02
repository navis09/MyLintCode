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

        byte[] a = new byte[]{1,2,2};
        System.out.println(a + "");
        String x = a + "";
        String y = a + "";
        System.out.println(x + y);
        String z = new String(a);
        String k = new String(a);

        System.out.println(x == y);
        System.out.println(z == k);


        int[] intArr = new int[1000000];
        String[] strArr1 = new String[1000000];//为了公平分别定义三个数组

        String[] strArr2 = new String[1000000];
        String[] strArr3 = new String[1000000];
        //赋值
        Long t1 = System.currentTimeMillis();
        for(int i=0;i<1000000;i++){
            intArr[i]=i+1;
        }
        Long t2 = System.currentTimeMillis();
        for(int i=0;i<1000000;i++){
            strArr1[i] = String.valueOf(intArr[i]);
        }
        Long t3 = System.currentTimeMillis();
        for(int i=0;i<1000000;i++){
            strArr2[i] = Integer.toString(intArr[i]);
        }
        Long t4 = System.currentTimeMillis();
        for(int i=0;i<1000000;i++){
            strArr3[i] = intArr[i]+"";
        }
        Long t5 = System.currentTimeMillis();
        System.out.println("t1 = "+t1);
        System.out.println("t2 = "+t2);
        System.out.println("t3 = "+t3);
        System.out.println("t4 = "+t4);
        System.out.println("t5 = "+t5);
        System.out.println("赋值："+(t2-t1));
        System.out.println("String.valueOf(i)："+(t3-t2));
        System.out.println("Integer.toString(i)："+(t4-t3));
        System.out.println("i+\"\"："+(t5-t4));

        System.out.println(Math.round(1.5));
        System.out.println(Math.round(-0.5));
        System.out.println(Math.round(-0.6));
        System.out.println(Math.round(-0.4));
        System.out.println(Math.round(-1));
    }

}
