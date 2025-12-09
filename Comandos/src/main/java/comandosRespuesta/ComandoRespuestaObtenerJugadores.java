
package comandosRespuesta;

import dto.JugadorDTO;
import interfaces.ICommand;
import java.util.List;

/**
 *
 * @author juanpheras
 */
public class ComandoRespuestaObtenerJugadores implements ICommand{
    
    private String nombreJugador;
    private final String type = "ComandoRespuestaObtenerJugadores";
    
    List<JugadorDTO> jugadores;

    public ComandoRespuestaObtenerJugadores(String nombreJugador, List<JugadorDTO> jugadores) {
        this.nombreJugador = nombreJugador;
        this.jugadores = jugadores;
    }

    @Override
    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public List<JugadorDTO> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JugadorDTO> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public String getType() {
        return type;
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
