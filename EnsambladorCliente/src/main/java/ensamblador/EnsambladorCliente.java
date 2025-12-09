package ensamblador;

import cliente.ColaMensajesEnviar;
import cliente.GestorConexiones;
import com.formdev.flatlaf.FlatIntelliJLaf;
import deserializador.Deserializador;
import directorioServidor.DirectorioServidor;
import ejercerTurno.Controlador;
import ejercerTurno.IReceptorEventos;
import ejercerTurno.Modelo;
import ejercerTurno.VistaMesaJuego;
import fachadaMVCs.Fachada;
import mvcInicioParida.ControlInicioPartida;
import mvcInicioParida.ModeloInicioPartida;
import mvcInicioParida.VistaRegistrarJugador;
import interfaces.ISuscriptor;
import java.awt.Color;
import java.util.*;
import java.util.Scanner;
import objetosPresentacion.*;
import serializador.Serializador;
import servidor.ColaMensajesRecibidos;
import servidor.Servidor;

public class EnsambladorCliente {

    private static final int TOTAL_CASILLAS_TABLERO = 500;
    private static final int TOTAL_CASILLAS_MANO = 14;

    // ==================================================
    // MÉTODO PARA CREAR LA MESA (SOLO UNA VEZ)
    // ==================================================
    private static VistaMesaJuego construirMesaDeJuego(
            Controlador controladorMesa,
            Modelo modeloMesa,
            String nombreJugador2,
            String direccionAvatar2
    ) {

        PanelCasilla[] panelesCasillaTablero = new PanelCasilla[TOTAL_CASILLAS_TABLERO];
        for (int i = 0; i < TOTAL_CASILLAS_TABLERO; i++) {
            panelesCasillaTablero[i] = new PanelCasilla(i + 1);
        }

        IComponente panelTablero = new PanelTablero(panelesCasillaTablero);

        List<PanelCasilla> panelesCasillaJugador = new LinkedList<>();
        for (int i = 0; i < TOTAL_CASILLAS_MANO; i++) {
            panelesCasillaJugador.add(new PanelCasilla(i + 1));
        }

        IComponente panelJugadorPrincipal = new PanelJugadorPrincipal(panelesCasillaJugador);

        IComponente panelJugadorExterno1 = new PanelJugadorExterno(
                PosicionPanel.CENTRO_ARRIBA,
                nombreJugador2,
                direccionAvatar2
        );

        IComponente panelMesaJuego = new PanelMesaJuego();
        IComponente panelMonton = new PanelMonton();
        panelMesaJuego.agregarComponente(panelMonton);
        panelMesaJuego.agregarComponente(panelTablero);
        panelMesaJuego.agregarComponente(panelJugadorExterno1);
        panelMesaJuego.agregarComponente(panelJugadorPrincipal);

        Map<Integer, Integer> mapaIdsCasillasPanelesTablero = new HashMap<>();
        for (int i = 1; i <= TOTAL_CASILLAS_TABLERO; i++) {
            mapaIdsCasillasPanelesTablero.put(i, null);
        }

        Map<Integer, Integer> mapaIdsCasillasPanelesJugador = new HashMap<>();

        IComponente panelMovimiento = new PanelMovimiento();

        Map<Integer, Color> coloresDummy = Map.of(
                1, Color.RED,
                2, Color.BLUE,
                3, Color.GREEN,
                4, Color.DARK_GRAY
        );

        VistaMesaJuego vistaMesa = new VistaMesaJuego(
                controladorMesa,
                panelMesaJuego,
                panelMovimiento,
                coloresDummy,
                mapaIdsCasillasPanelesTablero,
                mapaIdsCasillasPanelesJugador
        );

        modeloMesa.suscribirse(vistaMesa);

        IGestorEventos gestorEventos = new GestorEventos(vistaMesa, (IReceptorEventos) vistaMesa);
        ((PanelMesaJuego) panelMesaJuego).setGestorEventos(gestorEventos);
        ((PanelTablero) panelTablero).setGestorEventos(gestorEventos);
        ((PanelJugadorPrincipal) panelJugadorPrincipal).setGestorEventos(gestorEventos);
        ((PanelMonton) panelMonton).setGestorEventos(gestorEventos);
        ((PanelMovimiento) panelMovimiento).setGestorEventos(gestorEventos);

        return vistaMesa;
    }

    // ==================================================
    // MAIN
    // ==================================================
    public static void main(String[] args) {

        try {
            FlatIntelliJLaf.setup();
        } catch (Exception e) {
        }

        Scanner escaner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del Jugador: ");
        String nombreJugador = escaner.nextLine();

        String ipServidor = "127.0.0.1";
        String puertoCliente;

        String nombreJugador2 = "a";
        String direccionImagenAvatarJugador2 = "avatar4.png";

        if (nombreJugador.equals("Francisco34")) {
            puertoCliente = "51000";
            nombreJugador2 = "Sandy43";
            direccionImagenAvatarJugador2 = "avatar2.png";
        } else if (nombreJugador.equals("Sandy43")) {
            puertoCliente = "52000";
            nombreJugador2 = "Francisco34";
            direccionImagenAvatarJugador2 = "avatar1.png";
        } else {
            puertoCliente = "53000"; // JuanH u otros
        }

        // ==========================
        // 1. MODELOS
        // ==========================
        ModeloInicioPartida modeloInicio = new ModeloInicioPartida();
        ControlInicioPartida controlInicio = new ControlInicioPartida(modeloInicio);

        Modelo modeloMesa = new Modelo(nombreJugador);
        Controlador controladorMesa = new Controlador(modeloMesa);

        // ==========================
        // 2. CONSTRUIR RED
        // ==========================
        Serializador serializadorCliente = new Serializador();
        Deserializador deserializadorCliente = new Deserializador();
        DirectorioServidor directorioServidor = new DirectorioServidor(new String[]{ipServidor, "50000"});

        ISuscriptor gestorConexiones = new GestorConexiones();

        ColaMensajesEnviar colaMensajesEnviar = new ColaMensajesEnviar();
        colaMensajesEnviar.setSuscriptor(gestorConexiones);
        new Thread(colaMensajesEnviar).start();

        ColaMensajesRecibidos colaMensajesRecibidos = new ColaMensajesRecibidos();
        Servidor servidor = new Servidor(Integer.valueOf(puertoCliente));
        servidor.setReceptor(colaMensajesRecibidos);

        new Thread(servidor).start();
        new Thread(colaMensajesRecibidos).start();

        modeloInicio.setFiltroSiguiente(serializadorCliente);
        modeloMesa.setFiltroEnvioMensaje(serializadorCliente);

        serializadorCliente.setFiltroSiguiente(directorioServidor);
        directorioServidor.setDispatcher(colaMensajesEnviar);

        colaMensajesRecibidos.setReceptor(deserializadorCliente);

        Fachada fachadaMVC = new Fachada();
        fachadaMVC.setModeloInicio(modeloInicio);
        fachadaMVC.setModeloJuego(modeloMesa);

        deserializadorCliente.setFiltroSiguiente(fachadaMVC);

        // ==========================
        // 3. CREAR LA VISTA DE MESA (OCULTA)
        // ==========================
        VistaMesaJuego vistaMesaJuego = construirMesaDeJuego(
                controladorMesa,
                modeloMesa,
                nombreJugador2,
                direccionImagenAvatarJugador2
        );

        vistaMesaJuego.setVisible(false);

        // ==========================
        // 4. SI ES JUANH → ABRIR REGISTRO
        // ==========================
        if (nombreJugador.equals("JuanH")) {
            VistaRegistrarJugador vistaReg = new VistaRegistrarJugador(controlInicio);
            modeloInicio.suscribirse(vistaReg);
            vistaReg.setVisible(true);
        }

        // ==========================
        // 5. SI ES OTRO → ABRIR DIRECTO LA MESA
        // ==========================
        if (!nombreJugador.equals("JuanH")) {
            vistaMesaJuego.setVisible(true);
        }
    }
}
