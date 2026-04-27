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

    private Item item;
    private PeticionSalida peticionSalida;
    private Integer cantidad;

    public DetalleSalida() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public PeticionSalida getPeticionSalida() {
        return peticionSalida;
    }

    public void setPeticionSalida(PeticionSalida peticionSalida) {
        this.peticionSalida = peticionSalida;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}
