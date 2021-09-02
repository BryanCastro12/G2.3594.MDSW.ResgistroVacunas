package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.EmpleadoDTO;
import modelo.VacunaDTO;

public class VacunaDAO extends ConexionBD {

    private static final String ID = "id";
    private static final String nombre = "nombre";
    private static final String registrado = "registrado";
    private static final String numDosis = "numDosis";
    private static final String suministrado = "suministrado";

    private static final String SQL_SELECT_ALL = "Select * from Vacuna";
    private static final String SQL_SEARCH = "Select * from Vacuna where " + nombre + "= ?";

    private static final String SQL_INSERT = "Insert into Vacuna " + "(" + nombre +","+ registrado + "," + numDosis + "," + suministrado + ") VALUES (?,?,?,?)";

    private static final String SQL_DELETE = "Delete from Vacuna where " + ID + " = ?";
    private static final String SQL_DELETE_ALL = "Delete from Vacuna";
    private static final String SQL_UPDATE = "Update Vacuna set " + numDosis + " = ? ," + suministrado + " = ? where " + nombre + " = ?";

    public VacunaDAO() {
        super();
    }

    public List readALL() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List result = new ArrayList();

        ps = conexion.prepareCall(SQL_SELECT_ALL);

        rs = ps.executeQuery();

        while (rs.next()) {
            result.add(getObject(rs));
        }
        cerrar(ps);
        cerrar(rs);
        return result;

    }

    public VacunaDTO search(String nombre) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        VacunaDTO dto = null;

        ps = conexion.prepareCall(SQL_SEARCH);
        ps.setString(1, nombre);
        rs = ps.executeQuery();

        while (rs.next()) {
            dto = new VacunaDTO();
            dto = getObject(rs);
        }
        cerrar(ps);
        cerrar(rs);
        return dto;

    }

    private VacunaDTO getObject(ResultSet rs) throws SQLException {
        VacunaDTO dtoVacuna = new VacunaDTO();

        dtoVacuna.setId(rs.getInt(ID));
        dtoVacuna.setNombre(rs.getString(nombre));
        dtoVacuna.setRegistrado(rs.getInt(registrado));
        dtoVacuna.setNumdosis(rs.getInt(numDosis));
        dtoVacuna.setSuministrado(rs.getInt(suministrado));
        return dtoVacuna;

    }

    public void append(VacunaDTO dto) throws SQLException {
        PreparedStatement ps = null;

        ps = conexion.prepareStatement(SQL_INSERT);

        ps.setString(1, dto.getNombre());
        ps.setInt(2, dto.getRegistrado());
        ps.setInt(3, dto.getRegistrado());
        ps.setInt(4, 0);

        ps.executeUpdate();
        cerrar(ps);
    }

    public void delete(int ID) throws SQLException {
        PreparedStatement ps = null;
        ps = conexion.prepareStatement(SQL_DELETE);

        ps.setInt(1, ID);

        ps.executeUpdate();
        cerrar(ps);
    }

    public void deleteAll() throws SQLException {
        PreparedStatement ps = null;
        ps = conexion.prepareStatement(SQL_DELETE_ALL);
        ps.executeUpdate();
        cerrar(ps);
    }

    public void update(VacunaDTO dto) throws SQLException {
        PreparedStatement ps = null;

        ps = conexion.prepareStatement(SQL_UPDATE);

        ps.setInt(1, dto.getNumdosis() - 1);
        ps.setInt(2, dto.getSuministrado() + 1);
        ps.setString(3, dto.getNombre());

        ps.executeUpdate();
        cerrar(ps);
    }
}
