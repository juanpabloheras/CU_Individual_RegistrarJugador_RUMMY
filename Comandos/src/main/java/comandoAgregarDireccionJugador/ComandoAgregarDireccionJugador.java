
package comandoAgregarDireccionJugador;

import interfaces.ICommand;


public class ComandoAgregarDireccionJugador implements ICommand{
    
    private final String type = "ComandoAgregarDireccionJugador";
    private String[] direccion;
    private String nombreJugador;

    public ComandoAgregarDireccionJugador(String[] direccion, String nombreJugador) {
        this.direccion = direccion;
        this.nombreJugador = nombreJugador;
    }

    @Override
    public String getType() {
        return type;
    }

    public String[] getDireccion() {
        return direccion;
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
