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
import proyectobd2.modelo.beans.Empleado;

/**
 *
 * @author endri
 */
public class EmpleadoDAO implements DAOInterfaz<Empleado> {

    @Override
    public int insertar(Empleado empleado) {
        int valor = 0;
        String statement = "INSERT INTO empleado (nombre, apellidos, correoElectronico, telefonoFijo, telefonoCelular, fechaRegistro, contrasenia) VALUES (?,?,?,?,?,?,?)";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellidos());
            ps.setString(3, empleado.getCorreoElectronico());
            ps.setString(4, empleado.getTelefonoFijo());
            ps.setString(5, empleado.getTelefonoCelular());
            ps.setDate(6, new java.sql.Date(empleado.getFechaRegistro().getTime()));
            ps.setString(7, empleado.getContrasenia());

            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public List<Empleado> obtenerListaObjetos() throws SQLException {
        List<Empleado> listaEmpleados = new ArrayList<>();
        String statement = "SELECT idEmpleado, nombre, apellidos, correoElectronico, telefonoFijo, telefonoCelular, fechaRegistro, contrasenia FROM empleado";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Empleado e = new Empleado();
                e.setIdEmpleado(rs.getInt("idEmpleado"));
                e.setNombre(rs.getString("nombre"));
                e.setApellidos(rs.getString("apellidos"));
                e.setCorreoElectronico(rs.getString("correoElectronico"));
                e.setTelefonoFijo(rs.getString("telefonoFijo"));
                e.setTelefonoCelular(rs.getString("telefonoCelular"));
                e.setFechaRegistro(rs.getDate("fechaRegistro"));
                e.setContrasenia(rs.getString("contrasenia"));

                listaEmpleados.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaEmpleados;
    }

    @Override
    public Empleado buscar(int idEmpleado) throws SQLException {
        Empleado e = null;
        String statement = "SELECT idEmpleado, nombre, apellidos, correoElectronico, telefonoFijo, telefonoCelular, fechaRegistro, contrasenia FROM empleado WHERE idEmpleado = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, idEmpleado);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    e = new Empleado();
                    e.setIdEmpleado(rs.getInt("idEmpleado"));
                    e.setNombre(rs.getString("nombre"));
                    e.setApellidos(rs.getString("apellidos"));
                    e.setCorreoElectronico(rs.getString("correoElectronico"));
                    e.setTelefonoFijo(rs.getString("telefonoFijo"));
                    e.setTelefonoCelular(rs.getString("telefonoCelular"));
                    e.setFechaRegistro(rs.getDate("fechaRegistro"));
                    e.setContrasenia(rs.getString("contrasenia"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    @Override
    public int eliminar(int idEmpleado) {
        int valor = 0;
        String statement = "DELETE FROM empleado WHERE idEmpleado = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, idEmpleado);
            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    @Override
    public int modificar(Empleado e) {
        int valor = 0;
        String statement = "UPDATE empleado SET nombre = ?, apellidos = ?, correoElectronico = ?, telefonoFijo = ?, telefonoCelular = ?, fechaRegistro = ?, contrasenia =? WHERE idEmpleado = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellidos());
            ps.setString(3, e.getCorreoElectronico());
            ps.setString(4, e.getTelefonoFijo());
            ps.setString(5, e.getTelefonoCelular());
            ps.setDate(6, new java.sql.Date(e.getFechaRegistro().getTime()));
            ps.setString(7, e.getContrasenia());
            ps.setInt(8, e.getIdEmpleado());

            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
}
