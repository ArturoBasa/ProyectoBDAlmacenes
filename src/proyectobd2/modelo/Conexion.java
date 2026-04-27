/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobd2.modelo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Clase diseñada para realizar una conexión al manejador de base de datos MySQL
 * bajo el esquema de conexión directa mediante JDBC. Esta clase está construida
 * bajo el patrón Singleton, cuyo objetivo es que se cree unicamente UNA
 * instancia de la clase, en este caso si ya existe una conexión a la base de
 * datos esta se reutilizará hasta que sea cerrada.
 *
 * @author endri
 */
public class Conexion {

    private Connection conn;
    private String host;
    private String db;
    private String username;
    private String password;
    private String url;

    private static Conexion conexion;

    public Conexion() {
        try (InputStream input = Conexion.class.getClassLoader().getResourceAsStream("database.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find database properties.");
            }
            Properties prop = new Properties();
            prop.load(input);
            url = prop.getProperty("db.url");
            username = prop.getProperty("db.user");
            password = prop.getProperty("db.password");
        } catch (IOException ex) {
            throw new RuntimeException("Failed to load database properties", ex);
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conexion a BD establecida");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Se produjo un error inesperado: " + e.getMessage());
        }
        conexion = this;
    }

    
    public Conexion(String host, String db, String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.host = host;
        this.db = db;
        this.username = username;
        this.password = password;
        conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + db, username, password);
        conexion = this;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConnection() {
        return conn;
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
        }
    }

    public static Conexion getConexion() {
        return conexion;

    }

    public static void setConexion(Conexion conexion) {
        Conexion.conexion = conexion;
    }
}
