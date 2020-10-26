/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Michael
 */
public class Expresion {

    private String expresion;
    
    public Expresion(String expresion){
        this.expresion = expresion;
    }
    
    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }
    
    boolean validar_expresion(String expresion){
        return true;
    }
}
