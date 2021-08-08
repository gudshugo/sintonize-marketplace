package br.com.sintonize.restapi.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class UtilMethods {

    public static BigDecimal randomPriceGenerator() {
        BigDecimal min = BigDecimal.valueOf(20);
        BigDecimal max = BigDecimal.valueOf(100);

        BigDecimal bigDecimal = min.add(BigDecimal.valueOf(Math.random()).multiply(max.subtract(min)));
        return bigDecimal.setScale(2, RoundingMode.HALF_UP);
    }

    public static String randomOrderNumberGenerator() {

        Random random = new Random();
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        StringBuilder sb = new StringBuilder((100000 + random.nextInt(900000)) + "-");

        for (int i = 0; i < 5; i++)
            sb.append(chars[random.nextInt(chars.length)]);

        return sb.toString();
    }

}
