
package mvcInicioParida;

import dto.JugadorDTO;
import java.util.List;

/**
 *
 * @author Juan Pablo Heras
 */
public interface IModeloInicioPartida {
    
    
    boolean isJugadorRegistrado();
    
    String obtenerMensaje();

    List<JugadorDTO> cargarJugadores();
}
