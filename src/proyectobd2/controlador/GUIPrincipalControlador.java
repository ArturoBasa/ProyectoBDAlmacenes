/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobd2.controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import proyectobd2.vista.GUIPrincipal;
/**
 *
 * @author basa2
 */
public class GUIPrincipalControlador implements ActionListener{
    private GUIPrincipal vista;
    
    public GUIPrincipalControlador(GUIPrincipal vista){
        this.vista = vista;
        
        this.vista.btnEntradas.addActionListener(this);
        this.vista.btnSalidas.addActionListener(this);
        this.vista.btnInventario.addActionListener(this);
        this.vista.btnKardex.addActionListener(this);
        this.vista.btnReportes.addActionListener(this);
        this.vista.btnCatalogos.addActionListener(this);
        this.vista.btnCerrarSesion.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnEntradas) {
            vista.cambiarVista("CARD_ENTRADAS");      
        }
        if (e.getSource() == vista.btnSalidas) {
            vista.cambiarVista("CARD_SALIDAS");
        }
        if (e.getSource() == vista.btnInventario) {
            vista.cambiarVista("CARD_SALIDAS");
        }
        if (e.getSource() == vista.btnKardex) {
            vista.cambiarVista("CARD_SALIDAS");
        }
        if (e.getSource() == vista.btnReportes) {
            vista.cambiarVista("CARD_SALIDAS");
        }
        if (e.getSource() == vista.btnCatalogos) {
            vista.cambiarVista("CARD_SALIDAS");
        }
        if (e.getSource() == vista.btnCerrarSesion){
            cerrarSesion();
        }
    }
    
    private void cerrarSesion() {
        vista.dispose();
    }
}
