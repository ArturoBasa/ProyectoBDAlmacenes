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
public class DetalleFacturaDAO {

    public static int insertar(DetalleFactura detalle) {
        int valor = 0;
        String statement = "INSERT INTO detalle_factura (Item_idItem, Factura_idFactura, cantidad, costo, Factura_folioFactura) VALUES (?,?,?,?,?)";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, detalle.getIdItem());
            ps.setInt(2, detalle.getIdFactura());
            ps.setInt(3, detalle.getCantidad());
            ps.setDouble(4, detalle.getCosto());
            ps.setString(5, detalle.getFolioFactura());

            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DetalleFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    public static List<DetalleFactura> obtenerListaObjetos() throws SQLException {
        List<DetalleFactura> listaDetalles = new ArrayList<>();
        String statement = "SELECT Item_idItem, Factura_idFactura, cantidad, costo, Factura_folioFactura FROM detalle_factura";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DetalleFactura df = new DetalleFactura();
                df.setIdItem(rs.getInt("Item_idItem"));
                df.setIdFactura(rs.getInt("Factura_idFactura"));
                df.setCantidad(rs.getInt("cantidad"));
                df.setCosto(rs.getDouble("costo"));
                df.setFolioFactura(rs.getString("Factura_folioFactura"));
                listaDetalles.add(df);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDetalles;
    }

    public static DetalleFactura buscar(int id) throws SQLException {
        return null;
    }

    public static DetalleFactura buscar(int idItem, int idFactura) throws SQLException {
        DetalleFactura df = null;
        String statement = "SELECT Item_idItem, Factura_idFactura, cantidad, costo, Factura_folioFactura FROM detalle_factura "
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
                    df.setFolioFactura(rs.getString("Factura_folioFactura"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return df;
    }

    public static int eliminar(int id) {
        return 0;
    }

    public static int eliminar(int idItem, int idFactura) {
        int valor = 0;
        String statement = "DELETE FROM detalle_factura WHERE Item_idItem = ? AND Factura_idFactura = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setInt(1, idItem);
            ps.setInt(2, idFactura);
            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DetalleFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    public static int modificar(DetalleFactura detalle) {
        int valor = 0;
        String statement = "UPDATE detalle_factura SET cantidad = ?, costo = ?, Factura_folioFactura = ? "
                + "WHERE Item_idItem = ? AND Factura_idFactura = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, detalle.getCantidad());
            ps.setDouble(2, detalle.getCosto());
            ps.setString(3, detalle.getFolioFactura());
            ps.setInt(4, detalle.getIdItem());
            ps.setInt(5, detalle.getIdFactura());

            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DetalleFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
}
