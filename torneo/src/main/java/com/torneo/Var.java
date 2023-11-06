package com.torneo;

import java.util.List;

public class Var {
    private Partido partido;
    private AsistenteVideo asistenteDeVideo;
    private List<Avar> aVar;
    private Arbitro arbitro;
    private List<Arbitro> arbitros;

    public Var(Partido partido){
        this.partido = partido;
    }

    public List<Avar> getaVar(){
        return aVar;
    }

    public void setaVar(List<Avar> aVar) {
        if (this.aVar.size() == 3) {
            this.aVar = aVar;
        } else {
            throw new IllegalArgumentException("aVar list must contain exactly 3 items.");
        }
    }

    public AsistenteVideo getAsistenteVideo() {
        return asistenteDeVideo;
    }

    public void setAsistenteVideo(AsistenteVideo asistenteDeVideo) {
        this.asistenteDeVideo = asistenteDeVideo;
    }

    public int cantidadTarjetas(Equipo pEquipo){
        List<IJugador> jugadores = pEquipo.getJugadores();
        List<TarjetaBase> tarjetas = this.partido.getTarjetas();
        return (int) tarjetas.stream()
                .filter(tarjeta -> jugadores.contains(tarjeta.getJugador())).
                count();
    }


     public int cantidadTarjetasRojas() {
        int count = 0;
        List<TarjetaBase> tarjetas = partido.getTarjetas();
        for (TarjetaBase tarjeta : tarjetas) {
            if (tarjeta instanceof TarjetaRoja) {
                count++;
            }
        }
        return count;
    }

    public int cantidadTarjetasAmarillas() {
        int count = 0;
        List<TarjetaBase> tarjetas = partido.getTarjetas();
        for (TarjetaBase tarjeta : tarjetas) {
            if (tarjeta instanceof TarjetaAmarilla) {
                count++;
            }
        }
        return count;
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
    
}
