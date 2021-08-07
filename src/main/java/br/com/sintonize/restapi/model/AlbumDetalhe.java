package br.com.sintonize.restapi.model;

import br.com.sintonize.restapi.util.MillisecondsToMinutesConverter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AlbumDetalhe {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private int numero;
    private String nome;

    @JsonSerialize(converter = MillisecondsToMinutesConverter.class)
    private Integer duracao;

    private String preview;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    public static class Builder {

        private int numero;
        private String nome;
        private Integer duracao;
        private String preview;

        public Builder withNumero(int numero){
            this.numero = numero;
            return this;
        }

        public Builder withNome(String nome){
            this.nome = nome;
            return this;
        }

        public Builder withDuracao(Integer duracao){
            this.duracao = duracao;
            return this;
        }

        public Builder withPreview(String preview){
            this.preview = preview;
            return this;
        }

        public AlbumDetalhe build() {
            return new AlbumDetalhe(this);
        }

    }

    private AlbumDetalhe(Builder builder) {
        numero = builder.numero;
        nome = builder.nome;
        duracao = builder.duracao;
        preview = builder.preview;
    }

}
