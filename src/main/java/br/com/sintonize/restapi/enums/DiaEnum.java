package br.com.sintonize.restapi.enums;

import br.com.sintonize.restapi.exception.EnumNotFoundException;

import java.time.LocalDate;

public enum DiaEnum {

    SEG(1, "Segunda"),
    TER(2, "Terça"),
    QUA(3, "Quarta"),
    QUI(4, "Quinta"),
    SEX(5, "Sexta"),
    SAB(6, "Sábado"),
    DOM(7, "Domingo");

    private final int value;
    private final String descricao;

    DiaEnum(int value, String descricao) {
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

        switch(date.getDayOfWeek()) {
            case MONDAY:
                return DiaEnum.SEG.getValue();
            case TUESDAY:
                return DiaEnum.TER.getValue();
            case WEDNESDAY:
                return DiaEnum.QUA.getValue();
            case THURSDAY:
                return DiaEnum.QUI.getValue();
            case FRIDAY:
                return DiaEnum.SEX.getValue();
            case SATURDAY:
                return DiaEnum.SAB.getValue();
            case SUNDAY:
                return DiaEnum.DOM.getValue();
            default:
                throw new EnumNotFoundException("Data inválida!");
        }

    }

}
