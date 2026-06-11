/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobd2.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectobd2.modelo.Conexion;
import proyectobd2.modelo.beans.Empleado;
import proyectobd2.modelo.beans.Rol;

/**
 *
 * @author basa2
 */
public class RolDAO {
    public static List<Rol> obtenerListaRoles() throws SQLException {
        List<Rol> listaroles = new ArrayList<>();
        String statement = "SELECT idRol, descripcion FROM rol";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Rol r = new Rol();
                r.setIdRol(rs.getInt("idRol"));
                r.setDescripcion(rs.getString("descripcion"));

                listaroles.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaroles;
    }
    
    public static List<Rol> obtenerListaRolesSucursal() throws SQLException {
        List<Rol> listaroles = new ArrayList<>();
        String statement = "SELECT idRol, descripcion FROM rol WHERE idRol != 1 and idRol != 2";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Rol r = new Rol();
                r.setIdRol(rs.getInt("idRol"));
                r.setDescripcion(rs.getString("descripcion"));

                listaroles.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaroles;
    }
}
