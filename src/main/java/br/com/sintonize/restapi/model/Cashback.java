package br.com.sintonize.restapi.model;


import br.com.sintonize.restapi.enums.DiaEnum;
import br.com.sintonize.restapi.enums.MesEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Cashback {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "dia")
    @Enumerated(EnumType.ORDINAL)
    private DiaEnum dia;

    @Column(name = "mes")
    @Enumerated(EnumType.ORDINAL)
    private MesEnum mes;

    private BigDecimal valor;

    public static class Builder {

        private MesEnum mes;
        private DiaEnum dia;
        private BigDecimal valor;

        public Builder withMes(MesEnum mes){
            this.mes = mes;
            return this;
        }

        public Builder withDia(DiaEnum dia){
            this.dia = dia;
            return this;
        }

        public Builder withValor(BigDecimal valor){
            this.valor = valor;
            return this;
        }

        public Cashback build(){
            return new Cashback(this);
        }
    }

    private Cashback(Builder builder){
        mes = builder.mes;
        dia = builder.dia;
        valor = builder.valor;
    }



}
