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
import proyectobd2.modelo.beans.BitacoraPedidos;

/**
 *
 * @author endri
 */
public class BitacoraPedidosDAO implements DAOInterfaz<BitacoraPedidos> {

    @Override
    public int insertar(BitacoraPedidos bitacora) {
        int valor = 0;
        String statement = "INSERT INTO bitacorapedidos (fecha, cantidadPedir, Item_idItem) VALUES (?,?,?)";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setDate(1, new java.sql.Date(bitacora.getFecha().getTime()));
            ps.setInt(2, bitacora.getCantidadPedir());
            ps.setInt(3, bitacora.getIdItem());

            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BitacoraPedidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public List<BitacoraPedidos> obtenerListaObjetos() throws SQLException {
        List<BitacoraPedidos> listaBitacora = new ArrayList<>();
        String statement = "SELECT idBitacoraPedidos, fecha, cantidadPedir, Item_idItem FROM bitacorapedidos";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                BitacoraPedidos b = new BitacoraPedidos();
                b.setIdBitacoraPedidos(rs.getInt("idBitacoraPedidos"));
                b.setFecha(rs.getDate("fecha"));
                b.setCantidadPedir(rs.getInt("cantidadPedir"));
                b.setIdItem(rs.getInt("Item_idItem"));
                listaBitacora.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BitacoraPedidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaBitacora;
    }

    @Override
    public BitacoraPedidos buscar(int idBitacora) throws SQLException {
        BitacoraPedidos b = null;
        String statement = "SELECT idBitacoraPedidos, fecha, cantidadPedir, Item_idItem FROM bitacorapedidos WHERE idBitacoraPedidos = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, idBitacora);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    b = new BitacoraPedidos();
                    b.setIdBitacoraPedidos(rs.getInt("idBitacoraPedidos"));
                    b.setFecha(rs.getDate("fecha"));
                    b.setCantidadPedir(rs.getInt("cantidadPedir"));
                    b.setIdItem(rs.getInt("Item_idItem"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BitacoraPedidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

    @Override
    public int eliminar(int idBitacora) {
        int valor = 0;
        String statement = "DELETE FROM bitacorapedidos WHERE idBitacoraPedidos = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, idBitacora);
            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BitacoraPedidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public int modificar(BitacoraPedidos b) {
        int valor = 0;
        String statement = "UPDATE bitacorapedidos SET fecha = ?, cantidadPedir = ?, Item_idItem = ? WHERE idBitacoraPedidos = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setDate(1, new java.sql.Date(b.getFecha().getTime()));
            ps.setInt(2, b.getCantidadPedir());
            ps.setInt(3, b.getIdItem());
            ps.setInt(4, b.getIdBitacoraPedidos());

            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BitacoraPedidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
}
