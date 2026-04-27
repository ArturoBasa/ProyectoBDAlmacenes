/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobd2.modelo.beans;

/**
 *
 * @author endri
 */
public class PartidaPresupuestal {

    private Integer partidaPresupuestal;
    private String nombrePartida;
    private Double presupuesto;

    public PartidaPresupuestal() {
    }

    public Integer getPartidaPresupuestal() {
        return partidaPresupuestal;
    }

    public void setPartidaPresupuestal(Integer partidaPresupuestal) {
        this.partidaPresupuestal = partidaPresupuestal;
    }

    public String getNombrePartida() {
        return nombrePartida;
    }

    public void setNombrePartida(String nombrePartida) {
        this.nombrePartida = nombrePartida;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

}
