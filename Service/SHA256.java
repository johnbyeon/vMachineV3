package Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {

    //DB에서 받아올때 생성자로 만 가져오기 있는 그대로 입력
    public  static boolean InputPasswordEquals(String Inputpassword,String EqulasPassword) throws NoSuchAlgorithmException {
        if(EqulasPassword.equals(encrypt(Inputpassword)))
            return  true;
        else
            return false;
    }
    public static String encrypt(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(text.getBytes());
        return bytesToHex(md.digest());
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

}
