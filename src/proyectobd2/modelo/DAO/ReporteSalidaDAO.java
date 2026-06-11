/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobd2.modelo.DAO;

import java.util.List;
import proyectobd2.modelo.Conexion;
import proyectobd2.modelo.beans.ReporteSalidas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author basa2
 */
public class ReporteSalidaDAO {
    public List<ReporteSalidas> obtenerTodo() throws SQLException {
        List<ReporteSalidas> lista = new ArrayList<>();
        String sql = "SELECT * FROM salidasViewConDetalle";

        try (Connection conn = new Conexion().getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ReporteSalidas s = new ReporteSalidas();
                s.setFecha(rs.getString("fecha"));
                s.setDepartamento(rs.getString("departamento"));
                s.setEncargado(rs.getString("encargado"));
                s.setDescripcion(rs.getString("descripcion"));
                s.setIdSucursal(rs.getInt("idSucursal"));
                s.setArticulo(rs.getString("articulo"));
                s.setCatidad(rs.getInt("cantidad"));
                s.setPrecioUnitario(rs.getDouble("precioUnitario"));
                s.setSubtotal(rs.getDouble("subtotal"));
                s.setPartidaPresupuestal(rs.getString("partidaPresupuestal"));
                lista.add(s);
            }
        }
        return lista;
    }

    public List<ReporteSalidas> obtenerPorId(int idSucursal) throws SQLException {
        List<ReporteSalidas> lista = new ArrayList<>();
        String sql = "SELECT * FROM salidasViewConDetalle WHERE idSucursal = ?";

        try (Connection conn = new Conexion().getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idSucursal);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ReporteSalidas s = new ReporteSalidas();
                    s.setFecha(rs.getString("fecha"));
                    s.setDepartamento(rs.getString("departamento"));
                    s.setEncargado(rs.getString("encargado"));
                    s.setDescripcion(rs.getString("descripcion"));
                    s.setIdSucursal(rs.getInt("idSucursal"));
                    s.setArticulo(rs.getString("articulo"));
                    s.setCatidad(rs.getInt("cantidad"));
                    s.setPrecioUnitario(rs.getDouble("precioUnitario"));
                    s.setSubtotal(rs.getDouble("subtotal"));
                    s.setPartidaPresupuestal(rs.getString("partidaPresupuestal"));
                    lista.add(s);
                }
            }
        }
        return lista;
    }
}
