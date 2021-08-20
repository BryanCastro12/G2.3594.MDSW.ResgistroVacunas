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
    private static final String numDosis = "numDosis";

    private static final String SQL_SELECT_ALL = "Select * from Vacuna";

    private static final String SQL_INSERT = "Insert into Vacuna " + "(" +nombre + "," + numDosis +  ") VALUES (?,?)";

    private static final String SQL_DELETE = "Delete from Vacuna where " + ID + " = ?";
    private static final String SQL_DELETE_ALL = "Delete from Vacuna";

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

    private VacunaDTO getObject(ResultSet rs) throws SQLException {
        VacunaDTO dtoVacuna = new VacunaDTO();

        dtoVacuna.setId(rs.getInt(ID));
        dtoVacuna.setNombre(rs.getString(nombre));
        dtoVacuna.setNumdosis(rs.getInt(numDosis));
        return dtoVacuna;

    }

    public void append(VacunaDTO dto) throws SQLException {
        PreparedStatement ps = null;

        ps = conexion.prepareStatement(SQL_INSERT);

        ps.setString(1, dto.getNombre());
        ps.setInt(2, dto.getNumdosis());

        ps.executeUpdate();
        cerrar(ps);
    }

    public void delete(VacunaDTO dto) throws SQLException {
        PreparedStatement ps = null;
        ps = conexion.prepareStatement(SQL_DELETE);

        ps.setInt(1, dto.getId());

        ps.executeUpdate();
        cerrar(ps);
    }

    public void deleteRFC(String rfc) throws SQLException {
        PreparedStatement ps = null;
        ps = conexion.prepareStatement(SQL_DELETE);

        ps.setString(1, rfc);

        ps.executeUpdate();
        cerrar(ps);
    }

    public void deleteAll(EmpleadoDTO dto) throws SQLException {
        PreparedStatement ps = null;
        ps = conexion.prepareStatement(SQL_DELETE_ALL);
        ps.executeUpdate();
        cerrar(ps);
    }
}
