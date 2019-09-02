package others;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.codec.binary.Base64;

/**
 * MapUtilTest TODO 自动生成的注释，需修改
 *
 * @author jinxin
 */
public class MapUtilTest {

  private final Map<String, byte[]> certHashId2CertBytes = new ConcurrentHashMap<>();

  private MapUtilTest() {
    init();
  }

  private void init() {
    try {
      if (certHashId2CertBytes.containsKey("all")) {
        System.out.println("certHashId duplicated{}.ignored");
      } else {
        certHashId2CertBytes.put("all", Base64.decodeBase64("all"));
      }
    } catch (Exception e) {
      System.out.println("load ca certs failed" + e);
    }
  }

  public static MapUtilTest getInstance() {
    return Inner.instance;
  }

  private static class Inner {

    private static MapUtilTest instance = new MapUtilTest();
  }

  public static void main(String[] args) {
    MapUtilTest.getInstance();
  }

}
