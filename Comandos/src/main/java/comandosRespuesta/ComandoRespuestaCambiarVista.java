
package comandosRespuesta;

import interfaces.ICommand;
import java.awt.Color;
import java.util.Map;

/**
 *
 * @author juanpheras
 */
public class ComandoRespuestaCambiarVista implements ICommand{
    private String nombreJugador;
    private final String type = "ComandoRespuestaCambiarVista";
    private Map<Integer, Color> mapaColores;

    public ComandoRespuestaCambiarVista(String nombreJugador, Map<Integer, Color> mapaColores) {
        this.nombreJugador = nombreJugador;
        this.mapaColores = mapaColores;
    }

    
    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getNombreJugador() {
        return nombreJugador;
    }

    public Map<Integer, Color> getMapaColores() {
        return mapaColores;
    }

    public void setMapaColores(Map<Integer, Color> mapaColores) {
        this.mapaColores = mapaColores;
    }
    

    @Override
    public void setIP(String ip) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setPORT(int port) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getIP() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getPORT() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
