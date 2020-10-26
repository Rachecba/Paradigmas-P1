/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author rbasu
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal view = new Principal();
        
        view.setVisible(true);
        String exp = "(p∧q)∨(p∧r)∨(q∧r)";
        Expresion expresion = new Expresion(exp);
        if(expresion.validar_expresion()==true){
            System.out.println("CORRECTO");
        }else{
            System.out.println("INCORRECTO");
        }
    }
    
    
}
