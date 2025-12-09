/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachadaMVCs;

import comandosRespuesta.ComandoCambioTurno;
import comandosRespuesta.ComandoFinPartida;
import comandosRespuesta.ComandoIniciarTurno;
import comandosRespuesta.ComandoJugadorAbandonoPartida;
import comandosRespuesta.ComandoJugadorPartidaGanada;
import comandosRespuesta.ComandoPartidaGanada;
import comandosRespuesta.ComandoRegistroExitoso;
import comandosRespuesta.ComandoRegistroFallido;
import comandosRespuesta.ComandoRespuestaAbandonar;
import comandosRespuesta.ComandoRespuestaConfirmacionSolicitarFin;
import comandosRespuesta.ComandoRespuestaMovimiento;
import comandosRespuesta.ComandoRespuestaObtenerJugadores;
import comandosRespuesta.ComandoRespuestaReestablecer;
import comandosRespuesta.ComandoRespuestaSolicitarFin;
import comandosRespuesta.ComandoRespuestaTomarFicha;
import comandosRespuesta.ComandoTableroInvalido;
import comandosSolicitud.CommandType;
import ejercerTurno.Modelo;
import interfaces.ICommand;
import interfaces.IFiltro;
import mvcInicioParida.ModeloInicioPartida;

/**
 *
 * @author juanpheras
 */
public class Fachada implements IFiltro {

    ModeloInicioPartida modeloInicio;
    Modelo modeloJuego;

    public ModeloInicioPartida getModeloInicio() {
        return modeloInicio;
    }

    public void setModeloInicio(ModeloInicioPartida modeloInicio) {
        this.modeloInicio = modeloInicio;
    }

    public Modelo getModeloJuego() {
        return modeloJuego;
    }

    public void setModeloJuego(Modelo modeloJuego) {
        this.modeloJuego = modeloJuego;
    }
    
    @Override
    public void ejecutar(ICommand comando) {
         CommandType tipoComando = CommandType.fromNombre(comando.getType());
        
        switch (tipoComando) {
            case CommandType.INICIAR_TURNO:
                
                ComandoIniciarTurno comandoIniciarTurno = (ComandoIniciarTurno) comando;
                modeloJuego.ejecutar(comando);
                
                break;
                
            case CommandType.CAMBIO_TURNO:
                
                ComandoCambioTurno comandoCambioTurno = (ComandoCambioTurno) comando;
                modeloJuego.ejecutar(comando);

                break;
                
            case CommandType.RESPUESTA_MOVIMIENTO:
                
                ComandoRespuestaMovimiento comandoRespuestaMovimiento = (ComandoRespuestaMovimiento) comando;
                
                modeloJuego.ejecutar(comando);
                
                break;
                
            case CommandType.COMANDO_TABLERO_INVALIDO:
                
                ComandoTableroInvalido comandoTableroInvalido = (ComandoTableroInvalido) comando;
                                
               modeloJuego.ejecutar(comando);
                
                break;
                
            case CommandType.RESPUESTA_TOMAR_FICHA:
                
                ComandoRespuestaTomarFicha comandoRespuestaTomarFicha = (ComandoRespuestaTomarFicha) comando;
                
                modeloJuego.ejecutar(comando);

                break;
                
            case CommandType.RESPUESTA_REESTABLECER:
                
                ComandoRespuestaReestablecer comandoRespuestaReestablecer = (ComandoRespuestaReestablecer) comando;
                
                modeloJuego.ejecutar(comando);

                break;
                
                
            case CommandType.COMANDO_RESPUESTA_ABANDONAR:
                
                ComandoRespuestaAbandonar comandoRespuestaAbandonar = (ComandoRespuestaAbandonar) comando;
                
                modeloJuego.ejecutar(comando);
                
                break;
                 
            case CommandType.COMANDO_JUGADOR_ABANDONO:
                
                ComandoJugadorAbandonoPartida comandoJugadorAbandonoPartida = (ComandoJugadorAbandonoPartida) comando;
                
                modeloJuego.ejecutar(comando);
                
                break;
                
            case CommandType.COMANDO_RESPUESTA_SOLICITAR_FIN:
                
                ComandoRespuestaSolicitarFin comandoRespuestaSolicitarFin = (ComandoRespuestaSolicitarFin) comando;
                                
               modeloJuego.ejecutar(comando);
                
                break;
                
            case CommandType.COMANDO_RESPUESTA_CONFIRMACION_SOLICITAR_FIN:
                
                ComandoRespuestaConfirmacionSolicitarFin comandoRespuestaConfirmacionSolicitarFin = (ComandoRespuestaConfirmacionSolicitarFin) comando;
                
                modeloJuego.ejecutar(comando);
                
                break;
                
            case CommandType.COMANDO_FIN_PARTIDA:
                
                ComandoFinPartida comandoFinPartida = (ComandoFinPartida) comando;
                
                modeloJuego.ejecutar(comando);
                
                break;
                
            case CommandType.COMANDO_PARTIDA_GANADA:
                
                ComandoPartidaGanada comandoPartidaGanada = (ComandoPartidaGanada) comando;
                
                modeloJuego.ejecutar(comando);
                 
                break;
                
            case CommandType.COMANDO_JUGADOR_PARTIDA_GANADA:
                
                ComandoJugadorPartidaGanada comandoJugadorPartidaGanada = (ComandoJugadorPartidaGanada) comando;
                
                modeloJuego.ejecutar(comando);
                 
                break;

            case CommandType.COMANDO_RESPUESTA_OBTENER_JUGADORES:

                modeloInicio.ejecutar(comando);
                break;

            case CommandType.COMANDO_REGISTRO_EXITOSO:

                modeloInicio.ejecutar(comando);
                break;

            case CommandType.COMANDO_REGISTRO_FALLIDO:

                modeloInicio.ejecutar(comando);
                break;
    
            case CommandType.COMANDO_RESPUESTA_CAMBIAR_VISTA:
                modeloJuego.ejecutar(comando);
                
            default:
                throw new AssertionError();
        }
    }
    
}
