package br.com.sintonize.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

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
    private int duracao;
    private String preview;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    public static class Builder {

        private int numero;
        private String nome;
        private int duracao;
        private String preview;
        private Album album;

        public Builder withNumero(int numero){
            this.numero = numero;
            return this;
        }

        public Builder withNome(String nome){
            this.nome = nome;
            return this;
        }

        public Builder withDuracao(int duracao){
            this.duracao = duracao;
            return this;
        }

        public Builder withPreview(String preview){
            this.preview = preview;
            return this;
        }

        public Builder withAlbum(Album album){
            this.album = album;
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
        album = builder.album;
    }

}
