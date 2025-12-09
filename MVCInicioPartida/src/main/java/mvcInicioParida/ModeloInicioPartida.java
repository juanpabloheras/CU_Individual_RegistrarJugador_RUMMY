package mvcInicioParida;

import comandosRespuesta.ComandoCambioTurno;
import comandosRespuesta.ComandoIniciarTurno;
import comandosSolicitud.CommandType;
import interfaces.ICommand;
import interfaces.IFiltro;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que recibe eventos de la vista a través del controlador y regresa
 * mediante el patrón Observer para que la vista se actualice
 *
 * @author Juan Pablo Heras
 */
public class ModeloInicioPartida implements IPublicador, IModeloInicioPartida, IFiltro {

    List<ISuscriptor> suscriptores = new ArrayList<>();

    boolean jugadorInscrito = false;

    String mensaje;

    /**
     * Método para añadir a la lista de suscriptores .
     *
     * @param suscriptor clase estará pendiente y se le notificará.
     */
    @Override
    public void suscribirse(ISuscriptor suscriptor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Método para borrar de la lista de suscriptores .
     *
     * @param suscriptor clase a ser borrada
     */
    @Override
    public void desuscribirse(ISuscriptor suscriptor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Método que llama al método actualizar(IModelo) de todods los suscriptores
     * de la lista.
     */
    @Override
    public void notificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * *
     * Método para saber si el estado del jugador esta registrado o no.
     *
     * @return True si el jugador se encuentra ya registrado, false si no.
     */
    @Override
    public boolean isJugadorRegistrado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * *
     * Método para obtener el mensaje después de haber intentado registrar el
     * jugador. El mensaje puede ser de exito o indicando el error
     *
     * @return Un string indicando si fue registrado, o indicando el mensaje de
     * error al registrar.
     */
    @Override
    public String obtenerMensaje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    public void enviarRegistro(String nombre, String avatar, Color[] colores){
        
    }
    @Override
    public void ejecutar(ICommand comando) {
        CommandType tipoComando = CommandType.fromNombre(comando.getType());

        
//        switch(tipoComando){
//            case CommandType.INICIAR_TURNO:
//                
//                ComandoIniciarTurno comandoIniciarTurno = (ComandoIniciarTurno) comando;
//                iniciarTurno( 
//                        comandoIniciarTurno.getTablero(), 
//                        comandoIniciarTurno.getMensaje());
//                
//                break;
//                
//            case CommandType.CAMBIO_TURNO:
//                
//                ComandoCambioTurno comandoCambioTurno = (ComandoCambioTurno) comando;
//                cambiarTurno(
//                        comandoCambioTurno.getTablero(),
//                        comandoCambioTurno.getMensaje());
//
//                break;
//        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
