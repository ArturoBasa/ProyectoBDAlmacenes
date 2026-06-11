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
import java.util.ArrayList;
import java.util.List;
import proyectobd2.modelo.Conexion;
import proyectobd2.modelo.beans.Factura;

/**
 *
 * @author endri
 */
public class FacturaDAO {

    public static int insertar(Factura factura) {
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

    public static List<Factura> obtenerListaObjetos() throws SQLException {
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

    public static Factura buscar(int id) throws SQLException {
        return null;
    }

    public static List<Object[]> rellenarTablaEntradas(String folioFactura, int idSucursal) throws SQLException {
        List<Object[]> listaFilas = new ArrayList<>();
        String statement = "SELECT folio, fechaFactura, proveedor, rfc, total FROM entradasView WHERE sucursal = ? AND folio LIKE ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setInt(1, idSucursal);
            ps.setString(2, folioFactura + "%");

            try (ResultSet rs = ps.executeQuery();) {
                int columnas = rs.getMetaData().getColumnCount();

                while (rs.next()) {
                    Object[] fila = new Object[columnas];
                    for (int i = 0; i < columnas; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    listaFilas.add(fila);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaFilas;
    }

    public static List<Object[]> rellenarTablaEntradasGlobal(String folioFactura) throws SQLException {
        List<Object[]> listaFilas = new ArrayList<>();
        String statement = "SELECT v.folio, v.fechaFactura, v.proveedor, v.rfc, v.total, s.nombreSucursal FROM entradasView v JOIN sucursal s ON v.sucursal = s.idSucursal WHERE v.folio LIKE ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setString(1, folioFactura + "%");

            try (ResultSet rs = ps.executeQuery();) {
                int columnas = rs.getMetaData().getColumnCount();

                while (rs.next()) {
                    Object[] fila = new Object[columnas];
                    for (int i = 0; i < columnas; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    listaFilas.add(fila);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaFilas;
    }

    public static Factura buscarPorFolio(String folio) throws SQLException {
        String statement = "SELECT idFactura, folioFactura, fechaFactura, precioTotal, Proveedor_idProveedor FROM factura WHERE folioFactura = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setString(1, folio);

            try (ResultSet rs = ps.executeQuery();) {

                if (rs.next()) {
                    Factura f = new Factura();
                    f.setIdFactura(rs.getInt("idFactura"));
                    f.setFolioFactura(rs.getString("folioFactura"));
                    f.setFechaFactura(rs.getDate("fechaFactura"));
                    f.setPrecioTotal(rs.getDouble("precioTotal"));
                    f.setIdProveedor(rs.getInt("Proveedor_idProveedor"));
                    return f;

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Factura mapFactura(ResultSet rs) throws SQLException {
        Factura f = new Factura();
        f.setIdFactura(rs.getInt("idFactura"));
        f.setFolioFactura(rs.getString("folioFactura"));
        f.setFechaFactura(rs.getDate("fechaFactura"));
        f.setPrecioTotal(rs.getDouble("precioTotal"));
        f.setIdProveedor(rs.getInt("Proveedor_idProveedor"));

        return f;
    }

    public static int eliminar(int idFactura) {
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

    public static int modificar(Factura f) {
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

    public static List<Object[]> obtenerEntradas(int idSucursal) {
        List<Object[]> listaFilas = new ArrayList<>();
        String statement = "SELECT folio, fecha, proveedor, rfc, total FROM entradasView WHERE idSucursal = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setInt(1, idSucursal);

            try (ResultSet rs = ps.executeQuery();) {
                int columnas = rs.getMetaData().getColumnCount();

                while (rs.next()) {
                    Object[] fila = new Object[columnas];
                    for (int i = 0; i < columnas; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    listaFilas.add(fila);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return listaFilas;
    }

    public static List<Object[]> obtenerEntradasGlobales() {
        List<Object[]> listaFilas = new ArrayList<>();
        String statement = "SELECT v.folio, v.fecha, v.proveedor, v.rfc, v.total, s.nombreSucursal FROM entradasView v JOIN sucursal s ON v.idSucursal = s.idSucursal";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            try (ResultSet rs = ps.executeQuery();) {
                int columnas = rs.getMetaData().getColumnCount();

                while (rs.next()) {
                    Object[] fila = new Object[columnas];
                    for (int i = 0; i < columnas; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    listaFilas.add(fila);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaFilas;
    }
    

    public static List<Object[]> obtenerArticulosFolio(String folio) {
        List<Object[]> listaFilas = new ArrayList<>();
        String statement = "SELECT item, cantidad, sucursal FROM itemPorFactura WHERE folio = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setString(1, folio);
            try (ResultSet rs = ps.executeQuery()) {
                int columnas = rs.getMetaData().getColumnCount();
                while (rs.next()) {
                    Object[] fila = new Object[columnas];
                    for (int i = 0; i < columnas; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    listaFilas.add(fila);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaFilas;
    }
}
