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
import proyectobd2.modelo.beans.Sucursal;

/**
 *
 * @author endri
 */
public class SucursalDAO implements DAOInterfaz<Sucursal> {

    @Override
    public int insertar(Sucursal sucursal) {
        int valor = 0;
        Connection conn = null;
        try {
            String statement = "INSERT INTO sucursal (nombreSucursal, ciudad, direccion) values (?,?,?)";
            conn = new Conexion().getConnection();
            PreparedStatement ps = conn.prepareStatement(statement);
            ps.setString(1, sucursal.getNombreSucursal());
            ps.setString(2, sucursal.getCiudad());
            ps.setString(3, sucursal.getDireccion());
            valor = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public List<Sucursal> obtenerListaObjetos() throws SQLException {
        List<Sucursal> listaSucursales = new ArrayList();
        ResultSet rs = null;
        Connection conn = null;
        try {
            String statement = "SELECT idSucursal, nombreSucursal, ciudad, direccion FROM sucursal";
            conn = new Conexion().getConnection();
            try (PreparedStatement ps = conn.prepareStatement(statement)) {
                rs = ps.executeQuery();
                Sucursal sucursal = null;
                while (rs != null && rs.next()) {
                    sucursal = new Sucursal();
                    sucursal.setIdSucursal(rs.getInt("idSucursal"));
                    sucursal.setNombreSucursal(rs.getString("nombreSucursal"));
                    sucursal.setCiudad(rs.getString("ciudad"));
                    sucursal.setDireccion(rs.getString("direccion"));
                    listaSucursales.add(sucursal);
                }
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaSucursales;
    }

    @Override
    public Sucursal buscar(Integer idSucursal) throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
        Sucursal sucursal = null;
        try {
            String statement = "SELECT idSucursal, nombreSucursal, ciudad, direccion FROM sucursal WHERE idSucursal = ?";
            conn = new Conexion().getConnection();
            try (PreparedStatement ps = conn.prepareStatement(statement)) {
                ps.setInt(1, idSucursal);
                rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    sucursal = new Sucursal();  //insertarlos en orden de lectura
                    sucursal.setIdSucursal(rs.getInt("idSucursal"));
                    sucursal.setNombreSucursal(rs.getString("nombreSucursal"));
                    sucursal.setCiudad(rs.getString("ciudad"));
                    sucursal.setDireccion(rs.getString("direccion"));

                }
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucursal;
    }

    @Override
    public int eliminar(Integer idSucursal) {
        int valor = 0;
        Connection conn = null;
        try {
            String statement = "DELETE FROM sucursal WHERE idSucursal=?";
            conn = new Conexion().getConnection();
            try (PreparedStatement ps = conn.prepareStatement(statement)) {
                ps.setInt(1, idSucursal);
                valor = ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public int modificar(Sucursal sucursal) {
        int valor = 0;
        Connection conn = null;
        try {
            String statement = "UPDATE sucursal SET nombreSucursal=?, ciudad=?, direccion=? WHERE idSucursal=?";
            conn = new Conexion().getConnection();
            try (PreparedStatement ps = conn.prepareStatement(statement)) {
                ps.setString(1, sucursal.getNombreSucursal());
                ps.setString(2, sucursal.getCiudad());
                ps.setString(3, sucursal.getDireccion());
                ps.setInt(4, sucursal.getIdSucursal());
                valor = ps.executeUpdate();

                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

}
