/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCrudMVC;

import controller.CrlProducto;
import model.ConsultasProducto;
import model.Producto;
import view.frmProducto;

/**
 *
 * @author phoenix055
 */
public class Main {
    public static void main(String[] args) {
        //
        Producto prod = new Producto();
        ConsultasProducto prodC = new ConsultasProducto();
        frmProducto frm = new frmProducto();
        CrlProducto ctrl = new CrlProducto(prod, prodC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
    }
}
