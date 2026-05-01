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
import proyectobd2.modelo.beans.PeticionSalida;

/**
 *
 * @author endri
 */
public class PeticionSalidaDAO implements DAOInterfaz<PeticionSalida> {

    @Override
    public int insertar(PeticionSalida petSal ) {
        int valor = 0;
        Connection conn = null;
        try {
            String statement = "INSERT INTO peticionsalida (fecha, idEmpleadoAlmacen) values (?,?)";
            conn = new Conexion().getConnection();
            PreparedStatement ps = conn.prepareStatement(statement);
            ps.setDate(1, new java.sql.Date(petSal.getFecha().getTime()));
            ps.setInt(2, petSal.getEmpleado().getIdEmpleado());
            
            valor = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PeticionSalidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public List<PeticionSalida> obtenerListaObjetos() throws SQLException {
        List<PeticionSalida> listaPeticiones = new ArrayList();
        ResultSet rs = null;
        Connection conn = null;
        try {
            String statement = "SELECT idPeticionSalida, fecha, idEmpleadoAlmacen FROM peticionsalida";
            conn = new Conexion().getConnection();
            try (PreparedStatement ps = conn.prepareStatement(statement)) {
                rs = ps.executeQuery();
                PeticionSalida petSal = null;
                while (rs != null && rs.next()) {
                    petSal = new PeticionSalida();
                    petSal.setEmpleado(empleado);
                    proveedor.setIdProveedor(rs.getInt("idProveedor"));
                    proveedor.setRazonSocial(rs.getString("razonSocial"));

                    listaProveedores.add(proveedor);
                }
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProveedores;
    }

    @Override
    public Proveedor buscar(Integer idProveedor) throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
        Proveedor proveedor = null;
        try {
            String statement = "SELECT idProveedor, razonSocial, RFCProveedor, domicilioFiscal, telefono FROM proveedor WHERE idProveedor = ?";
            conn = new Conexion().getConnection();
            try (PreparedStatement ps = conn.prepareStatement(statement)) {
                ps.setInt(1, idProveedor);
                rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    proveedor = new Proveedor();  //insertarlos en orden de lectura
                    proveedor.setIdProveedor(rs.getInt("idProveedor"));
                    proveedor.setRazonSocial(rs.getString("razonSocial"));
                    proveedor.setRFCProveedor(rs.getString("RFCProveedor"));
                    proveedor.setDomicilioFiscal(rs.getString("domicilioFiscal"));
                    proveedor.setTelefono(rs.getString("telefono"));
                }
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proveedor;
    }

    @Override
    public int eliminar(Integer idProveedor) {
        int valor = 0;
        Connection conn = null;
        try {
            String statement = "DELETE FROM proveedor WHERE idProveedor=?";
            conn = new Conexion().getConnection();
            try (PreparedStatement ps = conn.prepareStatement(statement)) {
                ps.setInt(1, idProveedor);
                valor = ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public int modificar(Proveedor proveedor) {
        int valor = 0;
        Connection conn = null;
        try {
            String statement = "UPDATE proveedor SET razonSocial=?, RFCProveedor=?, domicilioFiscal=?, telefono=? WHERE idProveedor=?";
            conn = new Conexion().getConnection();
            try (PreparedStatement ps = conn.prepareStatement(statement)) {
                ps.setString(1, proveedor.getRazonSocial());
                ps.setString(2, proveedor.getRFCProveedor());
                ps.setString(3, proveedor.getDomicilioFiscal());
                ps.setString(4, proveedor.getTelefono());
                ps.setInt(5, proveedor.getIdProveedor());
                valor = ps.executeUpdate();

                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
}
