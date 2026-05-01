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
import proyectobd2.modelo.beans.DetalleSalida;

/**
 *
 * @author endri
 */
public class DetalleSalidaDAO implements DAOInterfaz<DetalleSalida> {

    @Override
    public int insertar(DetalleSalida detalle) {
        int valor = 0;
        String statement = "INSERT INTO detallesalida (Item_idItem, PeticionSalida_idPeticionSalida, cantidad) VALUES (?,?,?)";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, detalle.getIdItem());
            ps.setInt(2, detalle.getIdPeticionSalida());
            ps.setInt(3, detalle.getCantidad());

            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DetalleSalidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public List<DetalleSalida> obtenerListaObjetos() throws SQLException {
        List<DetalleSalida> listaDetalles = new ArrayList<>();
        String statement = "SELECT Item_idItem, PeticionSalida_idPeticionSalida, cantidad FROM detallesalida";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DetalleSalida ds = new DetalleSalida();
                ds.setIdItem(rs.getInt("Item_idItem"));
                ds.setIdPeticionSalida(rs.getInt("PeticionSalida_idPeticionSalida"));
                ds.setCantidad(rs.getInt("cantidad"));
                listaDetalles.add(ds);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleSalidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDetalles;
    }

    /**
     * Nota: Al ser una tabla intermedia, buscar por un solo ID suele devolver
     * una lista. Este método busca una combinación específica de Item y
     * Petición.
     */
    @Override
    public DetalleSalida buscar(int id) throws SQLException {
        
        return null;
    }

    public DetalleSalida buscar(int idItem, int idPeticion) throws SQLException {
        DetalleSalida ds = null;
        String statement = "SELECT Item_idItem, PeticionSalida_idPeticionSalida, cantidad FROM detallesalida "
                + "WHERE Item_idItem = ? AND PeticionSalida_idPeticionSalida = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, idItem);
            ps.setInt(2, idPeticion);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ds = new DetalleSalida();
                    ds.setIdItem(rs.getInt("Item_idItem"));
                    ds.setIdPeticionSalida(rs.getInt("PeticionSalida_idPeticionSalida"));
                    ds.setCantidad(rs.getInt("cantidad"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleSalidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }

    @Override
    public int eliminar(int id){
        return 0;
    }
    
    public int eliminar(int idItem, int idPeticion) {

        int valor = 0;
        String statement = "DELETE FROM detallesalida WHERE Item_idItem = ? AND PeticionSalida_idPeticionSalida = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setInt(1, idItem);
            ps.setInt(2, idPeticion);
            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DetalleSalidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public int modificar(DetalleSalida detalle) {
        int valor = 0;
        String statement = "UPDATE detallesalida SET cantidad = ? "
                + "WHERE Item_idItem = ? AND PeticionSalida_idPeticionSalida = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, detalle.getCantidad());
            ps.setInt(2, detalle.getIdItem());
            ps.setInt(3, detalle.getIdPeticionSalida());

            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DetalleSalidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

}
