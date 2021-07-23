package ec.edu.espe.registro.controller;

import ec.edu.espe.registro.model.Ususario;
import ec.edu.espe.registro.utils.FileManager;
import ec.edu.espe.registro.utils.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryan Castro
 */
public class CrearUsuario {

    public boolean create(Ususario customer) {
        boolean created = false;
        String personData;

        Persistence persistence;

        persistence = new FileManager();

        if (persistence.create(customer.toString(), "Data.txt")) {
            JOptionPane.showMessageDialog(null, customer + "was saved");
        }
        return created;
    }
}
