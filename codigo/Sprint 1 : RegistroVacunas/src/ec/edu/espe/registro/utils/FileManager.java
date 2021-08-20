package ec.edu.espe.registro.utils;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan Castro
 */
public class FileManager implements Persistence {

    @Override
    public boolean create(String data, String table, BasicDBObject document) {
        boolean saved = false;
        createFile(table);

        try {
            FileWriter writer = new FileWriter(table + ".txt", true);
            writer.write(System.getProperty("line.separator") + data);
            writer.close();
            System.out.println("A new record of " + table + " was saved");
            saved = true;

        } catch (IOException ex) {
            ex.printStackTrace();
            saved = false;
        }

        return saved;

    }

    public boolean createFile(String fileName) {
        boolean created = false;
        try {
            File file = new File(fileName + ".txt");
            if (file.createNewFile()) {
                System.out.println("file was created");
                created = true;
            } else {
                System.out.println("file already exists");
                created = true;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            created = false;
        }

        return created;
    }

    @Override
    public String find(String dataBase, String dataToFind, String field, String table) {
        return null;
    }

    @Override
    public boolean update(String dataBase, String dataToFind, String newData, String field, String table) {
        boolean updated = false;
        String newLine = "";
        Gson gson = new Gson();

        try {
            FileReader readFile = new FileReader("Users.json");
            BufferedReader reader = new BufferedReader(readFile);
            String line;
            while ((line = reader.readLine()) != null) {

                Properties properties = (Properties) gson.fromJson(line, Properties.class);
                Set<String> keys = properties.stringPropertyNames();

                for (String key : keys) {
                    if (dataToFind.equals(properties.getProperty(key))) {
                        properties.setProperty(key, dataToFind);
                        line = gson.toJson(properties);
                        updated = true;
                    }
                }
                newLine = newLine + line + "\n";
            }
            reader.close();
            try ( FileWriter writer = new FileWriter("Users.json")) {
                writer.write(newLine);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return updated;
    }

    @Override
    public boolean delete(String dataBase, String dataToFind, String field, String table) {
        boolean deleted = false;
        boolean ignore = false;
        String newLine = "";
        Gson gson = new Gson();

        try {
            FileReader readFile = new FileReader("Users.json");
            BufferedReader read = new BufferedReader(readFile);
            String line;
            while ((line = read.readLine()) != null) {

                Properties properties = (Properties) gson.fromJson(line, Properties.class);
                Set<String> keys = properties.stringPropertyNames();

                for (String key : keys) {
                    if (dataToFind.equals(properties.getProperty(key))) {

                        ignore = true;
                        deleted = true;
                    }
                }
                if (!ignore) {
                    newLine = newLine + line + "\n";

                }
                ignore = false;
            }
            read.close();
            try ( FileWriter writer = new FileWriter("Users.json")) {
                writer.write(newLine);
                writer.close();

            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return deleted;
    }

    @Override
    public String read(String dataBase, String table) {

        String readLine = "";

        try {
            File file = new File(table);
            if (file.exists()) {
                FileReader reader = new FileReader(file);
                BufferedReader bufferedreader = new BufferedReader(reader);
                readLine = bufferedreader.readLine();
                bufferedreader.close();
            }
        } catch (Exception e) {
            System.out.println("File don't found");
        }
        return readLine;
    }

    @Override
    public boolean create(String toString, String datatxt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
