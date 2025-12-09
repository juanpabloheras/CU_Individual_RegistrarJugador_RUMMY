
package comandosRespuesta;

import interfaces.ICommand;


public class ComandoJugadorPartidaGanada implements ICommand{
    
    private String type = "ComandoJugadorPartidaGanada";
    private String nombreJugador;
    private String mensaje;

    public ComandoJugadorPartidaGanada(String nombreJugador, String mensaje) {
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
