/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobd2.modelo.DAO;

import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import proyectobd2.modelo.Conexion;
import proyectobd2.modelo.beans.Rol;
import proyectobd2.modelo.beans.Sucursal;

/**
 *
 * @author endri
 */
public class RolDAO implements DAOInterfaz<Rol> {

    @Override
    public int insertar(Rol rol) {
        int valor = 0;
        Connection conn = null;
        try {
            String statement = "INSERT INTO rol (descripcion) values (?)";
            conn = new Conexion().getConnection();
            PreparedStatement ps = conn.prepareStatement(statement);
            ps.setString(1, rol.getDescripcion());
            valor = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public List<Rol> obtenerListaObjetos() throws SQLException {
        List<Rol> listaRoles = new ArrayList();
        ResultSet rs = null;
        Connection conn = null;
        try {
            String statement = "SELECT idRol, descripcion FROM rol";
            conn = new Conexion().getConnection();
            try (PreparedStatement ps = conn.prepareStatement(statement)) {
                rs = ps.executeQuery();
                Rol rol = null;
                while (rs != null && rs.next()) {
                    rol = new Rol();
                    rol.setIdRol(rs.getInt("idRol"));
                    rol.setDescripcion(rs.getString("descripcion"));
                    listaRoles.add(rol);
                }
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRoles;
    }

    @Override
    public Rol buscar(Integer idRol) throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
        Rol rol = null;
        try {
            String statement = "SELECT idRol, descripcion FROM rol WHERE idRol = ?";
            conn = new Conexion().getConnection();
            try (PreparedStatement ps = conn.prepareStatement(statement)) {
                ps.setInt(1, idRol);
                rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    rol = new Rol();  
                    rol.setIdRol(rs.getInt("idRol"));
                    rol.setDescripcion(rs.getString("descripcion"));
                }
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rol;
    }

    @Override
    public int eliminar(Integer idRol) {
        int valor = 0;
        Connection conn = null;
        try {
            String statement = "DELETE FROM rol WHERE idRol=?";
            conn = new Conexion().getConnection();
            try (PreparedStatement ps = conn.prepareStatement(statement)) {
                ps.setInt(1, idRol);
                valor = ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public int modificar(Rol rol) {
        int valor = 0;
        Connection conn = null;
        try {
            String statement = "UPDATE rol SET descripcion=? WHERE idRol=?";
            conn = new Conexion().getConnection();
            try (PreparedStatement ps = conn.prepareStatement(statement)) {
                ps.setString(1, rol.getDescripcion());
                ps.setInt(2, rol.getIdRol());
                valor = ps.executeUpdate();

                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

}
