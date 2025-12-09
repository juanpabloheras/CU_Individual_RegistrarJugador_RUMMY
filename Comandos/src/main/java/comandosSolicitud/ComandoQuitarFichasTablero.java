
package comandosSolicitud;

import interfaces.ICommand;

/**
 *
 * Comando que solicita quitar fichas del tablero y del grupo indicado para un jugador.
 * 
 * @author pedro
 */
public class ComandoQuitarFichasTablero implements ICommand{
    private Integer[] idsFichas;
    private final String type = "ComandoQuitarFichasTablero";
    private String nombreJugador;

    public ComandoQuitarFichasTablero(Integer[] idFichas, String nombreJugador) {
        this.idsFichas = idFichas;
        this.nombreJugador = nombreJugador;
    }

    public Integer[] getIdsFichas() {
        return idsFichas;
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
