/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rbasu
 */
public class InternalFrame extends javax.swing.JInternalFrame {

TablaVerdad tabla_verdad = new TablaVerdad();

    public InternalFrame(String title) {
        
        initComponents();
        this.setTitle(title);
        this.setVisible(true);

    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        field = new javax.swing.JTextField();
        verificarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        minList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        maxList = new javax.swing.JList<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldActionPerformed(evt);
            }
        });

        verificarBtn.setText("Verificar");
        verificarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verificarBtnMouseClicked(evt);
            }
        });
        verificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarBtnActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        jLabel1.setText("Forma Canónica Disyuntiva");

        minList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(minList);

        jLabel2.setText("Forma Canónica Conjuntiva");

        maxList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(maxList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(field, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(verificarBtn))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane3))
                .addContainerGap(300, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verificarBtn))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verificarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verificarBtnMouseClicked
        String exp = this.field.getText();
        
//        this.tabla_verdad.setExpresion(exp);
        Expresion expresion = new Expresion(exp);
        
        if(expresion.validar_expresion(exp)==true){
             JOptionPane.showMessageDialog(null,"  Expresion Correcta!!");
             this.tabla_verdad.setExpresion(exp);
        }else{
           
             JOptionPane.showMessageDialog(null,"  Expresion Incorrecta!!");
        }
        tablaVerdad();
        mintermino();
        
    }//GEN-LAST:event_verificarBtnMouseClicked

    private void fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldActionPerformed

    private void verificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verificarBtnActionPerformed

    public void tablaVerdad(){
        System.out.println("Mostrando Tabla");
        DefaultTableModel model = new DefaultTableModel();
        
        model.setColumnIdentifiers(this.tabla_verdad.identifiers(this.field.getText()).toArray());
        
        
        model.setColumnCount(this.tabla_verdad.getCantidad_columnas());
        model.setRowCount(this.tabla_verdad.getCantidad_filas());
        
        this.table.setModel(model);

        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                this.table.setValueAt(this.tabla_verdad.obtener_posicion(i, j), i, j);
            }
        }
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i = 0; i < this.table.getColumnCount();i++){
            this.table.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }
    
    public void mintermino(){
        List variables = this.tabla_verdad.getVariables();
        List terminos = new ArrayList();
        String termino;
        
        for(int i = 0; i < table.getRowCount(); i++ ){ //Filas
            termino = "MIN" + i + " = ";
            
            for(int j = 0; j < variables.size(); j++){ //Columnas
                System.out.println("VALOR >> "+this.table.getValueAt(i, j));
                
                if(this.table.getValueAt(i, j).equals("V")){
                    termino += this.table.getColumnName(j) + "'";
                    
                    System.out.println(this.table.getColumnName(j) + "'");
                }else{
                    termino += this.table.getColumnName(j);
                    
                    System.out.println(this.table.getColumnName(j));
                }
            }
            
            System.out.println(termino);
            terminos.add(termino);
            
            //recorro la tabla hasta la ultima columna segun la cantidad de variables.
            //si esa casilla es V, pongo el elemento como x' si es F lo pongo como x
            //voy concatenando cada variable, hasta que alcance la ultima columna de la ultima variable
            //despues la imprimo en pantalla, y hago lo mismo con la siguiente fila
            //cuando se acaben las filas, me voy a la ULTIMA columna de la TABLA y si es V concateno esa fila en un String, sumandolo con el sig
        }
        
        for(int i = 0; i < table.getRowCount(); i++){
            String mintermino = "Forma Canónica Disyuntiva = ";
            
            if(table.getValueAt(i, table.getColumnCount()).equals("V")){
                mintermino += "(" + terminos.get(i) + ")" + " + ";
            }
        }
        
    }
    
    public void maxtermino(){
        List variables = this.tabla_verdad.getVariables();
        
        for(int i = 0; i < variables.size(); i++ ){
            //recorro la tabla hasta la ultima columna segun la cantidad de variables.
            //si esa casilla es F, pongo el elemento como x' si es V lo pongo como x
            //voy concatenando cada variable, sumandolas, hasta que alcance la ultima columna de la ultima variable
            //despues la imprimo en pantalla, y hago lo mismo con la siguiente fila
            //cuando se acaben las filas, me voy a la ULTIMA columna de la TABLA y si es F concateno esa fila en un String, multiplocandolo con el sig
        }
    }
    
    public void simplificar(){}

//      public static void main(String args[]) {
//       
//        JFrame v = new JFrame("Prueba JInternalFrame");
//        JDesktopPane dp = new JDesktopPane();
//        v.getContentPane().add(dp);
//        JPanel p = new JPanel();
//        p.setLayout(new FlowLayout());
//        p.add (new JLabel("Una etiqueta"));
//        p.add (new JTextField(10));
//        dp.add(new InternalFrame("Prueba"));
//        v.setSize(1000,1000);
//        v.setVisible(true);
//        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new InternalFrame("Prueba").setVisible(true);
//            }
//        });
//    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> maxList;
    private javax.swing.JList<String> minList;
    private javax.swing.JTable table;
    private javax.swing.JButton verificarBtn;
    // End of variables declaration//GEN-END:variables
}
