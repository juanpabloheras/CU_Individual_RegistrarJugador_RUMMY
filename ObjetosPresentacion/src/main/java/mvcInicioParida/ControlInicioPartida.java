
package mvcInicioParida;

import java.awt.Color;
import java.util.Map;

/**
 *
 * @author juanpheras
 */
public class ControlInicioPartida {
    private ModeloInicioPartida modelo;

    public ControlInicioPartida(ModeloInicioPartida modelo) {
        this.modelo = modelo;
    }
    
    
    
    public void enviarRegistro(String avatar, Map<Integer,Color> mapaColores){
        modelo.enviarRegistro(avatar, mapaColores);
    }
    
}
