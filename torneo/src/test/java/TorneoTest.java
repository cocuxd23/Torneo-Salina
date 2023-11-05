import static org.junit.Assert.assertEquals;
import com.torneo.Equipo;
import com.torneo.Estadio;
import com.torneo.Jugador;
import com.torneo.Partido;
import com.torneo.TarjetaBase;
import com.torneo.Torneo;

import org.junit.Test;

public class TorneoTest {
    @Test
    public void torneo_agregar_equipos_parcial_ejercicio_ejemplo_01()
    {
        Torneo torneo = new Torneo("Copa Conmebol Libertadores");

        Equipo boca = new Equipo("Boca Juniors", "BOC");        
        Equipo palmeiras = new Equipo("Palmeiras", "PAL");

        torneo.agregar(boca);        
        torneo.agregar(palmeiras);


        assertEquals("Boca Juniors", boca.getName());            
        assertEquals("BOC", boca.getAbreviatura());        
    
        assertEquals("Palmeiras", palmeiras.getName());  
        assertEquals("PAL", palmeiras.getAbreviatura());        
        
        assertEquals(2, torneo.equiposCantidad());
    }



    @Test
    public void torneo_agregar_partidos_parcial_ejercicio_ejemplo_02()
    {
        Torneo torneo = new Torneo("Copa Conmebol Libertadores");

        Equipo boca = new Equipo("Boca Juniors", "BOC");        
        Equipo palmeiras = new Equipo("Palmeiras", "PAL");
        Equipo internacional = new Equipo("Internacional", "INT");        
        Equipo fluminense = new Equipo("Fluminense", "FLU");
        Estadio monumental = new Estadio("Monumental","Buenos Aires", "Argentina");
        
        torneo.agregar(boca);        
        torneo.agregar(palmeiras);
        torneo.agregar(internacional);        
        torneo.agregar(fluminense);
            
        Partido partido1Ida = new Partido(monumental, internacional, fluminense, "Semifinal Partido Ida");
        Partido partido1Vuelta = new Partido(monumental, fluminense, internacional, "Semifinal Partido Vuelta");   

        Partido partido2Ida = new Partido(monumental, palmeiras, boca, "Semifinal Partido Ida");
        Partido partido2Vuelta = new Partido(monumental, boca, palmeiras, "Semifinal Partido Vuelta");    

        
        torneo.agregar(partido1Ida);
        torneo.agregar(partido2Vuelta);

        torneo.agregar(partido2Ida);
        torneo.agregar(partido2Vuelta);

        assertEquals(4, torneo.partidosCantidad());  
        assertEquals("Semifinal Partido Ida INTxFLU", partido1Ida.getName());        
        assertEquals("Semifinal Partido Vuelta FLUxINT", partido1Vuelta.getName());      
        assertEquals("Semifinal Partido Ida PALxBOC", partido2Ida.getName());        
        assertEquals("Semifinal Partido Vuelta BOCxPAL", partido2Vuelta.getName());

    }

    
    @Test
    public void torneo_agregar_jugadores_a_un_equipo_parcial_ejercicio_ejemplo_03()
    {        
        Equipo boca = new Equipo("Boca Juniors", "BOC");          
        
        Jugador jugador10 = new Jugador("Edinson Cavani", 10);   
        Jugador jugador19 = new Jugador("Valentin Barco", 19);
  
        boca.agregar(jugador10);         
        boca.agregar(jugador19); 

        assertEquals(2, boca.jugadoresCantidad());          
        
        assertEquals("Edinson Cavani", boca.obtenerJugador(10).getName());          
        assertEquals("Valentin Barco", boca.obtenerJugador(19).getName());  

    }


    
    @Test
    public void torneo_sacar_tarjeta_roja_a_un_jugador_en_un_partido_parcial_ejercicio_ejemplo_04()
    {        
        Equipo boca = new Equipo("Boca Juniors", "BOC");        
        Equipo palmeiras = new Equipo("Palmeiras", "PAL");        
        
        Jugador jugador10 = new Jugador("Edinson Cavani", 10);   
        Jugador jugador19 = new Jugador("Valentin Barco", 19);
  
        boca.agregar(jugador10);         
        boca.agregar(jugador19); 

        Estadio monumental = new Estadio("Monumental","Buenos Aires", "Argentina");
        Partido partidoIda = new Partido(monumental, palmeiras, boca, "Semifinal Partido Ida");    

        TarjetaBase tarjetaRojaParaJugador10DeBoca = new TarjetaBase("ROJA", jugador10);

        partidoIda.agregar(tarjetaRojaParaJugador10DeBoca);

        assertEquals(1, partidoIda.tarjetasCantidad());          
        
        assertEquals("ROJA", partidoIda.getTarjetas().get(0).getColor());           
        assertEquals("Edinson Cavani", partidoIda.getTarjetas().get(0).getJugador().getName());   


    }

}
