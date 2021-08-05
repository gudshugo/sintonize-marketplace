package br.com.sintonize.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorVenda;

    private Double valorCashback;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "venda_id")
    @JsonIgnore
    private List<ItemAlbumVenda> itemAlbumVendas;

    private LocalDate dataVenda;

    private UUID uniqueId;

    public static class Builder {

        private Long id;
        private Double valorVenda;
        private Double valorCashback;
        private LocalDate dataVenda;
        private UUID uniqueId;
        private List<ItemAlbumVenda> itemAlbumVendas;

        public Builder setId(Long id){
            this.id = id;
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

        public Builder withDataVenda(LocalDate dataVenda){
            this.dataVenda = dataVenda;
            return this;
        }

        public Builder withUniqueId(UUID uniqueId){
            this.uniqueId = uniqueId;
            return this;
        }

        public Builder withItemAlbumVendas(List<ItemAlbumVenda> itemAlbumVendas){
            this.itemAlbumVendas = itemAlbumVendas;
            return this;
        }

        public Venda build(){
            return new Venda(this);
        }
    }

    private Venda (Builder builder){
        id = builder.id;
        valorVenda = builder.valorVenda;
        valorCashback = builder.valorCashback;
        itemAlbumVendas = builder.itemAlbumVendas;
        dataVenda  = builder.dataVenda;
        uniqueId = builder.uniqueId;
    }

}
