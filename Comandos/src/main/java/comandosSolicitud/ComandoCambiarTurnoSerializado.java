
package comandosSolicitud;

import interfaces.ICommand;

/**
 *
 * Comando que indica que el turno debe cambiar al jugador especificado.
 * 
 * @author pedro
 */
public class ComandoCambiarTurnoSerializado implements ICommand{
    private String nombreJugador;
    private final String type = "ComandoCambiarTurnoSerializado";

    public ComandoCambiarTurnoSerializado(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
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
