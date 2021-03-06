package ec.edu.espe.registro.utils;

import com.mongodb.BasicDBObject;

/**
 *
 * @author Bryan 
 */
public interface Persistence {

    boolean create(String Data, String table, BasicDBObject document);

    String find(String DataBase, String dataToFind, String field, String table);

    boolean update(String DataBase, String dataToFind, String newData, String field, String table);

    boolean delete(String DataBase, String dataToFind, String field, String table);

    String read(String DataBase, String table);

    public boolean create(String toString, String datatxt);

}
