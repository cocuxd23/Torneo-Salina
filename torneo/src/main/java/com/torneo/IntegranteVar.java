package com.torneo;

public class IntegranteVar extends ArbitroBase{
    
    public IntegranteVar(String name) {
        super(name);
    }

    private String TipoAsistente;

    public String getTipoAsistente() {
        return TipoAsistente;
    }

    public void setTipoAsistente(String tipoAsistente) {
        TipoAsistente = tipoAsistente;
    }
}
