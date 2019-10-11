package others;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * MantisFileHandle TODO 自动生成的注释，需修改
 *
 * @author jinxin
 */
public class MantisFileHandle {

  static String inFileName = "E:\\CDS2.3.0-系统测试\\第二轮系统测试\\mantis-bugs.txt";
  static String outFileName = "E:\\CDS2.3.0-系统测试\\第二轮系统测试\\mantis-bugs-handled.txt";

  public static void main(String[] args) {
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
  }

  private static String handleStr(String temp) {
    String trim = temp.trim();

    StringBuilder sb = new StringBuilder();
    int len = trim.length();

    // - [ ] [46916](http://10.0.1.8/mantis2/view.php?id=46916)
    String index = trim.substring(0, 5);
    sb.append("- [ ] [");
    sb.append(index);
    sb.append("]");
    sb.append("(http://10.0.1.8/mantis2/view.php?id=");
    sb.append(index);
    sb.append(")");

    sb.append(trim.substring(5, len));

    return sb.toString();
  }

}
