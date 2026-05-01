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
import proyectobd2.modelo.beans.Departamento;

/**
 *
 * @author endri
 */
public class DepartamentoDAO implements DAOInterfaz<Departamento> {

    @Override
    public int insertar(Departamento departamento) {
        int valor = 0;
        // Nota: He omitido Sucursal_idSucursal porque no está en tu Bean.
        String statement = "INSERT INTO departamento (nombreDepartamento, Sucursal_idSucursal, Empleado_idEncargado) VALUES (?,?,?)";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setString(1, departamento.getNombreDepartamento());
            ps.setInt(2, departamento.getIdSucursal());
            ps.setInt(3, departamento.getIdEncargado());

            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public List<Departamento> obtenerListaObjetos() throws SQLException {
        List<Departamento> listaDepartamentos = new ArrayList<>();
        String statement = "SELECT idDepartamento, nombreDepartamento, Sucursal_idSucursal, Empleado_idEncargado FROM departamento";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Departamento d = new Departamento();
                d.setIdDepartamento(rs.getInt("idDepartamento"));
                d.setNombreDepartamento(rs.getString("nombreDepartamento"));
                d.setIdSucursal(rs.getInt("Sucursal_idSucursal"));
                d.setIdEncargado(rs.getInt("Empleado_idEncargado"));
                listaDepartamentos.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDepartamentos;
    }

    @Override
    public Departamento buscar(int idDepartamento) throws SQLException {
        Departamento d = null;
        String statement = "SELECT idDepartamento, nombreDepartamento, Sucursal_idSucursal, Empleado_idEncargado FROM departamento WHERE idDepartamento = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, idDepartamento);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    d = new Departamento();
                    d.setIdDepartamento(rs.getInt("idDepartamento"));
                    d.setNombreDepartamento(rs.getString("nombreDepartamento"));
                    d.setIdSucursal(rs.getInt("Sucursal_idDepartamento"));
                    d.setIdEncargado(rs.getInt("Empleado_idEncargado"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    @Override
    public int eliminar(int idDepartamento) {
        int valor = 0;
        String statement = "DELETE FROM departamento WHERE idDepartamento = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, idDepartamento);
            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public int modificar(Departamento d) {
        int valor = 0;
        String statement = "UPDATE departamento SET nombreDepartamento = ?, Sucursal_idSucursal = ?, Empleado_idEncargado = ? WHERE idDepartamento = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setString(1, d.getNombreDepartamento());
            ps.setInt(2, d.getIdEncargado());
            ps.setInt(3, d.getIdSucursal());
            ps.setInt(4, d.getIdDepartamento());

            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
}
