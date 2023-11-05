package com.torneo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Equipo implements IImprimible{
    private String name;
    private String abreviatura;
    private List<iJugador> jugadores;

    public Equipo(String name, String abreviatura) {
        this.name = name;
        this.abreviatura = abreviatura;
        this.jugadores = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getAbreviatura() {
        return abreviatura;
    }
    
    public void agregar(iJugador jugadorBoca6) {
        jugadores.add(jugadorBoca6);
    }

    public int jugadoresCantidad() {
        return jugadores.size();
    }
    public List<iJugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<iJugador> jugadores) {
        this.jugadores = jugadores;
    }

    public iJugador obtenerJugador(int numero) {
        for (iJugador jugador : jugadores) {
            if (jugador.getNumero() == numero) {
                return jugador;
            }
        }
        return null;
    }
    
   
    public String imprimirPlantel() {
        List<String> plantel = jugadores.stream()
                .sorted((j1, j2) -> Integer.compare(j1.getNumero(), j2.getNumero()))
                .map(jugador -> String.format("[%d] %s (%s)", jugador.getNumero(), jugador.getName(), jugador.getPosicion()))
                .collect(Collectors.toList());

        return String.join(", ", plantel);
    }

    @Override
    public String impresion() {
        // "[Equipo] Boca Juniors > BOC"
        return String.format("[Equipo] %s > %s",
                getName(),
                getAbreviatura());
    }
}
