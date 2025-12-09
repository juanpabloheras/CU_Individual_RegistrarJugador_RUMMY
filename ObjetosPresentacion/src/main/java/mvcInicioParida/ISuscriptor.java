
package mvcInicioParida;

/**
 * Interfaz de suscriptor del patrón Observer. Esta clase esta a la escucha de la clase que implementa el publicador.
 * @author Juan Pablo Heras
 */
public interface ISuscriptor {
    
    void actualizar(IModeloInicioPartida modelo);
    
}
