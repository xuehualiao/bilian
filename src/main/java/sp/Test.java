package sp;

import org.apache.tomcat.util.security.MD5Encoder;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test {


    static String src = "Hello,sahadev!";

    public static void main(String[] args) {
//        MD5();
        MD2();
    }

    /**
     * MD5加密
     */
    public static void MD5() {
        try {
            // 获取MD5加密工具
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 加密
            byte[] digest = md.digest(src.getBytes());
            // 获取二进制十六进制互转工具
            HexBinaryAdapter hexBinaryAdapter = new HexBinaryAdapter();
            // 将二进制数组转换为十六进制字符串
            String marshal = hexBinaryAdapter.marshal(digest);
            // 输出结果
//            System.out.println(marshal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * MD2加密
     */
    public static void MD2() {
        try {
            // 获取MD2加密工具
            MessageDigest md = MessageDigest.getInstance("MD2");
            byte[] digest = md.digest("100101".getBytes());
            // 加密
            for (int i = 0; i < 100000000; i++) {
                digest = md.digest(digest);

            }
            // 将二进制数组转换为十六进制字符串
            HexBinaryAdapter hexBinaryAdapter = new HexBinaryAdapter();
            String marshal = hexBinaryAdapter.marshal(digest);


            System.out.println(marshal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



