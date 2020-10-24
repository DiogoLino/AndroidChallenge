package com.android.api.contacts;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuthApi {

    private String timeStamp;
    private String md5Key;

    private static final String KEY_PRIVATE = "ff28c030a8a73b3f90bdbbaef598657e86ea4ba4";
    private static final String KEY_PUBLIC = "2b67c95d9c57aee27f2b5ff6b525f681";

    public AuthApi() {
        timeStamp = String.valueOf(System.currentTimeMillis());
    }

    public String getPublicKey() {
        return KEY_PUBLIC;
    }

    public String getPrivateKey() {
        return KEY_PRIVATE;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getMd5Key() {

        String input = getTimeStamp() + getPrivateKey() + getPublicKey();

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md.digest(input.getBytes());

            StringBuilder md5 = new StringBuilder();
            for (byte md5Byte : md5Bytes) {
                md5.append(Integer.toHexString((md5Byte & 0xFF) | 0x100).substring(1, 3));
            }
            md5Key = md5.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5Key;
    }

}

