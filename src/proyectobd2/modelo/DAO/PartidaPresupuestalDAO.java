/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobd2.modelo.DAO;

import proyectobd2.modelo.beans.PartidaPresupuestal;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import proyectobd2.modelo.Conexion;

public class PartidaPresupuestalDAO implements DAOInterfaz<PartidaPresupuestal> {

    @Override
    public int insertar(PartidaPresupuestal partida) {
        int valor = 0;
        String statement = "INSERT INTO partidapresupuestal (nombrePartida, presupuesto) values (?,?)";
        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setString(1, partida.getNombrePartida());
            ps.setDouble(2, partida.getPresupuesto());
            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PartidaPresupuestalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public List<PartidaPresupuestal> obtenerListaObjetos() throws SQLException {
        List<PartidaPresupuestal> listaPartidas = new ArrayList<>();
        String statement = "SELECT idPartidaPresupuestal, nombrePartida, presupuesto FROM partidapresupuestal";
        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                PartidaPresupuestal p = new PartidaPresupuestal();
                p.setIdPartidaPresupuestal(rs.getInt("idPartidaPresupuestal"));
                p.setNombrePartida(rs.getString("nombrePartida"));
                p.setPresupuesto(rs.getDouble("presupuesto"));
                listaPartidas.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PartidaPresupuestalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPartidas;
    }

    @Override
    public PartidaPresupuestal buscar(int idPartida) throws SQLException {
        PartidaPresupuestal p = null;
        String statement = "SELECT idPartidaPresupuestal, nombrePartida, presupuesto FROM partidapresupuestal WHERE idPartidaPresupuestal = ?";
        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setInt(1, idPartida);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    p = new PartidaPresupuestal();
                    p.setIdPartidaPresupuestal(rs.getInt("idPartidaPresupuestal"));
                    p.setNombrePartida(rs.getString("nombrePartida"));
                    p.setPresupuesto(rs.getDouble("presupuesto"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PartidaPresupuestalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public int eliminar(int idPartida) {
        int valor = 0;
        String statement = "DELETE FROM partidapresupuestal WHERE idPartidaPresupuestal=?";
        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setInt(1, idPartida);
            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PartidaPresupuestalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public int modificar(PartidaPresupuestal partida) {
        int valor = 0;
        String statement = "UPDATE partidapresupuestal SET nombrePartida=?, presupuesto=? WHERE idPartidaPresupuestal=?";
        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setString(1, partida.getNombrePartida());
            ps.setDouble(2, partida.getPresupuesto());
            ps.setInt(3, partida.getIdPartidaPresupuestal());
            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PartidaPresupuestalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
}
