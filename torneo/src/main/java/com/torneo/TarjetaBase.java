package com.torneo;

public class TarjetaBase {
    private String color;
    private iJugador jugador;



    public TarjetaBase(String color, iJugador jugador) {
        setColor(color);
        setJugador(jugador);
    }

    public String getColor() {
        return color;
    }
   
    public void setColor(String value) {
        this.color = value;
    }

    
    public iJugador getJugador(){
        return jugador;
    }

    private void setJugador(iJugador jugador) {
        this.jugador = jugador;

           }


   
    @Override
    public String toString(){
        return String.format("Tarjeta %s para %s",
                    getColor(),
                    getJugador().getName());
    }

}
