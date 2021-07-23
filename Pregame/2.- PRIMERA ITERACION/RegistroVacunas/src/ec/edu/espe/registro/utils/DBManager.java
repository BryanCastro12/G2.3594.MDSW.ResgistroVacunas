package ec.edu.espe.registro.utils;

/**
 *
 * @author Bryan Castro
 */
public interface DBManager extends Persistence {

    boolean openConnection();

    boolean closeConnection(String connection);

}
