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
public class BitacoraPedidos {

    private Integer idBitacoraPedidos;
    private LocalDate fecha;
    private Integer cantidadPedir;
    private Item itemPedir;

    public BitacoraPedidos() {
    }

    public Integer getIdBitacoraPedidos() {
        return idBitacoraPedidos;
    }

    public void setIdBitacoraPedidos(Integer idBitacoraPedidos) {
        this.idBitacoraPedidos = idBitacoraPedidos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidadPedir() {
        return cantidadPedir;
    }

    public void setCantidadPedir(Integer cantidadPedir) {
        this.cantidadPedir = cantidadPedir;
    }

    public Item getItemPedir() {
        return itemPedir;
    }

    public void setItemPedir(Item itemPedir) {
        this.itemPedir = itemPedir;
    }

}
