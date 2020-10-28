
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
    //Valida Expresion llama a los metodos valida_sintaxis y valida_parentesis
    //de esta manera puede revisar la expresion de una manera completa 
    //
    
    public boolean validar_expresion(String s){
        boolean result = true;
        // Parentecis
        result = valida_parentesis(s);
        if(result)return false;
        // sintasis() (p*(q+r))->s
        String str = s.replaceAll("[(|)|\\s]","");
        result = valida_rsintaxis(str);
        if(!result)return false;
        return true;
    }
    //Metodo valida parentesis 
    //Este metodo valida que los parentis tenga su correcta pareja 
    //y si se abre uno parentesis se cierre de manera correcta  
    private boolean valida_parentesis(String s) {
        int cont = 0;
        for(char c : s.toCharArray()){
            switch (c) {
                case '(': cont++; break;
                case ')': cont--; break;
            }
        }
        return cont != 0;
    }
    //Valida la Sintaxis de la expresion logica 
    //este metodo evalua la estructura de la expresion 
    // y valida que tenga un correcto uso de la reglas de operadores logicos
    private boolean valida_rsintaxis(String s){
        boolean notEmpty = true;
        try {
            if(s.length() > 0){
                for(int i=0;i<s.length();i++){
                    char c = s.charAt(i);
                    switch (c) {
                        case '<':
                            if(s.charAt(i+1)=='='|| s.charAt(i+1)=='-'){
                                if(s.charAt(i+2)=='>'){
                                    i = i+2;
                                }else{return false;}
                            }else if(Character.isLetter(s.charAt(i+1))&& Character.isLetter(s.charAt(i-1))){
                                i=i+1;
                            }else{return false;}
                            break;
                        case '-':
                            if(Character.isLetter(s.charAt(i+1))&& Character.isLetter(s.charAt(i-1))){
                                i = i+1;
                            }else if(s.charAt(i+1)=='>'&& Character.isLetter(s.charAt(i+2))){
                                i = i+2;
                            }else if(s.charAt(i+1)=='-' && Character.isLetter(s.charAt(i+2)) ){
                                i = i+2;
                            }else if(Character.isLetter(s.charAt(i+1))&& s.charAt(i-1)=='+'){
                                i = i+1;
                            }else if(Character.isLetter(s.charAt(i+1))&& s.charAt(i-1)=='-'){
                                i = i+1;
                            }else if(Character.isLetter(s.charAt(i+1))&& s.charAt(i-1)=='>'){
                                i = i+1;
                            }
                            else{return false;}
                            break;
                        case '=':
                            if(s.charAt(i+1)=='>'){
                                if(Character.isLetter(s.charAt(i+2))&& Character.isLetter(s.charAt(i-1))){
                                    i = i+2;
                                }
                            }else{return false;}
                            break;
                        case '*':
                            if(Character.isLetter(s.charAt(i+1))){
                                i = i+1;
                            }else{return false;}
                            break;
                        case '+':
                            if(Character.isLetter(s.charAt(i+1))&& Character.isLetter(s.charAt(i-1))){
                                i = i+1;
                            }else if(s.charAt(i+1)=='-'){
                                if(Character.isLetter(s.charAt(i+2))){
                                    i = i+2;
                                }else{return false;}
                            }else{return false;}
                            break;
                        case '#':
                            if(Character.isLetter(s.charAt(i+1))&& Character.isLetter(s.charAt(i-1))){
                                i = i+1;
                            }else{return false;}
                            break;
                        case '(':
                            if(s.charAt(i+1) == ')'){
                                return false;
                            }
                            break;
                        default:
                            if(!Character.isLetter(c)){
                                return false;
                            }else if(s.length()>1){
                                if(Character.isLetter(s.charAt(i+1))){
                                    return false;
                                }
                            }
                            break;
                    }
                }
            }else{
                return false;
            }
        }catch( Exception e ) {
            return false;
        }
        return true;
    }
    
    
}
