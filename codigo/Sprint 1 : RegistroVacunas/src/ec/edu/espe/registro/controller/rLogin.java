package ec.edu.espe.registro.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 *
 * @author Bryan Castro
 */
public class rLogin {

    BasicDBObject document = new BasicDBObject();

    public DBObject addUser(String name, String password) {
        document.put("Name", name);
        document.put("Password", password);
        return null;
    }
}
