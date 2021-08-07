package br.com.sintonize.restapi.enums;

import br.com.sintonize.restapi.exception.EnumNotFoundException;

import java.util.Calendar;
import java.util.Date;

public enum DiaEnum {

    DOM(1), SEG(2), TER(3), QUA(4), QUI(5), SEX(6), SAB(7);

    DiaEnum(final int value){
    }

    public static DiaEnum toEnum(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        switch(calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                return DiaEnum.DOM;
            case 2:
                return DiaEnum.SEG;
            case 3:
                return DiaEnum.TER;
            case 4:
                return DiaEnum.QUA;
            case 5:
                return DiaEnum.QUI;
            case 6:
                return DiaEnum.SEX;
            case 7:
                return DiaEnum.SAB;
            default:
                throw new EnumNotFoundException("Data inválida!");
        }

    }

}
