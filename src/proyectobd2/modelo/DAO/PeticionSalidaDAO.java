/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobd2.modelo.DAO;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import proyectobd2.modelo.Conexion;
import proyectobd2.modelo.beans.PeticionSalida;

public class PeticionSalidaDAO {

    public static int insertar(PeticionSalida peticion) {
        int idGenerado = 0;
        String statement = "INSERT INTO peticionsalida (fecha, idEmpleadoAlmacen, idEstadoPeticion) values (?,?,?)";
        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement, java.sql.Statement.RETURN_GENERATED_KEYS)) {
            ps.setDate(1, new java.sql.Date(peticion.getFecha().getTime()));
            ps.setInt(2, peticion.getIdEmpleadoAlmacen());
            ps.setInt(3, peticion.getIdEstadoPeticion());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    idGenerado = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PeticionSalidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idGenerado;
    }

    public static List<PeticionSalida> obtenerListaObjetos() throws SQLException {
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

    public static PeticionSalida buscar(int idPeticion) throws SQLException {
        return null;
    }

    public static List<Object[]> buscar(String departamento, int idSucursal) throws SQLException {
        List<Object[]> listaFilas = new ArrayList<>();
        String statement = "SELECT DISTINCT fecha , departamento , encargado , descripcion FROM salidasView WHERE idSucursal = ? AND LOWER(departamento) LIKE LOWER(?)";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setInt(1, idSucursal);
            ps.setString(2, departamento + "%");

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

    public static List<Object[]> buscarGlobal(String departamento) throws SQLException {
        List<Object[]> listaFilas = new ArrayList<>();
        String statement = "SELECT DISTINCT v.fecha , v.departamento , v.encargado , v.descripcion, s.nombreSucursal FROM salidasView v JOIN sucursal s ON v.idSucursal = s.idSucursal WHERE LOWER(v.departamento) LIKE LOWER(?)";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setString(1, departamento + "%");

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
            Logger.getLogger(PeticionSalidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaFilas;
    }

    public static int eliminar(int idPeticion) {
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

    public static int modificar(PeticionSalida peticion) {
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

    public static List<Object[]> obtenerSalidas(int idSucursal, String tipo) {
        List<Object[]> listaFilas = new ArrayList<>();
        String statement;
        if (tipo.equalsIgnoreCase("Pendiente")) {
            statement = "SELECT DISTINCT fecha , departamento , encargado , descripcion FROM salidasView WHERE idSucursal = ? AND descripcion = 'EN ESPERA'";
        } else {
            statement = "SELECT DISTINCT fecha , departamento , encargado , descripcion FROM salidasView WHERE idSucursal = ?";
        }

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

    public static List<Object[]> obtenerSalidasGlobales() {
        List<Object[]> listaFilas = new ArrayList<>();
        String statement = "SELECT DISTINCT v.fecha , v.departamento , "
                + "v.encargado , v.descripcion, s.nombreSucursal "
                + "FROM salidasView v JOIN sucursal s ON v.idSucursal = s.idSucursal";

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
            Logger.getLogger(PeticionSalidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaFilas;
    }

    public static List<Object[]> obtenerArticulosDepartamento(String departamento) {
        List<Object[]> listaFilas = new ArrayList<>();
        String statement = "SELECT item, cantidad, sucursal FROM itemPorDepartamento WHERE departamento = ?";

        try (Connection conn = new Conexion().getConnection(); PreparedStatement ps = conn.prepareStatement(statement)) {
            ps.setString(1, departamento);
            try (ResultSet rs = ps.executeQuery()) {
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
