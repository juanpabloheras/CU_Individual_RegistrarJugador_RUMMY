
package comandosSolicitud;

import interfaces.ICommand;

/**
 *
 * Comando que agrega fichas al tablero y al grupo del jugador indicado.
 * 
 * @author pedro
 */
public class ComandoAgregarFichasTableroGrupo implements ICommand {
    private Integer[] idsFichas;
    private Integer[] idsFichasGrupo;
    private final String type = "ComandoAgregarFichasTableroGrupo";
    private String nombreJugador;

    public ComandoAgregarFichasTableroGrupo(Integer[] idFichas, Integer[] idFichasGrupo, String nombreJugador) {
        this.idsFichas = idFichas;
        this.idsFichasGrupo = idFichasGrupo;
        this.nombreJugador = nombreJugador;
    }

    public Integer[] getIdsFichas() {
        return idsFichas;
    }

    public Integer[] getIdsFichasGrupo() {
        return idsFichasGrupo;
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
