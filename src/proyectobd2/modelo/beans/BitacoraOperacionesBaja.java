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
public class BitacoraOperacionesBaja {

    private int idBitacoraOperacionesBaja;
    private Date fecha;
    private String razonBaja;
    private String descripcion;
    private int cantidadSobrante;
    private int idItem;

    public BitacoraOperacionesBaja() {
    }

    public int getIdBitacoraOperacionesBaja() {
        return idBitacoraOperacionesBaja;
    }

    public void setIdBitacoraOperacionesBaja(int idBitacoraOperacionesBaja) {
        this.idBitacoraOperacionesBaja = idBitacoraOperacionesBaja;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRazonBaja() {
        return razonBaja;
    }

    public void setRazonBaja(String razonBaja) {
        this.razonBaja = razonBaja;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadSobrante() {
        return cantidadSobrante;
    }

    public void setCantidadSobrante(int cantidadSobrante) {
        this.cantidadSobrante = cantidadSobrante;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    
}
