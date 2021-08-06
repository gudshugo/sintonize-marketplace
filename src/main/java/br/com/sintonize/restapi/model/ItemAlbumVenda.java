package br.com.sintonize.restapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "album_venda")
@NoArgsConstructor
@Getter
public class ItemAlbumVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;

    private Double valorVenda;

    private Double valorCashback;

    public static class Builder {

        private Long id;
        private Album album;
        private Venda venda;
        private Double valorVenda;
        private Double valorCashback;

        public Builder setId(Long id){
            this.id = id;
            return this;
        }

        public Builder withAlbum(Album album){
            this.album = album;
            return this;
        }

        public Builder withVenda(Venda venda){
            this.venda = venda;
            return this;
        }

        public Builder withValorVenda(Double valorVenda){
            this.valorVenda = valorVenda;
            return this;
        }

        public Builder withValorCashback(Double valorCashback){
            this.valorCashback = valorCashback;
            return this;
        }

        public ItemAlbumVenda build(){
            return new ItemAlbumVenda(this);
        }
    }

    private ItemAlbumVenda(Builder builder){
        id = builder.id;
        album = builder.album;
        venda = builder.venda;
        valorVenda = builder.valorVenda;
        valorCashback = builder.valorCashback;
    }
}
