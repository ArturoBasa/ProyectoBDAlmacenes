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
public class BitacoraOperacionesBaja {

    private Integer idBitacoraOperacionesBaja;
    private LocalDate fecha;
    private String razonBaja;
    private String descripcion;
    private Integer cantidadSobrante;
    private Item item;

    public BitacoraOperacionesBaja() {
    }

    public Integer getIdBitacoraOperacionesBaja() {
        return idBitacoraOperacionesBaja;
    }

    public void setIdBitacoraOperacionesBaja(Integer idBitacoraOperacionesBaja) {
        this.idBitacoraOperacionesBaja = idBitacoraOperacionesBaja;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
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

    public Integer getCantidadSobrante() {
        return cantidadSobrante;
    }

    public void setCantidadSobrante(Integer cantidadSobrante) {
        this.cantidadSobrante = cantidadSobrante;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
