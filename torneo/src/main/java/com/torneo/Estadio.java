package com.torneo;

public class Estadio implements IImprimible{
    private String name;
    private String ciudad;
    private String pais;

    public Estadio (String name, String ciudad, String pais){
        this.name = name;
        this.ciudad = ciudad;
        this.pais = pais;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCiudad() {
        return ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return name + ", " + ciudad + " (" + pais +")";
    }

    @Override
    public String impresion() {
        // "[Estadio] La Bombonera (Buenos Aires - Argentina)"
        return String.format("[Estadio] %s (%s - %s)",
                getName(),
                getCiudad(),
                getPais());
    }
}

