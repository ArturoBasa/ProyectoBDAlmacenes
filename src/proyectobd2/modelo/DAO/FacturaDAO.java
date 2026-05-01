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
import proyectobd2.modelo.beans.Factura;

/**
 *
 * @author endri
 */
public class FacturaDAO implements DAOInterfaz<Factura> {

    @Override
    public int insertar(Factura factura) {
        int valor = 0;
        String statement = "INSERT INTO factura (folioFactura, fechaFactura, precioTotal, Proveedor_idProveedor) VALUES (?,?,?,?)";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setString(1, factura.getFolioFactura());
            ps.setDate(2, new java.sql.Date(factura.getFechaFactura().getTime()));
            ps.setDouble(3, factura.getPrecioTotal());
            ps.setInt(4, factura.getIdProveedor());

            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public List<Factura> obtenerListaObjetos() throws SQLException {
        List<Factura> listaFacturas = new ArrayList<>();
        String statement = "SELECT idFactura, folioFactura, fechaFactura, precioTotal, Proveedor_idProveedor FROM factura";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Factura f = new Factura();
                f.setIdFactura(rs.getInt("idFactura"));
                f.setFolioFactura(rs.getString("folioFactura"));
                f.setFechaFactura(rs.getDate("fechaFactura"));
                f.setPrecioTotal(rs.getDouble("precioTotal"));
                f.setIdProveedor(rs.getInt("Proveedor_idProveedor"));

                listaFacturas.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFacturas;
    }

    @Override
    public Factura buscar(int idFactura) throws SQLException {
        Factura f = null;
        String statement = "SELECT idFactura, folioFactura, fechaFactura, precioTotal, Proveedor_idProveedor FROM factura WHERE idFactura = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, idFactura);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    f = new Factura();
                    f.setIdFactura(rs.getInt("idFactura"));
                    f.setFolioFactura(rs.getString("folioFactura"));
                    f.setFechaFactura(rs.getDate("fechaFactura"));
                    f.setPrecioTotal(rs.getDouble("precioTotal"));
                    f.setIdProveedor(rs.getInt("Proveedor_idProveedor"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }

    @Override
    public int eliminar(int idFactura) {
        int valor = 0;
        String statement = "DELETE FROM factura WHERE idFactura = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, idFactura);
            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public int modificar(Factura f) {
        int valor = 0;
        String statement = "UPDATE factura SET folioFactura = ?, fechaFactura = ?, precioTotal = ?, Proveedor_idProveedor = ? WHERE idFactura = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setString(1, f.getFolioFactura());
            ps.setDate(2, new java.sql.Date(f.getFechaFactura().getTime()));
            ps.setDouble(3, f.getPrecioTotal());
            ps.setInt(4, f.getIdProveedor());
            ps.setInt(5, f.getIdFactura());

            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
}
