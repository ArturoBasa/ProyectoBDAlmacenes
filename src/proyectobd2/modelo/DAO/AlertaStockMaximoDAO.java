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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyectobd2.modelo.Conexion;

/**
 *
 * @author endri
 */
public class AlertaStockMaximoDAO {

    public void obtenerItemsStockMaximo(JTable tb_stockMaximo, int idSucursal) {

        String statement = "SELECT nombreItem , existencias , stockMaximo, excedente FROM itemsStockMaximoPorSucursal WHERE idSucursal = ?";
        DefaultTableModel modelo = (DefaultTableModel) tb_stockMaximo.getModel();
        modelo.setRowCount(0);

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setInt(1, idSucursal);

            try (ResultSet rs = ps.executeQuery();) {
                int columnas = rs.getMetaData().getColumnCount();

                while (rs.next()) {
                    Object[] fila = new Object[columnas];
                    for (int i = 0; i < columnas; i++) {

                        fila[i] = rs.getObject(i + 1);
                    }
                    modelo.addRow(fila);

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
