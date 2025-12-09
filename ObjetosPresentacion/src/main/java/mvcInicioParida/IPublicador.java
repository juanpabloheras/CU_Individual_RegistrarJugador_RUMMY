package mvcInicioParida;

/**
 * Interfaz de publicador del patrón Observer. Es la clase que noitificará a sus
 * suscriptores cuando algún evento suceda.
 *
 * @author Juan Pablo Heras
 */
public interface IPublicador {

    void suscribirse(ISuscriptor suscriptor);

    void desuscribirse(ISuscriptor suscriptor);

    void notificar();
}
