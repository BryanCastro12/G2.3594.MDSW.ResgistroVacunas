package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.EmpleadoDTO;

public class EmpleadoDAO extends ConexionBD {

    private static final String cedula = "cedula";
    private static final String nombre = "nombre";
    private static final String apellido = "apellido";
    private static final String correo = "correo";
    private static final String telefono = "telefono";
    private static final String password = "password";

    private static final String SQL_SELECT_ALL = "Select * from Empleado";
    private static final String SQL_BUSCAR = "Select * from Empleado where nombre = ?";

    private static final String SQL_INSERT = "Insert into Empleado " + "(" + cedula + "," + nombre + "," + apellido + ","
            + correo + "," + telefono + "," + password + ") VALUES (?,?,?,?,?,?)";

    private static final String SQL_DELETE = "Delete from Empleado where " + cedula + " = ?";
    private static final String SQL_DELETE_ALL = "Delete from Empleado";
    private static final String SQL_UPDATE = "Update Empleado set " + nombre + " = ?,"
            + apellido + " = ?," + correo + " = ?," + telefono + " = ?," + password + " = ? where " + cedula + " = ?";

    public EmpleadoDAO() {
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

    private EmpleadoDTO getObject(ResultSet rs) throws SQLException {
        EmpleadoDTO dtoEmpleado = new EmpleadoDTO();

        dtoEmpleado.setCedula(rs.getString(cedula));
        dtoEmpleado.setNombre(rs.getString(nombre));
        dtoEmpleado.setApellido(rs.getString(apellido));
        dtoEmpleado.setCorreo(rs.getString(correo));
        dtoEmpleado.setTelefono(rs.getString(telefono));
        dtoEmpleado.setPassword(rs.getString(password));
        return dtoEmpleado;

    }

    public void append(EmpleadoDTO dto) throws SQLException {
        PreparedStatement ps = null;

        ps = conexion.prepareStatement(SQL_INSERT);

        ps.setString(1, dto.getCedula());
        ps.setString(2, dto.getNombre());
        ps.setString(3, dto.getApellido());
        ps.setString(4, dto.getCorreo());
        ps.setString(5, dto.getTelefono());
        ps.setString(6, dto.getPassword());

        ps.executeUpdate();
        cerrar(ps);
    }

    public void update(EmpleadoDTO dto) throws SQLException {

        PreparedStatement ps = null;

        ps = conexion.prepareStatement(SQL_UPDATE);

        ps.setString(1, dto.getNombre());
        ps.setString(2, dto.getApellido());
        ps.setString(3, dto.getCorreo());
        ps.setString(4, dto.getTelefono());
        ps.setString(5, dto.getPassword());
        ps.setString(6, dto.getCedula());
        
        ps.executeUpdate();
        cerrar(ps);
    }

    public void delete(String cedula) throws SQLException {
        PreparedStatement ps = null;
        ps = conexion.prepareStatement(SQL_DELETE);

        ps.setString(1, cedula);

        ps.executeUpdate();
        cerrar(ps);
    }

    public void deleteAll() throws SQLException {
        PreparedStatement ps = null;
        ps = conexion.prepareStatement(SQL_DELETE_ALL);
        ps.executeUpdate();
        cerrar(ps);
    }

    public EmpleadoDTO buscarCedula(String nombre) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        EmpleadoDTO dtoEmpleado = null;

        ps = conexion.prepareCall(SQL_BUSCAR);
        ps.setString(1, nombre);
        rs = ps.executeQuery();

        while (rs.next()) {
            dtoEmpleado = getObject(rs);
        }
        cerrar(ps);
        cerrar(rs);
        return dtoEmpleado;
    }
}
