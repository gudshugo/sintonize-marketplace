package br.com.sintonize.restapi.model;

import br.com.sintonize.restapi.enums.DiaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "genero_cashback")
public class GeneroCashBack {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    @Column(name = "dia")
    private DiaEnum dia;

    private Double cashback;

    public static class Builder {

        private Long id;
        private Genero genero;
        private DiaEnum dia;
        private Double cashback;

        public Builder setId(Long id){
            this.id = id;
            return this;
        }

        public Builder withGenero(Genero genero){
            this.genero = genero;
            return this;
        }

        public Builder withDia(DiaEnum dia){
            this.dia = dia;
            return this;
        }

        public Builder withCashback(Double cashback){
            this.cashback = cashback;
            return this;
        }

        public GeneroCashBack build(){
            return new GeneroCashBack(this);
        }
    }

    private GeneroCashBack(Builder builder){
        id = builder.id;
        genero = builder.genero;
        dia = builder.dia;
        cashback = builder.cashback;
    }

}
