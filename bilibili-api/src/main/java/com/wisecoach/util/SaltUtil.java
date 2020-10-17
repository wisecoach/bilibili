package com.wisecoach.util;

import com.wisecoach.pojo.Member;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SaltUtil {

    public static String salty(Member member) {
        String idSHA = getSHA(member.getMid().toString(), "SHA1");
        String pref = idSHA.substring(0, 12);
        String post = idSHA.substring(28, 40);
        String salt = getSHA(pref + member.getPassword() + post, "SHA-256");
        return salt;
    }

    public static String getSHA(String str, String algo) {
        MessageDigest messageDigest;
        String encodestr = "";
        try {
            messageDigest = MessageDigest.getInstance(algo);
            messageDigest.update(str.getBytes("UTF-8"));
            encodestr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodestr;
    }

    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

}