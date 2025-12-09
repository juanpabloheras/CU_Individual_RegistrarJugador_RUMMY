
package comandosRespuesta;

import interfaces.ICommand;

/**
 * Comando de respuesta que indica que el tablero es inválido para el jugador.
 * 
 * @author pedro
 */
public class ComandoTableroInvalido implements ICommand {

    private final String type = "ComandoTableroInvalido";
    private String nombreJugador;
    private String mensaje;

    public ComandoTableroInvalido(String nombreJugador, String mensaje) {
        this.nombreJugador = nombreJugador;
        this.mensaje = mensaje;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getNombreJugador() {
        return nombreJugador;
    }

    public String getMensaje() {
        return mensaje;
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
