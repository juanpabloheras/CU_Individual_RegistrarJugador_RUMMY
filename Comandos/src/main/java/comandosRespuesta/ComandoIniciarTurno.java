
package comandosRespuesta;

import comandosSolicitud.CommandType;
import dto.TableroDTO;
import interfaces.ICommand;

/**
 * Comando de respuesta que indica que inicia el turno del jugador. 
 * 
 * @author pedro
 */
public class ComandoIniciarTurno implements ICommand{
    
    private final String type = "ComandoIniciarTurno";
    private String nombreJugador;
    private TableroDTO tablero;
    private String mensaje;
    
    public ComandoIniciarTurno(TableroDTO tablero, String nombreJugador, String mensaje) {
        this.tablero = tablero;
        this.nombreJugador = nombreJugador;
        this.mensaje = mensaje;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    @Override
    public String getNombreJugador() {
        return nombreJugador;
    }

    public TableroDTO getTablero() {
        return tablero;
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
