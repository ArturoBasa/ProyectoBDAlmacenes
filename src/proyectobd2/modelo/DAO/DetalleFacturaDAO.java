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
import proyectobd2.modelo.beans.DetalleFactura;

/**
 *
 * @author endri
 */
public class DetalleFacturaDAO implements DAOInterfaz<DetalleFactura> {

    @Override
    public int insertar(DetalleFactura detalle) {
        int valor = 0;
        String statement = "INSERT INTO detallefactura (Item_idItem, Factura_idFactura, cantidad, costo) VALUES (?,?,?,?)";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, detalle.getIdItem());
            ps.setInt(2, detalle.getIdFactura());
            ps.setInt(3, detalle.getCantidad());
            ps.setDouble(4, detalle.getCosto());

            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DetalleFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public List<DetalleFactura> obtenerListaObjetos() throws SQLException {
        List<DetalleFactura> listaDetalles = new ArrayList<>();
        String statement = "SELECT Item_idItem, Factura_idFactura, cantidad, costo FROM detallefactura";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DetalleFactura df = new DetalleFactura();
                df.setIdItem(rs.getInt("Item_idItem"));
                df.setIdFactura(rs.getInt("Factura_idFactura"));
                df.setCantidad(rs.getInt("cantidad"));
                df.setCosto(rs.getDouble("costo"));
                listaDetalles.add(df);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDetalles;
    }

    @Override
    public DetalleFactura buscar(int id) throws SQLException {
        return null;
    }

    public DetalleFactura buscar(int idItem, int idFactura) throws SQLException {
        DetalleFactura df = null;
        String statement = "SELECT Item_idItem, Factura_idFactura, cantidad, costo FROM detallefactura "
                + "WHERE Item_idItem = ? AND Factura_idFactura = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, idItem);
            ps.setInt(2, idFactura);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    df = new DetalleFactura();
                    df.setIdItem(rs.getInt("Item_idItem"));
                    df.setIdFactura(rs.getInt("Factura_idFactura"));
                    df.setCantidad(rs.getInt("cantidad"));
                    df.setCosto(rs.getDouble("costo"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return df;
    }

    @Override
    public int eliminar(int id) {
        return 0;
    }

    public int eliminar(int idItem, int idFactura) {
        int valor = 0;
        String statement = "DELETE FROM detallefactura WHERE Item_idItem = ? AND Factura_idFactura = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setInt(1, idItem);
            ps.setInt(2, idFactura);
            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DetalleFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public int modificar(DetalleFactura detalle) {
        int valor = 0;
        String statement = "UPDATE detallefactura SET cantidad = ?, costo = ? "
                + "WHERE Item_idItem = ? AND Factura_idFactura = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, detalle.getCantidad());
            ps.setDouble(2, detalle.getCosto());
            ps.setInt(3, detalle.getIdItem());
            ps.setInt(4, detalle.getIdFactura());

            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DetalleFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
}
