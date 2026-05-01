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
public class BitacoraPedidos {

    private int idBitacoraPedidos;
    private Date fecha;
    private int cantidadPedir;
    private int idItem;

    public BitacoraPedidos() {
    }

    public int getIdBitacoraPedidos() {
        return idBitacoraPedidos;
    }

    public void setIdBitacoraPedidos(int idBitacoraPedidos) {
        this.idBitacoraPedidos = idBitacoraPedidos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidadPedir() {
        return cantidadPedir;
    }

    public void setCantidadPedir(int cantidadPedir) {
        this.cantidadPedir = cantidadPedir;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

}
