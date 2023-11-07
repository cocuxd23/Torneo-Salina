import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.torneo.Arbitro;
import com.torneo.AsistenteVideo;
import com.torneo.AVAR;
import com.torneo.Equipo;
import com.torneo.Estadio;
import com.torneo.IJugador;
import com.torneo.Jugador;
import com.torneo.Partido;
import com.torneo.TarjetaAmarilla;
import com.torneo.TarjetaRoja;
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

     @Test
    public void testVarCantidadDeTarjetas() {
        // Configurar los objetos necesarios para el test
        Equipo boca = new Equipo("Boca Juniors", "BOC");        
        Equipo palmeiras = new Equipo("Palmeiras", "PAL");  
        Estadio estadioBombonera = new Estadio("La Bombonera", "Buenos Aires", "Argentina");
        Partido partido = new Partido(estadioBombonera, boca, palmeiras, "Semifinal Partido Vuelta"); 
        Arbitro arbitro = new Arbitro("Árbitro Principal");
        AsistenteVideo arbitroAsistente = new AsistenteVideo("Asistente de Video");
        Arbitro arbitroLinea1 = new Arbitro("Árbitro de Línea 1");
        Arbitro arbitroLinea2 = new Arbitro("Árbitro de Línea 2");
        
        IJugador jugadorBoca19 = new Jugador("Valentin Barco", 19);
        boca.agregar(jugadorBoca19);
        arbitro.agregarTarjetaAmarilla(jugadorBoca19, partido);
        arbitro.agregarTarjetaAmarilla(jugadorBoca19, partido);
        arbitro.agregarTarjetaRoja(jugadorBoca19, partido);
         
        // Configurar el objeto Var con los árbitros
        Var var = new Var(partido);
        var.setAsistenteVideo(arbitroAsistente);
        var.setArbitro(arbitro);
        var.setArbitroLinea(List.of(arbitroLinea1, arbitroLinea2));

        // Verificar si los árbitros están configurados correctamente
        assertEquals(arbitro, var.getArbitro());
        assertEquals(2, var.cantidadTarjetasAmarillas()); 
        assertEquals(1, var.cantidadTarjetasRojas());    
       
        assertEquals(3, var.cantidadTarjetas(boca));        
        // El arbitro debe asignas una tarjeta a un jugador o vincular 
    }
    @Test
    public void CantidadDeTartjetasEnPartidoTest(){
    Estadio estadio = new Estadio("nombre estadio", "nombre ciudad", "nombre pais");
    Equipo equipoLocal = new Equipo("equipo local", "LOC") ;
    Equipo equipoVisitante = new Equipo("equipo visitante", "VIS") ;
    Arbitro arbitro = new Arbitro("arbitro");
    Arbitro arbitroLinea1 = new Arbitro("arbitro linea 1");
    Arbitro arbitroLinea2 = new Arbitro("arbitro linea 2");
    Arbitro arbitroAsistente = new Arbitro("arbitro asistente");
    List<Arbitro> arbitrosLinea = new ArrayList<>();
    arbitrosLinea.add(arbitroLinea1);
    arbitrosLinea.add(arbitroLinea2);
    Partido partido = new Partido(estadio, equipoLocal, equipoVisitante, "nombre partido", arbitro, arbitrosLinea, arbitroAsistente);

    assertEquals(estadio, partido.getEstadio());
    assertEquals(equipoLocal, partido.getEquipoLocal());
    assertEquals(equipoVisitante, partido.getEquipoVisitante());
    assertEquals(arbitro, partido.getArbitro());
    assertEquals(arbitrosLinea, partido.getArbitroLinea());
    assertEquals(arbitroAsistente, partido.getArbitroAsistente());
    
    AsistenteVideo asistenteDeVideo = new AsistenteVideo("asistente de video");
    AVAR aVar1 = new AVAR("aVAR1");
    AVAR aVar2 = new AVAR("aVAR2");
    AVAR aVar3 = new AVAR("aVAR3");
    Var var = new Var(partido, asistenteDeVideo, aVar1, aVar2, aVar3);

    IJugador jugador = new Jugador("jugador", 1);
    equipoLocal.agregar(jugador);
    TarjetaAmarilla tarjetaAmarilla1 = new TarjetaAmarilla(jugador);
    TarjetaAmarilla tarjetaAmarilla2 = new TarjetaAmarilla(jugador);
    TarjetaRoja tarjetaRoja = new TarjetaRoja(jugador);
    partido.agregar(tarjetaAmarilla1);
    partido.agregar(tarjetaAmarilla2);
    partido.agregar(tarjetaRoja);

    assertEquals(2, var.cantidadTarjetasAmarillas());
    assertEquals(1, var.cantidadTarjetasRojas());
    assertEquals(3, var.cantidadTarjetas(equipoLocal));
    }

}
