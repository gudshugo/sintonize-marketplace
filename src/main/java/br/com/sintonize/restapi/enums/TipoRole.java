package br.com.sintonize.restapi.enums;

public enum TipoRole {

    ADMIN("ADMIN"),USER_CREATE("USER_CREATE"),USER_UPDATE("USER_UPDATE"),USER("USER");

    private final String descricao;

    TipoRole(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
