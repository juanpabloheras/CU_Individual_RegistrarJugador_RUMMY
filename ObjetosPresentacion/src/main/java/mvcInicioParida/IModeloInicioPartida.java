
package mvcInicioParida;

import dto.JugadorDTO;
import java.awt.Color;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Juan Pablo Heras
 */
public interface IModeloInicioPartida {
    
    
    boolean isJugadorRegistrado();
    
    String obtenerMensaje();

    List<JugadorDTO> cargarJugadores();
    
    Map<Integer, Color> getMapaColores();
    
    String obtenerNombreJugador();
}
