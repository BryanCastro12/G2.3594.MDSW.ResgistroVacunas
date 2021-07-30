package ec.edu.espe.registro.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 *
 * @author Sigma Programmers
 */
public class EmployeeController {

    BasicDBObject document = new BasicDBObject();

    public DBObject addVehicle(int Name, String LastName,int CI, String Phone, String Code) {

        document.put("Name", Name);
        document.put("LastName", LastName);
        document.put("CI", CI);
        document.put("Phone", Phone);
        document.put("Code", Code);

        return null;
    }
}
