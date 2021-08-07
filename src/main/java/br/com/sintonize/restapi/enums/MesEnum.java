package br.com.sintonize.restapi.enums;

import br.com.sintonize.restapi.exception.EnumNotFoundException;

import java.util.Calendar;
import java.util.Date;

public enum MesEnum {

    JANEIRO(1, "Janeiro"),
    FEVEREIO(2, "Fevereiro"),
    MARCO(3, "Março"),
    ABRIL(4, "Abril"),
    MAIO(5, "Maio"),
    JUNHO(6, "Junho"),
    JULHO(7, "Julho"),
    AGOSTO(8, "Agosto"),
    SETEMBRO(9, "Setembro"),
    OUTUBRO(10, "Outubro"),
    NOVEMBRO(11, "Novembro"),
    DEZEMBRO(12, "Dezembro");

    MesEnum(int value, String descricao) {
    }

    public static MesEnum toEnum(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        switch(calendar.get(Calendar.MONTH)) {
            case 1:
                return MesEnum.JANEIRO;
            case 2:
                return MesEnum.FEVEREIO;
            case 3:
                return MesEnum.MARCO;
            case 4:
                return MesEnum.ABRIL;
            case 5:
                return MesEnum.MAIO;
            case 6:
                return MesEnum.JUNHO;
            case 7:
                return MesEnum.JULHO;
            case 8:
                return MesEnum.AGOSTO;
            case 9:
                return MesEnum.SETEMBRO;
            case 10:
                return MesEnum.OUTUBRO;
            case 11:
                return MesEnum.NOVEMBRO;
            case 12:
                return MesEnum.DEZEMBRO;
            default:
                throw new EnumNotFoundException("Data inválida!");
        }
    }
}
