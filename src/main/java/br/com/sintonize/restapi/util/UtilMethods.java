package br.com.sintonize.restapi.util;

public class UtilMethods {

    public static double randomPriceGenerator() {
        double min = 20.0;
        double max = 50.0;
        double range = max - min;
        return min + Math.random() * range;
    }

}
