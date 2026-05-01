/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobd2.modelo.beans;

import java.util.Date;

/**
 *
 * @author endri
 */
public class PeticionSalida {

    private int idPeticionSalida;
    private Date fecha;
    private int idEmpleadoAlmacen;

    public PeticionSalida() {
    }

    public int getIdPeticionSalida() {
        return idPeticionSalida;
    }

    public void setIdPeticionSalida(int idPeticionSalida) {
        this.idPeticionSalida = idPeticionSalida;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdEmpleadoAlmacen() {
        return idEmpleadoAlmacen;
    }

    public void setIdEmpleadoAlmacen(int idEmpleadoAlmacen) {
        this.idEmpleadoAlmacen = idEmpleadoAlmacen;
    }

}
