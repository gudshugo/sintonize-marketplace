package br.com.sintonize.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Album {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nome;
    private String nomeArtista;
    private String imagem;
    private BigDecimal valor;
    private String idApiSpotify;
    private String linkSpotify;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "album_id")
    @JsonIgnore
    private List<AlbumDetalhe> albumDetalhes;

    public static class Builder {

        private String nome;
        private String nomeArtista;
        private String imagem;
        private BigDecimal valor;
        private String idApiSpotify;
        private String linkSpotify;
        private List<AlbumDetalhe> albumDetalhes;

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

        public Builder withValor(BigDecimal valor){
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

        public Builder withAlbumDetalhes(List<AlbumDetalhe> albumDetalhes){
            this.albumDetalhes = albumDetalhes;
            return this;
        }

        public Album build() {
            return new Album(this);
        }

    }

    private Album(Builder builder) {
        nome = builder.nome;
        nomeArtista = builder.nomeArtista;
        imagem = builder.imagem;
        valor = builder.valor;
        linkSpotify = builder.linkSpotify;
        idApiSpotify = builder.idApiSpotify;
        albumDetalhes = builder.albumDetalhes;
    }

}
