/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectobd2.modelo.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author endri
 */
public interface DAOInterfaz<T> {

    public int insertar(T objeto);

    public List<T> obtenerListaObjetos() throws SQLException;          
    
    public T buscar(int id) throws SQLException;

    public int eliminar(int id);

    public int modificar(T objeto);
}
