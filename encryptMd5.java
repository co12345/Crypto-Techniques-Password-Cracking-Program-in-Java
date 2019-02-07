import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;


public class encryptMd5 {
    

    public static void encrypByMd5(String context) {  
        try {  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            md.update(context.getBytes());//update
            byte [] encryContext = md.digest();
  
            int i;  
            StringBuffer buf = new StringBuffer("");  
            for (int offset = 0; offset < encryContext.length; offset++) {
                i = encryContext[offset];  
                if (i < 0) i += 256;  
                if (i < 16) buf.append("0");  
                buf.append(Integer.toHexString(i));  
           }  
           System.out.println("32result: " + buf.toString());// 32 bit encryption
           System.out.println("16result: " + buf.toString().substring(8, 24));// 16 bit encryption
        } catch (NoSuchAlgorithmException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
      


    public static String encrypByMd5Jar(String context) {  
        String md5Str = DigestUtils.md5Hex(context);  
        return md5Str;     
    }  
  
    public static void main(String[] args) {  

        encrypByMd5Jar("123456");  
    }  
} 