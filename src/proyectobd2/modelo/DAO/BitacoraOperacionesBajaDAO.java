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
import proyectobd2.modelo.beans.BitacoraOperacionesBaja;

/**
 *
 * @author endri
 */
public class BitacoraOperacionesBajaDAO implements DAOInterfaz<BitacoraOperacionesBaja> {

    @Override
    public int insertar(BitacoraOperacionesBaja bitacora) {
        int valor = 0;
        String statement = "INSERT INTO bitacoraoperacionesbajas (fecha, razonBaja, descripcion, cantidadSobrante, Item_idItem) VALUES (?,?,?,?,?)";
        
        try (Connection conn = new Conexion().getConnection();
             PreparedStatement ps = conn.prepareStatement(statement)) {
            
            ps.setDate(1, new java.sql.Date(bitacora.getFecha().getTime()));
            ps.setString(2, bitacora.getRazonBaja());
            ps.setString(3, bitacora.getDescripcion());
            ps.setInt(4, bitacora.getCantidadSobrante());
            ps.setInt(5, bitacora.getIdItem());
            
            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BitacoraOperacionesBajaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public List<BitacoraOperacionesBaja> obtenerListaObjetos() throws SQLException {
        List<BitacoraOperacionesBaja> listaBitacora = new ArrayList<>();
        String statement = "SELECT idBitacoraOperacionesBajas, fecha, razonBaja, descripcion, cantidadSobrante, Item_idItem FROM bitacoraoperacionesbajas";
        
        try (Connection conn = new Conexion().getConnection();
             PreparedStatement ps = conn.prepareStatement(statement);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                BitacoraOperacionesBaja b = new BitacoraOperacionesBaja();
                b.setIdBitacoraOperacionesBaja(rs.getInt("idBitacoraOperacionesBajas"));
                b.setFecha(rs.getDate("fecha"));
                b.setRazonBaja(rs.getString("razonBaja"));
                b.setDescripcion(rs.getString("descripcion"));
                b.setCantidadSobrante(rs.getInt("cantidadSobrante"));
                b.setIdItem(rs.getInt("Item_idItem"));
                listaBitacora.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BitacoraOperacionesBajaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaBitacora;
    }

    @Override
    public BitacoraOperacionesBaja buscar(int idBitacora) throws SQLException {
        BitacoraOperacionesBaja b = null;
        String statement = "SELECT idBitacoraOperacionesBajas, fecha, razonBaja, descripcion, cantidadSobrante, Item_idItem FROM bitacoraoperacionesbajas WHERE idBitacoraOperacionesBajas = ?";
        
        try (Connection conn = new Conexion().getConnection();
             PreparedStatement ps = conn.prepareStatement(statement)) {
            
            ps.setInt(1, idBitacora);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    b = new BitacoraOperacionesBaja();
                    b.setIdBitacoraOperacionesBaja(rs.getInt("idBitacoraOperacionesBajas"));
                    b.setFecha(rs.getDate("fecha"));
                    b.setRazonBaja(rs.getString("razonBaja"));
                    b.setDescripcion(rs.getString("descripcion"));
                    b.setCantidadSobrante(rs.getInt("cantidadSobrante"));
                    b.setIdItem(rs.getInt("Item_idItem"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BitacoraOperacionesBajaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

    @Override
    public int eliminar(int idBitacora) {
        int valor = 0;
        String statement = "DELETE FROM bitacoraoperacionesbajas WHERE idBitacoraOperacionesBajas = ?";
        
        try (Connection conn = new Conexion().getConnection();
             PreparedStatement ps = conn.prepareStatement(statement)) {
            
            ps.setInt(1, idBitacora);
            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BitacoraOperacionesBajaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public int modificar(BitacoraOperacionesBaja b) {
        int valor = 0;
        String statement = "UPDATE bitacoraoperacionesbajas SET fecha = ?, razonBaja = ?, descripcion = ?, cantidadSobrante = ?, Item_idItem = ? WHERE idBitacoraOperacionesBajas = ?";
        
        try (Connection conn = new Conexion().getConnection();
             PreparedStatement ps = conn.prepareStatement(statement)) {
            
            ps.setDate(1, new java.sql.Date(b.getFecha().getTime()));
            ps.setString(2, b.getRazonBaja());
            ps.setString(3, b.getDescripcion());
            ps.setInt(4, b.getCantidadSobrante());
            ps.setInt(5, b.getIdItem());
            ps.setInt(6, b.getIdBitacoraOperacionesBaja());
            
            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BitacoraOperacionesBajaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
}
