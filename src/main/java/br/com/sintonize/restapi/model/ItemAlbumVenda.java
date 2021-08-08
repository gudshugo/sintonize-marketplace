package br.com.sintonize.restapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

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

    private String codigoVenda;

    private BigDecimal valorVenda;

    private BigDecimal valorCashback;

    public static class Builder {

        private Album album;
        private String codigoVenda;
        private BigDecimal valorVenda;
        private BigDecimal valorCashback;

        public Builder withAlbum(Album album){
            this.album = album;
            return this;
        }

        public Builder withCodigoVenda(String codigoVenda){
            this.codigoVenda = codigoVenda;
            return this;
        }

        public Builder withValorVenda(BigDecimal valorVenda){
            this.valorVenda = valorVenda;
            return this;
        }

        public Builder withValorCashback(BigDecimal valorCashback){
            this.valorCashback = valorCashback;
            return this;
        }

        public ItemAlbumVenda build(){
            return new ItemAlbumVenda(this);
        }
    }

    private ItemAlbumVenda(Builder builder){
        album = builder.album;
        codigoVenda = builder.codigoVenda;
        valorVenda = builder.valorVenda;
        valorCashback = builder.valorCashback;
    }
}
