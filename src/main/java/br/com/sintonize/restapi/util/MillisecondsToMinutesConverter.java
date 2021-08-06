package br.com.sintonize.restapi.util;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.util.concurrent.TimeUnit;

public class MillisecondsToMinutesConverter extends StdConverter<Integer, String> {

  @Override
  public String convert(Integer value) {
      return String.format("%02d min e %02d sec",
              TimeUnit.MILLISECONDS.toMinutes(value),
              TimeUnit.MILLISECONDS.toSeconds(value) -
                      TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(value)));
  }

}