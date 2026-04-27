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

    private Integer idItem;
    private Integer existencias;
    private Integer StockMinimo;
    private Integer StockMaximo;
    private String nombreItem;
    private Double precioUnitario;
    private Integer idPartidaPresupuestal;
    private Integer idSucursal;
    private String estado;
    private String descripcion;

    public Item() {
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Integer getExistencias() {
        return existencias;
    }

    public void setExistencias(Integer existencias) {
        this.existencias = existencias;
    }

    public Integer getStockMinimo() {
        return StockMinimo;
    }

    public void setStockMinimo(Integer StockMinimo) {
        this.StockMinimo = StockMinimo;
    }

    public Integer getStockMaximo() {
        return StockMaximo;
    }

    public void setStockMaximo(Integer StockMaximo) {
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

    public Integer getIdPartidaPresupuestal() {
        return idPartidaPresupuestal;
    }

    public void setIdPartidaPresupuestal(Integer idPartidaPresupuestal) {
        this.idPartidaPresupuestal = idPartidaPresupuestal;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
