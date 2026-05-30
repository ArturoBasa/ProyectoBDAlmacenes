/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobd2.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import proyectobd2.modelo.Conexion;

/**
 *
 * @author endri
 */
public class AlertaStockMaximoDAO {

    public static List<Object[]> obtenerItemsStockMaximo(int idSucursal) {
        List<Object[]> listaFilas = new ArrayList<>();
        String statement = "SELECT nombreItem , existencias , stockMaximo, excedente FROM itemsStockMaximoPorSucursal WHERE idSucursal = ?";

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

    public static List<Object[]> obtenerItemsStockMaximoGlobales() {
        List<Object[]> listaFilas = new ArrayList<>();
        String statement = "SELECT v.nombreItem , v.existencias , v.stockMaximo, v.excedente, s.nombreSucursal FROM itemsStockMaximoPorSucursal v JOIN sucursal s ON v.idSucursal = s.idSucursal";

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
}
