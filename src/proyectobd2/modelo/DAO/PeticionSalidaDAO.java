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
import proyectobd2.modelo.beans.PeticionSalida;

public class PeticionSalidaDAO implements DAOInterfaz<PeticionSalida> {

    @Override
    public int insertar(PeticionSalida peticion) {
        int valor = 0;
        String statement = "INSERT INTO peticionsalida (fecha, idEmpleadoAlmacen) values (?,?)";
        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setDate(1, new java.sql.Date(peticion.getFecha().getTime()));
            ps.setInt(2, peticion.getIdEmpleadoAlmacen());
            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PeticionSalidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public List<PeticionSalida> obtenerListaObjetos() throws SQLException {
        List<PeticionSalida> listaPeticiones = new ArrayList<>();
        String statement = "SELECT idPeticionSalida, fecha, idEmpleadoAlmacen FROM peticionsalida";
        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                PeticionSalida p = new PeticionSalida();
                p.setIdPeticionSalida(rs.getInt("idPeticionSalida"));
                p.setFecha(rs.getDate("fecha"));
                p.setIdEmpleadoAlmacen(rs.getInt("idEmpleadoAlmacen"));
                listaPeticiones.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PeticionSalidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPeticiones;
    }

    @Override
    public PeticionSalida buscar(int idPeticion) throws SQLException {
        PeticionSalida p = null;
        String statement = "SELECT idPeticionSalida, fecha, idEmpleadoAlmacen FROM peticionsalida WHERE idPeticionSalida= ?";
        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setInt(1, idPeticion);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    p = new PeticionSalida();
                    p.setIdPeticionSalida(rs.getInt("idPeticionSalida"));
                    p.setFecha(rs.getDate("fecha"));
                    p.setIdEmpleadoAlmacen(rs.getInt("idEmpleadoAlmacen"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PeticionSalidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public int eliminar(int idPeticion) {
        int valor = 0;
        String statement = "DELETE FROM peticionsalida WHERE idPeticionSalida=?";
        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setInt(1, idPeticion);
            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PeticionSalidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public int modificar(PeticionSalida peticion) {
        int valor = 0;
        String statement = "UPDATE peticionsalida SET fecha=?, idEmpleadoAlmacen=? WHERE idPeticionSalida=?";
        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setDate(1, new java.sql.Date(peticion.getFecha().getTime()));
            ps.setInt(2, peticion.getIdEmpleadoAlmacen());
            ps.setInt(3, peticion.getIdPeticionSalida());
            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PeticionSalidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
}
