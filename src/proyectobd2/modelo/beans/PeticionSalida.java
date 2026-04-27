/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobd2.modelo.beans;

import java.time.LocalDate;

/**
 *
 * @author endri
 */
public class PeticionSalida {

    private Integer idPeticionSalida;
    private LocalDate fecha;
    private Empleado empleado;

    public PeticionSalida() {
    }

    public Integer getIdPeticionSalida() {
        return idPeticionSalida;
    }

    public void setIdPeticionSalida(Integer idPeticionSalida) {
        this.idPeticionSalida = idPeticionSalida;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

}
