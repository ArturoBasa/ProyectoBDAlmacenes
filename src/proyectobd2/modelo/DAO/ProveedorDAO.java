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
import proyectobd2.modelo.beans.Proveedor;

public class ProveedorDAO implements DAOInterfaz<Proveedor> {

    @Override
    public int insertar(Proveedor proveedor) {
        int valor = 0;
        String statement = "INSERT INTO proveedor (razonSocial, RFCProveedor, domicilioFiscal, telefono) values (?,?,?,?)";
        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setString(1, proveedor.getRazonSocial());
            ps.setString(2, proveedor.getRFCProveedor());
            ps.setString(3, proveedor.getDomicilioFiscal());
            ps.setString(4, proveedor.getTelefono());
            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public List<Proveedor> obtenerListaObjetos() throws SQLException {
        List<Proveedor> listaProveedores = new ArrayList<>();
        String statement = "SELECT idProveedor, razonSocial, RFCProveedor, domicilioFiscal, telefono FROM proveedor";
        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setIdProveedor(rs.getInt("idProveedor"));
                p.setRazonSocial(rs.getString("razonSocial"));
                p.setRFCProveedor(rs.getString("RFCProveedor"));
                p.setDomicilioFiscal(rs.getString("domicilioFiscal"));
                p.setTelefono(rs.getString("telefono"));
                listaProveedores.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProveedores;
    }

    @Override
    public Proveedor buscar(int idProveedor) throws SQLException {
        Proveedor p = null;
        String statement = "SELECT idProveedor, razonSocial, RFCProveedor, domicilioFiscal, telefono FROM proveedor WHERE idProveedor = ?";
        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setInt(1, idProveedor);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    p = new Proveedor();
                    p.setIdProveedor(rs.getInt("idProveedor"));
                    p.setRazonSocial(rs.getString("razonSocial"));
                    p.setRFCProveedor(rs.getString("RFCProveedor"));
                    p.setDomicilioFiscal(rs.getString("domicilioFiscal"));
                    p.setTelefono(rs.getString("telefono"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public int eliminar(int idProveedor) {
        int valor = 0;
        String statement = "DELETE FROM proveedor WHERE idProveedor=?";
        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setInt(1, idProveedor);
            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public int modificar(Proveedor proveedor) {
        int valor = 0;
        String statement = "UPDATE proveedor SET razonSocial=?, RFCProveedor=?, domicilioFiscal=?, telefono=? WHERE idProveedor=?";
        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setString(1, proveedor.getRazonSocial());
            ps.setString(2, proveedor.getRFCProveedor());
            ps.setString(3, proveedor.getDomicilioFiscal());
            ps.setString(4, proveedor.getTelefono());
            ps.setInt(5, proveedor.getIdProveedor());
            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
}
