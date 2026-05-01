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
import proyectobd2.modelo.beans.Item;

/**
 *
 * @author endri
 */
public class ItemDAO implements DAOInterfaz<Item> {

    @Override
    public int insertar(Item item) {
        int valor = 0;
        String statement = "INSERT INTO item (existencias, stockMinimo, stockMaximo, nombreItem, precioUnitario, "
                + "PartidaPresupuestal_idPartidaPresupuestal, Sucursal_idSucursal, estado, descripcion) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, item.getExistencias());
            ps.setInt(2, item.getStockMinimo());
            ps.setInt(3, item.getStockMaximo());
            ps.setString(4, item.getNombreItem());
            ps.setDouble(5, item.getPrecioUnitario());
            ps.setInt(6, item.getIdPartidaPresupuestal());
            ps.setInt(7, item.getIdSucursal());
            ps.setString(8, item.getEstado());
            ps.setString(9, item.getDescripcion());

            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public List<Item> obtenerListaObjetos() throws SQLException {
        List<Item> listaItems = new ArrayList<>();
        String statement = "SELECT idItem, existencias, stockMinimo, stockMaximo, nombreItem, precioUnitario, "
                + "PartidaPresupuestal_idPartidaPresupuestal, Sucursal_idSucursal, estado, descripcion FROM item";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item();
                item.setIdItem(rs.getInt("idItem"));
                item.setExistencias(rs.getInt("existencias"));
                item.setStockMinimo(rs.getInt("stockMinimo"));
                item.setStockMaximo(rs.getInt("stockMaximo"));
                item.setNombreItem(rs.getString("nombreItem"));
                item.setPrecioUnitario(rs.getDouble("precioUnitario"));
                item.setIdPartidaPresupuestal(rs.getInt("PartidaPresupuestal_idPartidaPresupuestal"));
                item.setIdSucursal(rs.getInt("Sucursal_idSucursal"));
                item.setEstado(rs.getString("estado"));
                item.setDescripcion(rs.getString("descripcion"));

                listaItems.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaItems;
    }

    @Override
    public Item buscar(int idItem) throws SQLException {
        Item item = null;
        String statement = "SELECT idItem, existencias, stockMinimo, stockMaximo, nombreItem, precioUnitario, "
                + "PartidaPresupuestal_idPartidaPresupuestal, Sucursal_idSucursal, estado, descripcion "
                + "FROM item WHERE idItem = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, idItem);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    item = new Item();
                    item.setIdItem(rs.getInt("idItem"));
                    item.setExistencias(rs.getInt("existencias"));
                    item.setStockMinimo(rs.getInt("stockMinimo"));
                    item.setStockMaximo(rs.getInt("stockMaximo"));
                    item.setNombreItem(rs.getString("nombreItem"));
                    item.setPrecioUnitario(rs.getDouble("precioUnitario"));
                    item.setIdPartidaPresupuestal(rs.getInt("PartidaPresupuestal_idPartidaPresupuestal"));
                    item.setIdSucursal(rs.getInt("Sucursal_idSucursal"));
                    item.setEstado(rs.getString("estado"));
                    item.setDescripcion(rs.getString("descripcion"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }

    @Override
    public int eliminar(int idItem) {
        int valor = 0;
        String statement = "DELETE FROM item WHERE idItem = ?";
        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setInt(1, idItem);
            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public int modificar(Item item) {
        int valor = 0;
        String statement = "UPDATE item SET existencias=?, stockMinimo=?, stockMaximo=?, nombreItem=?, "
                + "precioUnitario=?, PartidaPresupuestal_idPartidaPresupuestal=?, Sucursal_idSucursal=?, "
                + "estado=?, descripcion=? WHERE idItem=?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, item.getExistencias());
            ps.setInt(2, item.getStockMinimo());
            ps.setInt(3, item.getStockMaximo());
            ps.setString(4, item.getNombreItem());
            ps.setDouble(5, item.getPrecioUnitario());
            ps.setInt(6, item.getIdPartidaPresupuestal());
            ps.setInt(7, item.getIdSucursal());
            ps.setString(8, item.getEstado());
            ps.setString(9, item.getDescripcion());
            ps.setInt(10, item.getIdItem());

            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
}
