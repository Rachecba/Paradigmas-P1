/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListModel;
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
    //Creamos un objeto tabla de verdad que usaremos para realizar las operaciones necesarias.
    TablaVerdad tabla_verdad = new TablaVerdad();
    DefaultListModel modeloMin = new DefaultListModel();
    DefaultListModel modeloMax = new DefaultListModel();

    public InternalFrame(String title) {
       
        initComponents();
        this.setTitle(title);
        this.setVisible(true);
        this.minList.setModel(modeloMin);
        this.maxList.setModel(modeloMax);

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(field, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(verificarBtn))
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 288, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
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
        //Acá, inicializamos la tabla de verdad con la expresion que ingresa el usuario y se valida si la expresion es correcta
        this.tabla_verdad.setExpresion(exp);
        Expresion expresion = new Expresion(exp);
        
        if(expresion.validar_expresion(exp)==true){
             JOptionPane.showMessageDialog(null,"  Expresion Correcta!!");
             this.tabla_verdad.setExpresion(exp);
        }else{
           
             JOptionPane.showMessageDialog(null,"  Expresion Incorrecta!!");
        }
        tablaVerdad();//Metodo de dibuja la tabla de verdad
        mintermino(); // Metodo que muestra los terminos minimos
        maxtermino(); // Metodo de muestra los terminos maximos
        
    }//GEN-LAST:event_verificarBtnMouseClicked

    private void fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldActionPerformed

    private void verificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verificarBtnActionPerformed

    public void tablaVerdad(){
        DefaultTableModel model = new DefaultTableModel();
        //Se llenan los identificadores de columnas con las variables y expresiones
        model.setColumnIdentifiers((this.tabla_verdad.getVariables().toArray()));

        model.setColumnCount(this.tabla_verdad.getCantidad_columnas());
        model.setRowCount(this.tabla_verdad.getCantidad_filas());
        
        this.table.setModel(model);
        //Se llenan las filas y columnas
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < this.tabla_verdad.getCantidad_filassolas(); j++) {
                this.table.setValueAt(this.tabla_verdad.obtener_posicion(i, j), i, j);
            }
        }
        //Se centra el contenido de la tabla
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i = 0; i < this.table.getColumnCount();i++){
            this.table.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }
    
    public void mintermino(){
        List variables = this.tabla_verdad.getVariablessolas();
        List terminos = new ArrayList();
        String termino;
        String mintermino = "";
        String cont = "";
        
        for(int i = 0; i < table.getRowCount(); i++ ){ //Filas
            termino = "";
            cont = "m" + i + " = ";
            
            for(int j = 0; j < variables.size(); j++){ //Columnas
                if(this.table.getValueAt(i, j).equals('V')){
                    termino += this.table.getColumnName(j) + "¬";
                }else{
                    termino += this.table.getColumnName(j);
                }
            }
            
            modeloMin.addElement(cont + termino);
            terminos.add(termino);
            
            //recorro la tabla hasta la ultima columna segun la cantidad de variables.
            //si esa casilla es V, pongo el elemento como x' si es F lo pongo como x
            //voy concatenando cada variable, hasta que alcance la ultima columna de la ultima variable
            //despues la imprimo en pantalla, y hago lo mismo con la siguiente fila
            //cuando se acaben las filas, me voy a la ULTIMA columna de la TABLA y si es V concateno esa fila en un String, sumandolo con el sig
        }
        
        mintermino = "Forma Canónica Disyuntiva = ";
        
        for(int i = 0; i < table.getRowCount(); i++){
            
            if(table.getValueAt(i, variables.size()-1).equals('V')){
                if(!(i == table.getRowCount() - 1)){
                    mintermino += "(" + terminos.get(i) + ")" + " + ";
                }else{
                    mintermino += "(" + terminos.get(i) + ")";
                }
                
            }
        }
        
        modeloMin.addElement(mintermino);

    }
    
    public void maxtermino(){
        List variables = this.tabla_verdad.getVariablessolas();
        List terminos = new ArrayList();
        String termino;
        String maxtermino = "";
        String cont = "";
        
        for(int i = 0; i < table.getRowCount(); i++ ){ //Filas
            termino = "";
            cont = "m" + i + " = ";
            
            for(int j = 0; j < variables.size(); j++){ //Columnas
                if(this.table.getValueAt(i, j).equals('V')){
                    
                    if(!(j == variables.size()-1)){
                        termino += this.table.getColumnName(j) + " + ";
                    }else{
                        termino += this.table.getColumnName(j);
                    }
                    
                }else{
                    
                    if(!(j == variables.size()-1)){
                        termino += this.table.getColumnName(j) + "¬ + ";
                    }else{
                        termino += this.table.getColumnName(j) + "¬";
                    }

                }
            }
            
            modeloMax.addElement(cont + termino);
            terminos.add(termino);
            
            //recorro la tabla hasta la ultima columna segun la cantidad de variables.
            //si esa casilla es F, pongo el elemento como x' si es V lo pongo como x
            //voy concatenando cada variable, sumandolas, hasta que alcance la ultima columna de la ultima variable
            //despues la imprimo en pantalla, y hago lo mismo con la siguiente fila
            //cuando se acaben las filas, me voy a la ULTIMA columna de la TABLA y si es F concateno esa fila en un String, multiplicandolo con el sig
        }
        
        maxtermino = "Forma Canónica Conjuntiva = ";
        
        for(int i = 0; i < table.getRowCount(); i++){
            
            if(table.getValueAt(i, variables.size()-1).equals('F')){
                maxtermino += "(" + terminos.get(i) + ") ";
            }
        }
        
        modeloMax.addElement(maxtermino);
           
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
