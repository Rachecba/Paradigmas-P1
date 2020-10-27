
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

    private boolean valida_rsintaxis(String s){
        boolean result = true;
        try {
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
    }catch( Exception e ) {
      return false;
    }
        return true;
    }
    
    
}
