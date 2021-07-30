package ec.edu.espe.registro.model;

/**
 *
 * @author Sigma Programmers
 */
public class Mechanic extends Person {

    String specialty;

    public Mechanic(String specialty, String name, String lastname, String telephoneNumber, String Email, String ID) {
        super(name, lastname, telephoneNumber, Email, ID);
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Mechanic{" + "specialty=" + specialty + '}';
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Mechanic(String name, String lastname, String telephoneNumber, String Email, String ID) {
        super(name, lastname, telephoneNumber, Email, ID);
    }

}
