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
import proyectobd2.modelo.beans.Kardex;

/**
 *
 * @author endri
 */
public class KardexDAO implements DAOInterfaz<Kardex> {

    @Override
    public int insertar(Kardex kardex) {
        int valor = 0;
        String statement = "INSERT INTO vistaKardex (costo, fecha, costoPromedio, Item_idItem, Factura_idFactura) values (?,?,?,?,?)";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setDouble(1, kardex.getCosto());
            ps.setDate(2, new java.sql.Date(kardex.getFecha().getTime()));
            ps.setDouble(3, kardex.getCostoPromedio());
            ps.setInt(4, kardex.getIdItem());
            ps.setInt(5, kardex.getIdFactura());

            valor = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KardexDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public List<Kardex> obtenerListaObjetos() throws SQLException {
        List<Kardex> listaKardex = new ArrayList<>();
        String statement = "SELECT idKardex, costo, fecha, costoPromedio, Item_idItem, Factura_idFactura FROM vistaKardex";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Kardex k = new Kardex();
                k.setIdKardex(rs.getInt("idKardex"));
                k.setCosto(rs.getDouble("costo"));
                k.setFecha(rs.getDate("fecha"));
                k.setCostoPromedio(rs.getDouble("costoPromedio"));
                k.setIdItem(rs.getInt("Item_idItem"));
                k.setIdFactura(rs.getInt("Factura_idFactura"));

                listaKardex.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KardexDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaKardex;
    }

    @Override
    public Kardex buscar(int idKardex) throws SQLException {
        Kardex k = null;
        String statement = "SELECT idKardex, costo, fecha, costoPromedio, Item_idItem, Factura_idFactura FROM vistaKardex WHERE idKardex = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, idKardex);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    k = new Kardex();
                    k.setIdKardex(rs.getInt("idKardex"));
                    k.setCosto(rs.getDouble("costo"));
                    k.setFecha(rs.getDate("fecha"));
                    k.setCostoPromedio(rs.getDouble("costoPromedio"));
                    k.setIdItem(rs.getInt("Item_idItem"));
                    k.setIdFactura(rs.getInt("Factura_idFactura"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(KardexDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return k;
    }

    @Override
    public int eliminar(int idKardex) {
        int valor = 0;
        String statement = "DELETE FROM vistaKardex WHERE idKardex = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, idKardex);
            valor = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KardexDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public int modificar(Kardex k) {
        int valor = 0;
        String statement = "UPDATE vistaKardex SET costo=?, fecha=?, costoPromedio=?, Item_idItem=?, Factura_idFactura=? WHERE idKardex=?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setDouble(1, k.getCosto());
            ps.setDate(2, new java.sql.Date(k.getFecha().getTime()));
            ps.setDouble(3, k.getCostoPromedio());
            ps.setInt(4, k.getIdItem());
            ps.setInt(5, k.getIdFactura());
            ps.setInt(6, k.getIdKardex());

            valor = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KardexDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
}
