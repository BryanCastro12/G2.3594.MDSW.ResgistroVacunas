package ec.edu.espe.registro.controller;

/**
 *
 * @author Bryan 
 */
public class Verification {


    private String user;
    private String password;
    private String CI;

    public Verification(String user, String password) {
        this.user = user;
        this.password = password;
        this.CI = CI;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the CI
     */
    public String getCI() {
        return CI;
    }

    /**
     * @param CI the CI to set
     */
    public void setCI(String CI) {
        this.CI = CI;
    }

}
