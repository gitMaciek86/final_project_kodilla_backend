package com.translation.demo.utils.encoder;

public class Encoder {

    public static String encode(String value) {
        String result = value.replaceAll("\\s", "%20");
        System.out.println(result);
        return result;
    }
}


