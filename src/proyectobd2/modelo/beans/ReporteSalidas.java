/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobd2.modelo.beans;

/**
 *
 * @author basa2
 */
public class ReporteSalidas {
    private String fecha;
    private String departamento; 
    private String encargado; 
    private String descripcion; 
    private int idSucursal; 
    private String articulo;
    private String partidaPresupuestal;
    private int catidad;
    private double precioUnitario;
    private double subtotal;
    

    public ReporteSalidas() {
    }

    
    public ReporteSalidas(String fecha, String departamento, String encargado, String descripcion, int idSucursal, String articulo, String partidaPresupuestal, int catidad, double precioUnitario, double subtotal) {
        this.fecha = fecha;
        this.departamento = departamento;
        this.encargado = encargado;
        this.descripcion = descripcion;
        this.idSucursal = idSucursal;
        this.articulo = articulo;
        this.partidaPresupuestal = partidaPresupuestal;
        this.catidad = catidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public int getCatidad() {
        return catidad;
    }

    public void setCatidad(int catidad) {
        this.catidad = catidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getPartidaPresupuestal() {
        return partidaPresupuestal;
    }

    public void setPartidaPresupuestal(String partidaPresupuestal) {
        this.partidaPresupuestal = partidaPresupuestal;
    }
    
    
}
