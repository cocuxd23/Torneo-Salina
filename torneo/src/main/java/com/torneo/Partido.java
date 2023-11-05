package com.torneo;

import java.util.ArrayList;
import java.util.List;

public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private String nombre;
    private List<TarjetaBase> tarjetas;
    private Estadio estadio;

    public Partido(Estadio estadio,Equipo equipoLocal, Equipo equipoVisitante, String nombre) {
        this.estadio = estadio;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.nombre = nombre;
        this.tarjetas = new ArrayList<>();
    }

    public String getName() {
        return nombre + " " + equipoLocal.getAbreviatura() + "x" + equipoVisitante.getAbreviatura();
    }
    
 
    public void setName(String nombre) {
            this.nombre = nombre;
    }

    public void agregar(TarjetaBase tarjeta) {
        tarjetas.add(tarjeta);
    }

    public int tarjetasCantidad() {
        return tarjetas.size();
    }

    public List<TarjetaBase> getTarjetas() {
        return tarjetas;
    }

    public Object getEstadio() {
        return estadio;
    }
}
