
package proyecto;

import java.util.Stack;

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
    
    boolean validar_parentesis(){
        Stack pila = new Stack();
        int tam = expresion.length();
        int i = 0;
        while(i < tam){
           if(this.expresion.charAt(i)=='('){
               pila.push('(');
           }else if(this.expresion.charAt(i)==')'){
               if(pila.empty())
                   break;
               else
                   pila.pop();
           }
           i++;
        }
        if(pila.empty()&&i==tam)
            return true;
        else
            return false;
    }
    
    boolean validar_operadores(){
       int tam = expresion.length();
        int i = 0;
        while(i < tam){
           char aux = this.expresion.charAt(i);
           if(aux!='¬'&&aux!=')'&&aux!='('&&aux!='∨'&&aux!='∧'&&aux!='⇒'&&aux!='⇔'&&aux!='+'&&aux!='*'){
               return false;
           }
           i++;
        }
        return true;
    }
    
    boolean validar_expresion(){
        if(expresion.isEmpty()) return false;
        if(validar_parentesis()==true && validar_operadores()==true)
            return true;
        else
            return false;
    }
}
