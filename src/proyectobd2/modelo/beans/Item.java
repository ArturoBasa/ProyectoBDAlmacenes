/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobd2.modelo.beans;

/**
 *
 * @author endri
 */
public class Item {

    private int idItem;
    private int existencias;
    private int StockMinimo;
    private int StockMaximo;
    private String nombreItem;
    private Double precioUnitario;
    private int idPartidaPresupuestal;
    private int idSucursal;
    private String estado;
    private String descripcionUso;

    public Item() {
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public int getStockMinimo() {
        return StockMinimo;
    }

    public void setStockMinimo(int StockMinimo) {
        this.StockMinimo = StockMinimo;
    }

    public int getStockMaximo() {
        return StockMaximo;
    }

    public void setStockMaximo(int StockMaximo) {
        this.StockMaximo = StockMaximo;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getIdPartidaPresupuestal() {
        return idPartidaPresupuestal;
    }

    public void setIdPartidaPresupuestal(int idPartidaPresupuestal) {
        this.idPartidaPresupuestal = idPartidaPresupuestal;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcionUso() {
        return descripcionUso;
    }

    public void setDescripcionUso(String descripcion) {
        this.descripcionUso = descripcion;
    }

}
