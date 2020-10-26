
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
    
    boolean validar_expresion(){
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
}
