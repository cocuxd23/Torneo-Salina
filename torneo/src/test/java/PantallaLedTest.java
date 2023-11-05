import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.torneo.Equipo;
import com.torneo.Estadio;
import com.torneo.IImprimible;
import com.torneo.Jugador;
import com.torneo.PantallaLed;
import com.torneo.iJugador;

public class PantallaLedTest {  //Ejercicio 4.6: Pantallas Led
    @Test
    public void pantallas_estadio_parcial_ejercicio_ejemplo_10()
    {        
        iJugador jugadorBoca6 = new Jugador("Marcos Rojo", 6);
        jugadorBoca6.setPosicion("Defensor");


        Equipo boca = new Equipo("Boca Juniors", "BOC");          
     
        Estadio estadioBombonera = new Estadio("La Bombonera", "Buenos Aires", "Argentina");
       


        PantallaLed pantallaLed = new PantallaLed();


       
        assertEquals("[Jugador 6] Marcos Rojo > Defensor", pantallaLed.imprimir((IImprimible)jugadorBoca6));        
        assertEquals("[Equipo] Boca Juniors > BOC", pantallaLed.imprimir((IImprimible)boca));
        assertEquals("[Estadio] La Bombonera (Buenos Aires - Argentina)", pantallaLed.imprimir((IImprimible)estadioBombonera));
    }

}
