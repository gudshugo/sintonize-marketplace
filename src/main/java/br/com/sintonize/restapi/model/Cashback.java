package br.com.sintonize.restapi.model;


import br.com.sintonize.restapi.enums.DiaEnum;
import br.com.sintonize.restapi.enums.MesEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Cashback {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "dia")
    private DiaEnum dia;

    @Column(name = "mes")
    private MesEnum mes;

    private Double cashback;

    public static class Builder {

        private DiaEnum dia;
        private Double cashback;

        public Builder withDia(DiaEnum dia){
            this.dia = dia;
            return this;
        }

        public Builder withCashback(Double cashback){
            this.cashback = cashback;
            return this;
        }

        public Cashback build(){
            return new Cashback(this);
        }
    }

    private Cashback(Builder builder){
        dia = builder.dia;
        cashback = builder.cashback;
    }



}
