/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comandosSolicitud;

import interfaces.ICommand;
import java.awt.Color;
import java.util.Map;

/**
 *
 * @author juanpheras
 */
public class ComandoCambiarVista implements ICommand {
    private String nombreJugador;
    private final String type = "ComandoCambiarVista";
    private Map<Integer, Color> mapaColores;

    public ComandoCambiarVista(String nombreJugador, Map<Integer, Color> mapaColores) {
        this.nombreJugador = nombreJugador;
        this.mapaColores = mapaColores;
    }

    public Map<Integer, Color> getMapaColores() {
        return mapaColores;
    }

    public void setMapaColores(Map<Integer, Color> mapaColores) {
        this.mapaColores = mapaColores;
    }
    
    
    

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getNombreJugador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
