package objetos_negocio;

import comandosRespuesta.ComandoRegistroExitoso;
import comandosRespuesta.ComandoRegistroFallido;
import comandosRespuesta.ComandoRespuestaCambiarVista;
import comandosSolicitud.ComandoAbandonar;
import comandosSolicitud.ComandoAgregarFichasJugador;
import comandosSolicitud.ComandoAgregarFichasTablero;
import comandosSolicitud.ComandoAgregarFichasTableroGrupo;
import comandosSolicitud.ComandoCambiarVista;
import comandosSolicitud.ComandoConfirmacionAbandonar;
import comandosSolicitud.ComandoConfirmacionSolicitarFin;
import comandosSolicitud.ComandoQuitarFichasJugador;
import comandosSolicitud.ComandoQuitarFichasTablero;
import comandosSolicitud.ComandoReestablecerTablero;
import comandosSolicitud.ComandoRegistrarJugador;
import comandosSolicitud.ComandoSeleccionarFichasTablero;
import comandosSolicitud.ComandoSolicitarFin;
import comandosSolicitud.ComandoTerminarTurno;
import comandosSolicitud.ComandoTomarFicha;
import comandosSolicitud.CommandType;
import excepciones.RummyException;
import interfaces.ICommand;

/**
 *
 */
public class Partida {

    private Tablero tablero;
    private FachadaObjetosNegocio filtroSiguiente;

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public void ejecutar(ICommand comando) throws RummyException {

        CommandType tipoComando = CommandType.fromNombre(comando.getType());

        switch (tipoComando) {

            case CommandType.SELECCIONAR_FICHAS_TABLERO:

                ComandoSeleccionarFichasTablero comandoSeleccionarFichasTablero = (ComandoSeleccionarFichasTablero) comando;

                tablero.seleccionarFichasTablero(
                        comandoSeleccionarFichasTablero.getIdsFichas(),
                        comandoSeleccionarFichasTablero.getNombreJugador()
                );

                break;

            case CommandType.AGREGAR_FICHAS_TABLERO:

                ComandoAgregarFichasTablero comandoAgregarFichasTablero = (ComandoAgregarFichasTablero) comando;

                tablero.agregarFichasTablero(
                        comandoAgregarFichasTablero.getIdsFichas(),
                        comandoAgregarFichasTablero.getNombreJugador()
                );

                break;

            case CommandType.AGREGAR_FICHAS_JUGADOR:

                ComandoAgregarFichasJugador comandoAgregarFichasJugador = (ComandoAgregarFichasJugador) comando;

                tablero.agregarFichasJugador(
                        comandoAgregarFichasJugador.getIdsFichas(),
                        comandoAgregarFichasJugador.getNombreJugador()
                );

                break;

            case CommandType.AGREGAR_FICHAS_TABLERO_GRUPO:

                ComandoAgregarFichasTableroGrupo comandoAgregarFichasTableroGrupo = (ComandoAgregarFichasTableroGrupo) comando;

                tablero.agregarFichasTableroGrupos(
                        comandoAgregarFichasTableroGrupo.getIdsFichas(),
                        comandoAgregarFichasTableroGrupo.getIdsFichasGrupo(),
                        comandoAgregarFichasTableroGrupo.getNombreJugador());

                break;

            case CommandType.QUITAR_FICHAS_JUGADOR:

                ComandoQuitarFichasJugador comandoQuitarFichasJugador = (ComandoQuitarFichasJugador) comando;

                tablero.quitarFichasJugador(
                        comandoQuitarFichasJugador.getIdsFichas(),
                        comandoQuitarFichasJugador.getNombreJugador());

                break;

            case CommandType.QUITAR_FICHAS_TABLERO:

                ComandoQuitarFichasTablero comandoQuitarFichasTablero = (ComandoQuitarFichasTablero) comando;

                tablero.quitarFichasTablero(
                        comandoQuitarFichasTablero.getIdsFichas(),
                        comandoQuitarFichasTablero.getNombreJugador());

                break;

            case CommandType.TOMAR_FICHA:

                ComandoTomarFicha comandoTomarFicha = (ComandoTomarFicha) comando;

                tablero.tomarFicha(comandoTomarFicha.getNombreJugador());

                break;

            case CommandType.RESTABLECER_TABLERO:

                ComandoReestablecerTablero comandoReestablecerTablero = (ComandoReestablecerTablero) comando;

                tablero.reestablecerTablero(comandoReestablecerTablero.getNombreJugador());

                break;

            case CommandType.TERMINAR_TURNO:

                ComandoTerminarTurno comandoTerminarTurno = (ComandoTerminarTurno) comando;

                tablero.terminarTurno(comandoTerminarTurno.getNombreJugador());

                break;

            case CommandType.COMANDO_ABANDONAR:

                ComandoAbandonar comandoAbandonar = (ComandoAbandonar) comando;

                tablero.solicitarAbandono(comandoAbandonar.getNombreJugador());

                break;

            case CommandType.COMANDO_CONFIRMACION_ABANDONAR:

                ComandoConfirmacionAbandonar comandoConfirmacionAbandonar = (ComandoConfirmacionAbandonar) comando;

                tablero.confirmarAbandono(
                        comandoConfirmacionAbandonar.getNombreJugador(),
                        comandoConfirmacionAbandonar.isConfirmacion());

                break;

            case CommandType.COMANDO_SOLICITAR_FIN:

                ComandoSolicitarFin comandoSolicitarFin = (ComandoSolicitarFin) comando;

                tablero.solicitarFin(comandoSolicitarFin.getNombreJugador());

                break;

            case CommandType.COMANDO_CONFIRMACION_SOLICITAR_FIN:

                ComandoConfirmacionSolicitarFin comandoConfirmacionSolicitarFin = (ComandoConfirmacionSolicitarFin) comando;

                tablero.confirmarSolicitarFin(
                        comandoConfirmacionSolicitarFin.getNombreJugador(),
                        comandoConfirmacionSolicitarFin.isConfirmacion());

                break;

            case CommandType.COMANDO_REGISTRAR_JUGADOR:

                ComandoRegistrarJugador comandoRegistrarJugador = (ComandoRegistrarJugador) comando;

                if (validarRegistroJugadores(comandoRegistrarJugador.getAvatar())) {
                    actualizarJugador(comandoRegistrarJugador.getNombreJugador(), comandoRegistrarJugador.getAvatar());
                    ICommand comandoRespuesta = new ComandoRegistroExitoso(comandoRegistrarJugador.getNombreJugador());
                    filtroSiguiente.enviarComando(comandoRespuesta);
                } else {
                    ICommand comandoRespuesta = new ComandoRegistroFallido(comandoRegistrarJugador.getNombreJugador(), "El avatar seleccionado ya está en uso");
                    filtroSiguiente.enviarComando(comandoRespuesta);
                }
                  
            case CommandType.COMANDO_CAMBIAR_VISTA:
                ComandoCambiarVista comandoCambiarVista = (ComandoCambiarVista) comando;
                ICommand comandoRespuesta = new ComandoRespuestaCambiarVista(comandoCambiarVista.getNombreJugador(), comandoCambiarVista.getMapaColores());
                filtroSiguiente.enviarComando(comandoRespuesta);
                break;

            default:
                throw new AssertionError();
        }

    }

    private void actualizarJugador(String nombre, String avatar) {
        for (Jugador jugador : tablero.getJugadores()) {
            if (jugador.getNombre().equals(nombre)) {
                jugador.setAvatar(avatar);
            }
        }
    }

    private boolean validarRegistroJugadores(String avatar) {

        // Validar que Tablero exista
        if (tablero == null) {
            return false;
        }

        // Recorrer jugadores ya creados en el tablero
        for (Jugador jugador : tablero.getJugadores()) {

            if (jugador.getAvatar() == null) {
                continue;
            }
            // Validar avatar repetido
            if (jugador.getAvatar().equalsIgnoreCase(avatar)) {
                return false;
            }
        }

        return true; 
    }
}
