package com.torneo;

import java.util.ArrayList;
import java.util.List;

public class Var {
    private Partido partido;
    private AsistenteVideo asistenteVideo;
    private List<AVAR> aVar = new ArrayList<>();
    private Arbitro arbitro;
    private List<Arbitro> arbitros;
    private Estadio estadio;

    public Var(Partido partido) {
        this.partido = partido;
    }
    
    public List<AVAR> getaVar() {
        return aVar;
    }
    
    public void setaVar(AVAR aVar1, AVAR aVar2, AVAR aVar3) {
        this.aVar.add(aVar1);
        this.aVar.add(aVar2);
        this.aVar.add(aVar3);
        // if (this.aVar.size() == 3) {
        //     this.aVar = aVar;
        // } else {
        //     throw new IllegalArgumentException("aVar list must contain exactly 3 items.");
        // }
    }


    public AsistenteVideo getAsistenteVideo() {
        return asistenteVideo;
    }

    public void setAsistenteVideo(AsistenteVideo asistenteVideo) {
        this.asistenteVideo = asistenteVideo;
    }
    
    public int cantidadTarjetas(Equipo pEquipo){
        List<IJugador> jugadores = pEquipo.getJugadores();
        List<TarjetaBase> tarjetas = this.partido.getTarjetas();
        return (int) tarjetas.stream()
                .filter(tarjeta -> jugadores.contains(tarjeta.getJugador())).
                count();
    }

    public int cantidadTarjetasRojas() {
        int cont = 0;
        List<TarjetaBase> tarjetas = partido.getTarjetas();
        for (TarjetaBase tarjeta : tarjetas) {
            if (tarjeta instanceof TarjetaRoja) {
                cont++;
            }
        }
        return cont;
    }

    
    public int cantidadTarjetasAmarillas() {
        int cont = 0;
        List<TarjetaBase> tarjetas = partido.getTarjetas();
        for (TarjetaBase tarjeta : tarjetas) {
            if (tarjeta instanceof TarjetaAmarilla) {
                cont++;
            }
        }
        return cont;
    }
    public Partido getPartido() {
        return this.partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }



    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }
    public Arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitroLinea(List<Arbitro> arbitros) {
        this.arbitros = arbitros;
    }
    
    public List<Arbitro> getArbitroLinea() {
        return arbitros;
    }

    public Estadio getEstadio() {
 
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }
    

    public Var(Partido pPartido, AsistenteVideo asistenteVideo, AVAR aVAR1, AVAR aVAR2, AVAR aVAR3){
        setPartido(pPartido);
        setAsistenteVideo(asistenteVideo);
        setaVar(aVAR1, aVAR2, aVAR3);
    }

    
}
