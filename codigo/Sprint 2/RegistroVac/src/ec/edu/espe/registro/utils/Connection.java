package ec.edu.espe.registro.utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 *
 * @author Bryan 
 */
public class Connection {

    public static MongoClient createConnection() {

        try {
            System.out.println("\nESTABLISHED CONNECTION");
            MongoClientURI uri = new MongoClientURI(
                    "mongodb+srv://Group2:Roberto86@cluster0.z0iiq.mongodb.net/<dbname>?retryWrites=true&w=majority");

            MongoClient mongoClient = new MongoClient(uri);
            return mongoClient;
        } catch (Exception ex) {
            System.out.println("\nCONNECTION REFUSED");
            return null;
        }
    }
}
