package ec.edu.espe.registro.model;
/**
 *
 * @author Bryan 
 */
public class Person {

    private String name;
    private String lastname;
    private String telephoneNumber;
    private String Email;
    private String ID;

    public Person(String name, String lastname, String telephoneNumber, String Email, String ID) {
        this.name = name;
        this.lastname = lastname;
        this.telephoneNumber = telephoneNumber;
        this.Email = Email;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "name=" + getName() + ",lastName=" + getLastname() + ",telephoneNumber=" + getTelephoneNumber() + ",Email=" + getEmail() + ", ID =" + getID();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * @return the telephoneNumber
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * @param telephoneNumber the telephoneNumber to set
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

}
