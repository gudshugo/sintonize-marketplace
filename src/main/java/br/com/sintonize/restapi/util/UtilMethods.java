package br.com.sintonize.restapi.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UtilMethods {

    public static double randomPriceGenerator() {
        double min = 20.0;
        double max = 50.0;
        double range = max - min;
        return min + Math.random() * range;
    }

    public static LocalDate toLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static String convertMsToMinutesString(int ms){

        return String.format("%02d min, %02d sec",
                TimeUnit.MILLISECONDS.toMinutes(ms),
                TimeUnit.MILLISECONDS.toSeconds(ms) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(ms))
        );

    }

}
