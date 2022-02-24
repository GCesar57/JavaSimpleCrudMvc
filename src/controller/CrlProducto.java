package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import model.ConsultasProducto;
import model.Producto;
import view.frmProducto;

/**
 *
 * @author phoenix055
 */
public class CrlProducto implements ActionListener{
    private Producto mod;
    private ConsultasProducto modC;
    private frmProducto frm;
    //
    public CrlProducto(){}//
    public CrlProducto(Producto mod, ConsultasProducto modC, frmProducto frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        //Actions para los botones
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
    }
    //
    //Metodo para poder iniciar la vista...
    public void iniciar(){
        frm.setTitle("Productos.");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);
    }//
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frm.btnGuardar){
            //Tomar los valores de la caja de texto para madarlos al modelo...
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            //
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String startDateString = dateFormat.format(frm.jDateChooser1.getDate());
            mod.setFecha(startDateString);
            //
            if(modC.registrar(mod)){
                JOptionPane.showMessageDialog(null, "Registro Insertado con exito...");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error Insertado con exito...");
                limpiar();
            }//
        }//
        //
        //Modificar...
        if(e.getSource()==frm.btnModificar){
            //Tomar los valores de la caja de texto para madarlos al modelo...
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            //
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String startDateString = dateFormat.format(frm.jDateChooser1.getDate());
            mod.setFecha(startDateString);
            //
            if(modC.modificar(mod)){
                JOptionPane.showMessageDialog(null, "Registro Modificado con exito...");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error Modificando con exito...");
                limpiar();
            }//
        }//
        //
        //Eliminar
        if(e.getSource()==frm.btnEliminar){
            //Tomar los valores de la caja de texto para madarlos al modelo...
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            //
            if(modC.eliminar(mod)){
                JOptionPane.showMessageDialog(null, "Registro Eliminado con exito...");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error Eliminando con exito...");
                limpiar();
            }//
        }//
        //
        //Buscar....
        if(e.getSource()==frm.btnBuscar){
            mod.setCodigo(frm.txtCodigo.getText());
            //
            if(modC.buscar(mod)){
                frm.txtId.setText(String.valueOf(mod.getId()));
                frm.txtCodigo.setText(mod.getCodigo());
                frm.txtNombre.setText(mod.getNombre());
                frm.txtPrecio.setText(String.valueOf(mod.getPrecio()));
                frm.txtCantidad.setText(String.valueOf(mod.getCantidad()));
                frm.jDateChooser1.setDate(Date.valueOf(mod.getFecha()));
            }else{
                JOptionPane.showMessageDialog(null, "Error no se encontro resultado...");
                //limpiar();
            }//
        }//
        if(e.getSource()==frm.btnLimpiar){limpiar();}//
    }
    //Limpiar formulario
    public void limpiar(){
        frm.txtCodigo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtPrecio.setText(null);
        frm.txtCantidad.setText(null);
        frm.jDateChooser1.setDate(null);
    }//
    
}
