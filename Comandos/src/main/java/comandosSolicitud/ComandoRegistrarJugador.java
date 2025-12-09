
package comandosSolicitud;

import interfaces.ICommand;

/**
 *
 * @author Juan Heras
 */
public class ComandoRegistrarJugador implements ICommand{
    
    private final String type = "ComandoRegistrarJugador";
    private String nombreJugador;
    private String avatar;
    private String IP;
    private String PORT;

    public ComandoRegistrarJugador(String nombreJugador, String avatar) {
        this.nombreJugador = nombreJugador;
        this.avatar = avatar;
    }

    
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

  

    
    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getNombreJugador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    @Override
    public void setPORT(int port) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getPORT() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
    
}
