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
import proyectobd2.modelo.beans.Empleado;

/**
 *
 * @author endri
 */
public class EmpleadoDAO {

    public static Empleado login(String username, String contrasenia) throws SQLException {
        Empleado e = null;

        String statement = """
                    SELECT e.*, r.descripcion AS Rol, d.Sucursal_idSucursal as Sucursal
                    FROM empleado e 
                    JOIN rol r ON e.idRol = r.idRol
                    JOIN departamento d on e.idDepartamentoEncargado = d.idDepartamento
                    WHERE e.nombre = ? AND e.contrasenia = ?;
                     """;

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setString(1, username);
            ps.setString(2, contrasenia);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {

                    e = new Empleado();
                    e.setIdEmpleado(rs.getInt("idEmpleado"));
                    e.setNombre(rs.getString("nombre"));
                    e.setApellidos(rs.getString("apellidos"));
                    e.setCorreoElectronico(rs.getString("correoElectronico"));
                    e.setTelefonoFijo(rs.getString("telefonoFijo"));
                    e.setTelefonoCelular(rs.getString("telefonoCelular"));
                    e.setFechaRegistro(rs.getDate("fechaRegistro"));
                    e.setContrasenia(rs.getString("contrasenia"));
                    e.setIdSucursal(rs.getInt("Sucursal"));
                    e.setRol(rs.getString("Rol"));

                }

            }
        }
        if (e != null) {

            return e;
        }
        return null;
    }

    public static int insertar(Empleado empleado) {
        int valor = 0;
        String statement = "INSERT INTO empleado (nombre, apellidos, correoElectronico, telefonoFijo, telefonoCelular, fechaRegistro, contrasenia,idDepartamentoEncargado, idRol, estado) VALUES (?,?,?,?,?,?,?,?,?,'ACTIVO')";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellidos());
            ps.setString(3, empleado.getCorreoElectronico());
            ps.setString(4, empleado.getTelefonoFijo());
            ps.setString(5, empleado.getTelefonoCelular());
            ps.setDate(6, new java.sql.Date(empleado.getFechaRegistro().getTime()));
            ps.setString(7, empleado.getContrasenia());
            ps.setInt(8, empleado.getIdDepartamentoEncar());
            ps.setInt(9, empleado.getIdRol());

            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    public static List<Empleado> obtenerListaObjetos() throws SQLException {
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
    
    public static List<Empleado> obtenerListaUsuarios() throws SQLException {
        List<Empleado> listaEmpleados = new ArrayList<>();
        String statement = "SELECT e.idEmpleado, e.nombre, e.apellidos, e.correoElectronico, "
                         + "e.telefonoFijo, e.telefonoCelular, e.fechaRegistro, e.contrasenia, e.estado, "
                         + "e.idDepartamentoEncargado, e.idRol, d.idDepartamento, d.nombreDepartamento, "
                         + "d.Sucursal_idSucursal, d.Empleado_idEncargado, s.nombreSucursal, s.idSucursal "
                         + "FROM empleado e "
                         + "INNER JOIN departamento d ON e.idDepartamentoEncargado = d.idDepartamento "
                         + " INNER JOIN sucursal s ON d.Sucursal_idSucursal = s.idSucursal"
                         + " WHERE e.estado = 'ACTIVO';";

        try (Connection conn = new Conexion().getConnection();
            PreparedStatement ps = conn.prepareStatement(statement)) {
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
                e.setIdRol(rs.getInt("idRol"));
                e.setSucursal(rs.getString("s.nombreSucursal"));
                e.setIdSucursal(rs.getInt("s.idSucursal"));

                Departamento d = new Departamento();
                d.setIdDepartamento(rs.getInt("idDepartamento"));
                d.setNombreDepartamento(rs.getString("nombreDepartamento"));
                d.setIdSucursal(rs.getInt("Sucursal_idSucursal"));
                d.setIdEncargado(rs.getInt("Empleado_idEncargado"));
                e.setDepartamento(d); 
                listaEmpleados.add(e);
            }
        }
        return listaEmpleados;
    }
    
    public static List<Empleado> obtenerListaUsuariosPorID(int idSucursal) throws SQLException {
        List<Empleado> listaEmpleados = new ArrayList<>();
        String statement = "SELECT e.idEmpleado, e.nombre, e.apellidos, e.correoElectronico, "
                         + "e.telefonoFijo, e.telefonoCelular, e.fechaRegistro, e.contrasenia, "
                         + "e.idDepartamentoEncargado, e.idRol, d.idDepartamento, d.nombreDepartamento, e.estado,"
                         + "d.Sucursal_idSucursal, d.Empleado_idEncargado, s.nombreSucursal, s.idSucursal, r.descripcion "
                         + "FROM empleado e "
                         + " INNER JOIN departamento d ON e.idDepartamentoEncargado = d.idDepartamento "
                         + " INNER JOIN sucursal s ON d.Sucursal_idSucursal = s.idSucursal"
                         + " INNER JOIN rol r ON e.idRol = r.idRol "
                         + " WHERE d.Sucursal_idSucursal = ? "
                         + " AND e.estado = 'ACTIVO';";

        try (Connection conn = new Conexion().getConnection(); 
             PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, idSucursal);

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
                e.setIdRol(rs.getInt("idRol"));
                e.setSucursal(rs.getString("s.nombreSucursal"));
                e.setIdSucursal(rs.getInt("s.idSucursal"));
                e.setDescripcionRol(rs.getString("r.descripcion"));

                Departamento d = new Departamento();
                d.setIdDepartamento(rs.getInt("idDepartamento"));
                d.setNombreDepartamento(rs.getString("nombreDepartamento"));
                d.setIdSucursal(rs.getInt("Sucursal_idSucursal"));
                d.setIdEncargado(rs.getInt("Empleado_idEncargado"));
                e.setDepartamento(d); 
                listaEmpleados.add(e);
            }
        }
        return listaEmpleados;
    }
    
    public static Empleado buscar(int idEmpleado) throws SQLException {
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

    public static int eliminar(int idEmpleado) {
        int valor = 0;
        String statement = "UPDATE empleado SET estado = 'INACTIVO' WHERE idEmpleado = ?;";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setInt(1, idEmpleado);
            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    public static int modificarsincontra(Empleado e) {
        int valor = 0;
        String statement = "UPDATE empleado SET nombre = ?, apellidos = ?, correoElectronico = ?, telefonoFijo = ?, telefonoCelular = ?, idDepartamentoEncargado = ?, idRol = ? WHERE idEmpleado = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellidos());
            ps.setString(3, e.getCorreoElectronico());
            ps.setString(4, e.getTelefonoFijo());
            ps.setString(5, e.getTelefonoCelular());
            ps.setInt(6, e.getIdDepartamentoEncar());
            ps.setInt(7, e.getIdRol());
            ps.setInt(8, e.getIdEmpleado());

            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
    
    public static int modificarConCOntra(Empleado e) {
        int valor = 0;
        String statement = "UPDATE empleado SET nombre = ?, apellidos = ?, correoElectronico = ?, telefonoFijo = ?, telefonoCelular = ?, contrasenia =?, idDepartamentoEncargado = ?, idRol = ? WHERE idEmpleado = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellidos());
            ps.setString(3, e.getCorreoElectronico());
            ps.setString(4, e.getTelefonoFijo());
            ps.setString(5, e.getTelefonoCelular());
            ps.setString(6, e.getContrasenia());
            ps.setInt(7, e.getIdDepartamentoEncar());
            ps.setInt(8, e.getIdRol());
            ps.setInt(9, e.getIdEmpleado());

            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
}
