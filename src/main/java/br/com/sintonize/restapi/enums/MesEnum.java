package br.com.sintonize.restapi.enums;

import br.com.sintonize.restapi.exception.EnumNotFoundException;

import java.time.LocalDate;

public enum MesEnum {

    JAN(1, "Janeiro"),
    FEV(2, "Fevereiro"),
    MAR(3, "Março"),
    ABR(4, "Abril"),
    MAI(5, "Maio"),
    JUN(6, "Junho"),
    JUL(7, "Julho"),
    AGO(8, "Agosto"),
    SET(9, "Setembro"),
    OUT(10, "Outubro"),
    NOV(11, "Novembro"),
    DEZ(12, "Dezembro");

    private final int value;
    private final String descricao;

    MesEnum(int value, String descricao) {
        this.value = value;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getValue() {
        return value;
    }

    public static int toEnumValue(LocalDate date) {

        switch(date.getMonthValue()) {
            case 1:
                return MesEnum.JAN.getValue();
            case 2:
                return MesEnum.FEV.getValue();
            case 3:
                return MesEnum.MAR.getValue();
            case 4:
                return MesEnum.ABR.getValue();
            case 5:
                return MesEnum.MAI.getValue();
            case 6:
                return MesEnum.JUN.getValue();
            case 7:
                return MesEnum.JUL.getValue();
            case 8:
                return MesEnum.AGO.getValue();
            case 9:
                return MesEnum.SET.getValue();
            case 10:
                return MesEnum.OUT.getValue();
            case 11:
                return MesEnum.NOV.getValue();
            case 12:
                return MesEnum.DEZ.getValue();
            default:
                throw new EnumNotFoundException("Data inválida!");
        }
    }
}
