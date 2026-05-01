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
        String statement = "INSERT INTO sucursal (nombreSucursal, ciudad, direccion) values (?,?,?)";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setString(1, sucursal.getNombreSucursal());
            ps.setString(2, sucursal.getCiudad());
            ps.setString(3, sucursal.getDireccion());

            valor = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public List<Sucursal> obtenerListaObjetos() throws SQLException {
        List<Sucursal> listaSucursales = new ArrayList<>();
        String statement = "SELECT idSucursal, nombreSucursal, ciudad, direccion FROM sucursal";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Sucursal sucursal = new Sucursal();
                sucursal.setIdSucursal(rs.getInt("idSucursal"));
                sucursal.setNombreSucursal(rs.getString("nombreSucursal"));
                sucursal.setCiudad(rs.getString("ciudad"));
                sucursal.setDireccion(rs.getString("direccion"));
                listaSucursales.add(sucursal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaSucursales;
    }

    @Override
    public Sucursal buscar(int idSucursal) throws SQLException {
        Sucursal sucursal = null;
        String statement = "SELECT idSucursal, nombreSucursal, ciudad, direccion FROM sucursal WHERE idSucursal = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, idSucursal);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    sucursal = new Sucursal();
                    sucursal.setIdSucursal(rs.getInt("idSucursal"));
                    sucursal.setNombreSucursal(rs.getString("nombreSucursal"));
                    sucursal.setCiudad(rs.getString("ciudad"));
                    sucursal.setDireccion(rs.getString("direccion"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucursal;
    }

    @Override
    public int eliminar(int idSucursal) {
        int valor = 0;
        String statement = "DELETE FROM sucursal WHERE idSucursal = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, idSucursal);
            valor = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public int modificar(Sucursal sucursal) {
        int valor = 0;
        String statement = "UPDATE sucursal SET nombreSucursal = ?, ciudad = ?, direccion = ? WHERE idSucursal = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setString(1, sucursal.getNombreSucursal());
            ps.setString(2, sucursal.getCiudad());
            ps.setString(3, sucursal.getDireccion());
            ps.setInt(4, sucursal.getIdSucursal());

            valor = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
}