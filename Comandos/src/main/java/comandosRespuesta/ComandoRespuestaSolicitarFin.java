
package comandosRespuesta;

import interfaces.ICommand;


public class ComandoRespuestaSolicitarFin implements ICommand{
    
    private String nombreJugador;
    private final String type = "ComandoRespuestaSolicitarFin";
    private String mensaje;

    public ComandoRespuestaSolicitarFin(String nombreJugador, String mensaje) {
        this.nombreJugador = nombreJugador;
        this.mensaje = mensaje;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public String getMensaje() {
        return mensaje;
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
