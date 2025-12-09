
package comandosRespuesta;

import interfaces.ICommand;

/**
 *
 * @author Juan Heras
 */
public class ComandoRegistroExitoso implements ICommand {
    private final String type = "ComandoRegistroExitoso";
    private String nombreJugador;
    private String IP;
    private Integer PORT;

    public ComandoRegistroExitoso(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }
    
    
    

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getNombreJugador() {
        return nombreJugador;
    }

    @Override
    public String getIP() {
        return IP;
    }

    @Override
    public void setIP(String IP) {
        this.IP = IP;
    }

    @Override
    public void setPORT(int port) {
         this.PORT = port;
    }

    @Override
    public int getPORT() {
        return PORT;
    }
    
    

    
}
