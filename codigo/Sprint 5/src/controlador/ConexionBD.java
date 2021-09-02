/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Joel
 */
public class ConexionBD {

    protected Connection conexion;

    private static final String url = "jdbc:mysql://localhost/sistema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "ronaldo";

    public ConexionBD() {
        conexion = null;
        try {
            Class.forName(driver);

            conexion = DriverManager.getConnection(url, user, password);
            if(conexion != null)
            {
                System.out.println("Conexion establecida");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } 

    }
    
    public ConexionBD getConexionBD()
    {
        return (ConexionBD) conexion;
    }
    
    protected void cerrar(PreparedStatement ps) throws SQLException
    {
        if(ps != null)
        {
            ps.close();
        }
    }
    
    protected void cerrar(ResultSet rs) throws SQLException
    {
        if(rs != null)
        {
            rs.close();
        }
    }
}
