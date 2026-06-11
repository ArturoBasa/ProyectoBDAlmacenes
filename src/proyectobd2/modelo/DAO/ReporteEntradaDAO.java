/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobd2.modelo.DAO;

import java.util.List;
import proyectobd2.modelo.Conexion;
import proyectobd2.modelo.beans.ReporteEntradas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 
 * @author basa2
 */
public class ReporteEntradaDAO {

    public List<ReporteEntradas> obtenerTodo() throws SQLException {
        List<ReporteEntradas> lista = new ArrayList<>();
        String sql = "SELECT * FROM entradasViewConDetalle";

        try (Connection conn = new Conexion().getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ReporteEntradas e = new ReporteEntradas();
                e.setFolio(rs.getString("folio"));
                e.setFecha(rs.getString("fecha"));
                e.setProvedor(rs.getString("proveedor"));
                e.setRfc(rs.getString("rfc"));
                e.setArticulo(rs.getString("articulo"));
                e.setCantidad(rs.getInt("cantidad"));
                e.setPrecioUnitario(rs.getDouble("precioUnitario"));
                e.setSubtotal(rs.getDouble("subtotal"));
                e.setPartidaPresupuestal(rs.getString("partidaPresupuestal"));
                e.setIdSucursal(rs.getInt("idSucursal"));
                lista.add(e);
            }
        }
        return lista;
    }

    public List<ReporteEntradas> obtenerPorId(int idSucursal) throws SQLException {
        List<ReporteEntradas> lista = new ArrayList<>();
        String sql = "SELECT * FROM entradasViewConDetalle WHERE idSucursal = ?";

        try (Connection conn = new Conexion().getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idSucursal);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ReporteEntradas e = new ReporteEntradas();
                    e.setFolio(rs.getString("folio"));
                    e.setFecha(rs.getString("fecha"));
                    e.setProvedor(rs.getString("proveedor"));
                    e.setRfc(rs.getString("rfc"));
                    e.setArticulo(rs.getString("articulo"));
                    e.setCantidad(rs.getInt("cantidad"));
                    e.setPrecioUnitario(rs.getDouble("precioUnitario"));
                    e.setSubtotal(rs.getDouble("subtotal"));
                    e.setPartidaPresupuestal(rs.getString("partidaPresupuestal"));
                    e.setIdSucursal(rs.getInt("idSucursal"));
                    lista.add(e);
                }
            }
        }
        return lista;
    }
}
