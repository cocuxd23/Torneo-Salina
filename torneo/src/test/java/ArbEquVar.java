import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.torneo.Arbitro;
import com.torneo.AsistenteVideo;
import com.torneo.Equipo;
import com.torneo.Estadio;
import com.torneo.Partido;
import com.torneo.Var;

public class ArbEquVar { //Ejercicio 4.7: Árbitros y Equipo del VAR

    @Test
    public void testArbitrosConfiguradosCorrectamente() {
        // Configurar los objetos necesarios para el test
        Equipo boca = new Equipo("Boca Juniors", "BOC");        
        Equipo palmeiras = new Equipo("Palmeiras", "PAL");  
        Estadio estadioBombonera = new Estadio("La Bombonera", "Buenos Aires", "Argentina");
        Partido partido = new Partido(estadioBombonera, boca, palmeiras, "Semifinal Partido Vuelta"); 
        Arbitro arbitro = new Arbitro("Árbitro Principal");
        AsistenteVideo arbitroAsistente = new AsistenteVideo("Asistente de Video");
        Arbitro arbitroLinea1 = new Arbitro("Árbitro de Línea 1");
        Arbitro arbitroLinea2 = new Arbitro("Árbitro de Línea 2");

        // Configurar el objeto Var con los árbitros
        Var var = new Var(partido);
        var.setAsistenteVideo(arbitroAsistente);
        var.setArbitro(arbitro);
        var.setArbitroLinea(List.of(arbitroLinea1, arbitroLinea2));

        // Verificar si los árbitros están configurados correctamente
        assertEquals(arbitro, var.getArbitro());
        assertEquals(arbitroAsistente, var.getAsistenteVideo());
        assertEquals(2, var.getArbitroLinea().size()); // Verificar que haya 2 árbitros de línea
        assertEquals(arbitroLinea1, var.getArbitroLinea().get(0));
        assertEquals(arbitroLinea2, var.getArbitroLinea().get(1));
    }

}
