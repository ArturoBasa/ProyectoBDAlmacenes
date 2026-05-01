/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobd2.modelo.beans;

/**
 *
 * @author endri
 */
public class DetalleSalida {

    private int idItem;
    private int idPeticionSalida;
    private int cantidad;

    public DetalleSalida() {
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdPeticionSalida() {
        return idPeticionSalida;
    }

    public void setIdPeticionSalida(int idPeticionSalida) {
        this.idPeticionSalida = idPeticionSalida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
