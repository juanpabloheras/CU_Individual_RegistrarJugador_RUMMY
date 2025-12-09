
package comandosRespuesta;

import dto.TableroDTO;
import interfaces.ICommand;


public class ComandoRespuestaTomarFicha implements ICommand{
    
    private TableroDTO tablero;
    private boolean movimientoValido;
    private final String type = "ComandoRespuestaTomarFicha";
    private String nombreJugador;
    
    public ComandoRespuestaTomarFicha(TableroDTO tablero, boolean movimientoValido, String nombreJugador) {
        this.tablero = tablero;
        this.movimientoValido = movimientoValido;
        this.nombreJugador = nombreJugador;
    }

    public TableroDTO getTablero() {
        return tablero;
    }

    public boolean isMovimientoValido() {
        return movimientoValido;
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
