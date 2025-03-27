package org.example.util;

import java.util.Base64;

public class GeneratorRegistrationNumberCargo {

    public static String generate(Long longNumber){
        byte[] bytes = longToBytes(longNumber);
        String base64String = Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(bytes);
        return base64String.substring(0, Math.min(9, base64String.length()));
    }

    private static byte[] longToBytes(long x){
        return new byte[]{
                (byte) (x >> 56),
                (byte) (x >> 48),
                (byte) (x >> 40),
                (byte) (x >> 32),
                (byte) (x >> 24),
                (byte) (x >> 16),
                (byte) (x >> 8),
                (byte) x
        };
    }
}
