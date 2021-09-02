package modelo;

public class VacunaDTO {
    private int id;
    private String nombre;
    private int registrado;
    private int disponible;
    private int suministrado;
    
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
        return disponible;
    }

    public void setNumdosis(int numdosis) {
        this.disponible = numdosis;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

    public int getSuministrado() {
        return suministrado;
    }

    public void setSuministrado(int suministrado) {
        this.suministrado = suministrado;
    }

    public int getRegistrado() {
        return registrado;
    }

    public void setRegistrado(int registrado) {
        this.registrado = registrado;
    }
    
}
