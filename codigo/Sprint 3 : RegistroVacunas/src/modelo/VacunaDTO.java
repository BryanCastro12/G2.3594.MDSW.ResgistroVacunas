package modelo;

public class VacunaDTO {
    private int id;
    private String nombre;
    private int numDosis;

    public VacunaDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumdosis() {
        return numDosis;
    }

    public void setNumdosis(int numdosis) {
        this.numDosis = numdosis;
    }
    
}
