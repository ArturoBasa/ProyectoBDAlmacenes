/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobd2.modelo.beans;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author endri
 */
public class PeticionSalida {

    private Integer idPeticionSalida;
    private Date fecha;
    private Empleado empleado;

    public PeticionSalida() {
    }

    public Integer getIdPeticionSalida() {
        return idPeticionSalida;
    }

    public void setIdPeticionSalida(Integer idPeticionSalida) {
        this.idPeticionSalida = idPeticionSalida;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

}
