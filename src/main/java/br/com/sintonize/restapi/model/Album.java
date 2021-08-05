package br.com.sintonize.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Album {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private UUID uniqueId;
    private String nome;
    private String nomeArtista;
    private String imagem;
    private Double valor;
    private String idApiSpotify;
    private String linkSpotify;

    public static class Builder {

        private UUID uniqueId;
        private String nome;
        private String nomeArtista;
        private String imagem;
        private Double valor;
        private String idApiSpotify;
        private String linkSpotify;

        public Builder withUniqueId(UUID uniqueId){
            this.uniqueId = uniqueId;
            return this;
        }

        public Builder withNome(String nome){
            this.nome = nome;
            return this;
        }

        public Builder withImagem(String imagem){
            this.imagem = imagem;
            return this;
        }

        public Builder withNomeArtista(String nomeArtista){
            this.nomeArtista = nomeArtista;
            return this;
        }

        public Builder withValor(Double valor){
            this.valor = valor;
            return this;
        }

        public Builder withIdApiSpotify(String idApiSpotify){
            this.idApiSpotify = idApiSpotify;
            return this;
        }

        public Builder withLinkSpotify(String linkSpotify){
            this.linkSpotify = linkSpotify;
            return this;
        }

        public Album build() {
            return new Album(this);
        }

    }

    private Album(Builder builder) {
        uniqueId = builder.uniqueId;
        nome = builder.nome;
        nomeArtista = builder.nomeArtista;
        imagem = builder.imagem;
        valor = builder.valor;
        linkSpotify = builder.linkSpotify;
        idApiSpotify = builder.idApiSpotify;
    }

}
