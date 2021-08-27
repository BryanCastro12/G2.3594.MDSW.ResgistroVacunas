package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.DosisDTO;

public class DosisDAO extends ConexionBD {

    private static final String ID = "id";
    private static final String nombre = "nombrePersona";
    private static final String cedula = "cedula";
    private static final String edad = "edad";
    private static final String correo = "correo";
    private static final String telefono = "telefono";
    private static final String vacuna = "vacuna";
    private static final String numDosis = "numDosis";
    private static final String fecha_inicio = "fecha";

    private static final String SQL_SELECT_ALL = "Select * from Dosis";

    private static final String SQL_INSERT = "Insert into Dosis " + "(" + nombre + "," + cedula + "," + edad + "," + correo + "," + telefono + "," + vacuna + "," + numDosis
            + "," + fecha_inicio + ") VALUES (?,?,?,?,?,?,?,?)";

    private static final String SQL_UPDATE = "Update Dosis set " + nombre + " = ?,"
            + cedula + " = ?," + edad + " = ?," + correo + " = ?," + telefono + " = ?," + vacuna + " = ?," + numDosis + " = ?," + fecha_inicio + " = ? where " + ID + " = ?";

    private static final String SQL_DELETE = "Delete from Dosis where " + ID + "=?";
    private static final String SQL_DELETE_ALL = "Delete from Dosis";

    public DosisDAO() {
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

    private DosisDTO getObject(ResultSet rs) throws SQLException {
        DosisDTO dtoDosis = new DosisDTO();

        dtoDosis.setId(rs.getInt(ID));
        dtoDosis.setNombrePersona(rs.getString(nombre));
        dtoDosis.setCedula(rs.getString(cedula));
        dtoDosis.setEdad(rs.getInt(edad));
        dtoDosis.setCorreo(rs.getString(correo));
        dtoDosis.setTelefono(rs.getString(telefono));
        dtoDosis.setVacuna(rs.getString(vacuna));
        dtoDosis.setNumDosis(rs.getInt(numDosis));
        dtoDosis.setFecha(rs.getString(fecha_inicio));
        return dtoDosis;

    }

    public void append(DosisDTO dto) throws SQLException {
        PreparedStatement ps = null;

        ps = conexion.prepareStatement(SQL_INSERT);

        ps.setString(1, dto.getNombrePersona());
        ps.setString(2, dto.getCedula());
        ps.setInt(3, dto.getEdad());
        ps.setString(4, dto.getCorreo());
        ps.setString(5, dto.getTelefono());
        ps.setString(6, dto.getVacuna());
        ps.setInt(7, dto.getNumDosis());
        ps.setString(8, dto.getFecha());

        ps.executeUpdate();
        cerrar(ps);
    }

    public void update(DosisDTO dto) throws SQLException {

        PreparedStatement ps = null;

        ps = conexion.prepareStatement(SQL_UPDATE);

        ps.setString(1, dto.getNombrePersona());
        ps.setString(2, dto.getCedula());
        ps.setInt(3, dto.getEdad());
        ps.setString(4, dto.getCorreo());
        ps.setString(5, dto.getTelefono());
        ps.setString(6, dto.getVacuna());
        ps.setInt(7, dto.getNumDosis());
        ps.setString(8, dto.getFecha());
        ps.setInt(9, dto.getId());

        ps.executeUpdate();
        cerrar(ps);
    }

    public void delete(int id) throws SQLException {
        PreparedStatement ps = null;
        ps = conexion.prepareStatement(SQL_DELETE);

        ps.setInt(1, id);

        ps.executeUpdate();
        cerrar(ps);
    }

    public void deleteAll() throws SQLException {
        PreparedStatement ps = null;
        ps = conexion.prepareStatement(SQL_DELETE_ALL);
        ps.executeUpdate();
        cerrar(ps);
    }

}
