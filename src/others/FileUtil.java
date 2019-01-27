package others;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileUtil {

    static String inFileName = "E:\\git\\workspace\\cds-m\\src\\main\\resources\\LocalStrings_en.properties";
    static String outFileName = "E:\\koal文档\\LocalStrings_en.properties";

    static Map<String, String> map = new HashMap<>();

    public static String readFileByLine(){
        String s = "";
        File inFile = new File(inFileName);
        File outFile = new File(outFileName);
        BufferedReader br = null;
        BufferedWriter bw = null;

        int index = 1;
        try{
            System.out.println("按照行读取文件内容");
            br = new BufferedReader(new FileReader(inFile));
            bw = new BufferedWriter(new FileWriter(outFile));

            String temp;
            while((temp = br.readLine()) != null){
                String handled = handleStr(temp);
                System.out.println("改造前，第" + index + "行: " + temp);
                System.out.println("改造后，第" + index++ + "行: " + handled);

                if (isKeyExisted(handled)) {
                    continue;
                }
                bw.write(handled);
                bw.newLine();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{

            try {
                br.close();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return s;
    }

    /**
     * 判断该key是否已存在，保留一个即可
     * @param handled
     * @return
     */
    private static boolean isKeyExisted(String handled) {
        String[] handledArr = handled.split("=");
        // 只有key时，默认不存在
        if (handledArr.length <= 1) {
            return false;
        }
        if (map.containsValue(handledArr[1])) {
            System.out.println("该值已存在：  " + handledArr[1] + "。 对应的key为： " + handledArr[0]);
        }
        if (map.containsKey(handledArr[0])) {
            System.out.println("该key值已存在，进行过滤: " + handledArr[0]);
            return true;
        } else {
            map.put(handledArr[0], handledArr[1]);
            return false;
        }
    }

    /**
     * 按‘.’分割  查找每行的第一个符合 【大写字母开头小写字母结尾】 的字符串，即为类名
     * 取出类名之后的的所有信息
     *
     * 同时，按‘.’分割会把正常key中的相应【点】给分割开，需要补齐
     * @param temp
     * @return
     */
    private static String handleStr(String temp) {
        String[] arr = temp.split("[.]");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {

            sb.append(arr[i]);
            sb.append(".");

            if (arr[i].matches("^[A-Z]{1}[a-zA-Z]*[a-z]$")) {
                sb = new StringBuilder();
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString();


    }

    public static void main(String[] args) {
        readFileByLine();
    }

}

