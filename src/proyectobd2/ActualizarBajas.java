package proyectobd2;

import java.sql.Connection;
import java.sql.Statement;
import proyectobd2.modelo.Conexion;

public class ActualizarBajas {
    public static void main(String[] args) {
        try (Connection conn = new Conexion().getConnection();
             Statement stmt = conn.createStatement()) {
            
            String sql1 = "ALTER TABLE bitacoraoperacionesbajas MODIFY COLUMN descripcion VARCHAR(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL;";
            stmt.executeUpdate(sql1);
            System.out.println("Columna 'descripcion' actualizada a VARCHAR(255).");
            
            String sql2 = "ALTER TABLE bitacoraoperacionesbajas MODIFY COLUMN razonBaja VARCHAR(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL;";
            stmt.executeUpdate(sql2);
            System.out.println("Columna 'razonBaja' actualizada a VARCHAR(100).");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
