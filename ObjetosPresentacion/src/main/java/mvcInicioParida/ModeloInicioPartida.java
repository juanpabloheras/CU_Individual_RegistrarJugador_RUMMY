package mvcInicioParida;

import comandoAgregarDireccionJugador.ComandoAgregarDireccionJugador;
import comandoEnvolvente.ComandoEnvolvente;
import comandosRespuesta.ComandoRegistroExitoso;
import comandosRespuesta.ComandoRegistroFallido;
import comandosRespuesta.ComandoRespuestaObtenerJugadores;
import comandosSolicitud.ComandoObtenerJugadores;
import comandosSolicitud.ComandoRegistrarJugador;
import comandosSolicitud.CommandType;
import dto.JugadorDTO;
import interfaces.ICommand;
import interfaces.IFiltro;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que recibe eventos de la vista a través del controlador y regresa
 * mediante el patrón Observer para que la vista se actualice
 *
 * @author Juan Pablo Heras
 */
public class ModeloInicioPartida implements IPublicador, IModeloInicioPartida, IFiltro {

//    private String ipReal;
    
    private String nombreJugador;
    
    Map<Integer, Color> mapaColores;

    List<ISuscriptor> suscriptores = new ArrayList<>();
    List<JugadorDTO> jugadoresRegistrados = new ArrayList<>();

    boolean jugadoRegistrado = false;

    String mensaje;

    IFiltro filtroSiguiente;

    public ModeloInicioPartida() {

    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public Map<Integer, Color> getMapaColores() {
        return mapaColores;
    }

    public void setMapaColores(Map<Integer, Color> mapaColores) {
        this.mapaColores = mapaColores;
    }

    public List<ISuscriptor> getSuscriptores() {
        return suscriptores;
    }

    public void setSuscriptores(List<ISuscriptor> suscriptores) {
        this.suscriptores = suscriptores;
    }

    public boolean isJugadoRegistrado() {
        return jugadoRegistrado;
    }

    public void setJugadoRegistrado(boolean jugadoRegistrado) {
        this.jugadoRegistrado = jugadoRegistrado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public IFiltro getFiltroSiguiente() {
        return filtroSiguiente;
    }

    public void setFiltroSiguiente(IFiltro filtroSiguiente) {
        this.filtroSiguiente = filtroSiguiente;
    }
    
    

    /**
     * Método para añadir a la lista de suscriptores .
     *
     * @param suscriptor clase estará pendiente y se le notificará.
     */
    @Override
    public void suscribirse(ISuscriptor suscriptor) {
        suscriptores.add(suscriptor);
    }

    /**
     * Método para borrar de la lista de suscriptores .
     *
     * @param suscriptor clase a ser borrada
     */
    @Override
    public void desuscribirse(ISuscriptor suscriptor) {
        suscriptores.remove(suscriptor);
    }

    /**
     * Método que llama al método actualizar(IModelo) de todods los suscriptores
     * de la lista.
     */
    @Override
    public void notificar() {
        for (ISuscriptor suscriptor : suscriptores) {
            suscriptor.actualizar(this);
        }
    }

    /**
     * *
     * Método para saber si el estado del jugador esta registrado o no.
     *
     * @return True si el jugador se encuentra ya registrado, false si no.
     */
    @Override
    public boolean isJugadorRegistrado() {
        return jugadoRegistrado;
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
        return mensaje;
    }

    public void obtenerJugadoresRegistrados() {
        ICommand comandoObtenerJugadores = new ComandoObtenerJugadores();
        filtroSiguiente.ejecutar(comandoObtenerJugadores);
    }

    @Override
    public void ejecutar(ICommand comando) {

        CommandType tipoComando = CommandType.fromNombre(comando.getType());

        switch (tipoComando) {

            case CommandType.COMANDO_RESPUESTA_OBTENER_JUGADORES:

                ComandoRespuestaObtenerJugadores comandoObtenerJugadores = (ComandoRespuestaObtenerJugadores) comando;
                this.jugadoresRegistrados = comandoObtenerJugadores.getJugadores();
                break;

            case CommandType.COMANDO_REGISTRO_EXITOSO:

                ComandoRegistroExitoso comandoExito = (ComandoRegistroExitoso) comando;
                this.jugadoRegistrado = true;
                notificar();
                break;

            case CommandType.COMANDO_REGISTRO_FALLIDO:

                ComandoRegistroFallido comandoFallido = (ComandoRegistroFallido) comando;
                this.mensaje = comandoFallido.getMensaje();
                notificar();
                break;

        }
    }

    @Override
    public List<JugadorDTO> cargarJugadores() {
        return jugadoresRegistrados;
    }

    
    /***
     * Método que crea un comando para que un jugador ya unido a la partida(con dirección ip y nobmre registrado) actualice su avatar
     * @param mapaColores mapa de los colores seleccionados por el usuario
     * @param avatar link del avatar que el usuario utilizará.
     */
    public void enviarRegistro(String avatar, Map<Integer, Color> mapaColores) {
        this.setMapaColores(mapaColores);
        ICommand comandoRegistro = new ComandoRegistrarJugador(nombreJugador, avatar);
        filtroSiguiente.ejecutar(comandoRegistro);
    }
//
    
//    Esto ya no se hará ya que al momento de hacer el CU unirse a partida se solicitará el nombre del jugador. 
//    public void enviarRegistro(String nombre, String avatar) {
//        ICommand comandoRegistro = new ComandoRegistrarJugador(nombre, avatar, ipReal, "8085");
//        filtroSiguiente.ejecutar(comandoRegistro);
//    }
//    /**
//     * Método para obtener la IP 
//     * @return 
//     */
//    public static String obtenerIPv4Real() {
//        try {
//            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
//
//            while (interfaces.hasMoreElements()) {
//                NetworkInterface ni = interfaces.nextElement();
//
//                if (!ni.isUp() || ni.isLoopback() || ni.isVirtual()) {
//                    continue;
//                }
//
//                Enumeration<InetAddress> direcciones = ni.getInetAddresses();
//                while (direcciones.hasMoreElements()) {
//                    InetAddress addr = direcciones.nextElement();
//
//                    if (addr instanceof Inet4Address && !addr.isLoopbackAddress()) {
//                        return addr.getHostAddress(); // ← IPv4 real encontrada
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return "0.0.0.0"; // fallback en caso de error
//    }

}
