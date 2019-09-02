package others;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SecureUtil {

    private static final String ENC_FLAG = "~|!&";

    /**
     * 加密配置参数使用的KEY
     */
    private static final byte[] KEY = {0x39, 0x7a, -0x28, 0x6e, -0x1d, 0x24, 0x6f, -0x3b};

    public static void main(String[] args) {
        try {
            System.out.println(encryptString("root123"));
            System.out.println(encryptString("iamhuan"));
            System.out.println(decryptString("QgP8KOz4XjN2hZqLV/H4mP6BdqIgBzu0"));
            System.out.println(decryptString("ODlwMTc1NjgxNDQ0OTc3Nw=="));
            System.out.println(decryptString("ODIwMTc1NjgxNDQ0OTc3Nw=="));
            System.out.println(encryptString("ODlwMTc1NjgxNDQ0OTc3Nw=="));
            System.out.println(encryptString("ODIwMTc1NjgxNDQ0OTc3Nw=="));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public static String encryptString(String val) throws Exception {
        return SecureUtil.enc3DES(val, KEY);
    }

    public static String decryptString(String val) throws Exception {
        return SecureUtil.tryDec3DES(val, KEY);
    }

    public static String enc3DES(String input, byte[] key) throws Exception {
        // 增加加密标记，防止解密时误判
        byte[] encData = enc3DES((ENC_FLAG + input).getBytes(), key, true);
        return Base64.encodeBase64String(encData);
        // return new String(Base64.encode(encData));
    }

    public static byte[] enc3DES(byte[] inputData, byte[] key, boolean useIv)
            throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "DES"));
        return cipher.doFinal(inputData);
    }

    public static String tryDec3DES(String input, byte[] key) throws Exception {
        byte[] decData;
        try {
            decData = dec3DES(Base64.decodeBase64(input), key, true);
        } catch (Exception e) {
            // 不是加密数据
            return input;
        }

        String txt = new String(decData);
        if (txt.startsWith(ENC_FLAG)) {
            return txt.substring(ENC_FLAG.length(), txt.length());
        } else
            return input;
    }

    public static byte[] dec3DES(byte[] input, byte[] key, boolean useIv)
        throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "DES"));
        return cipher.doFinal(input);
    }

}
