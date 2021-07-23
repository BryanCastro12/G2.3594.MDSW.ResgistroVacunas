package ec.edu.espe.registro.utils;

/**
 *
 * @author sigma programers
 */
public interface DBManager extends Persistence {

    boolean openConnection();

    boolean closeConnection(String connection);

}
