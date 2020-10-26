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
public class TablaVerdad {

    private boolean p[]={true,true,true,true,true,true,true,true,false,false,false,false,false,false,false,false};
    private boolean q[]={true,true,true,true,false,false,false,false,true,true,true,true,false,false,false,false};
    private boolean r[]={true,true,false,false,true,true,false,false,true,true,false,false,true,true,false,false};
    private boolean s[]={true,false,true,false,true,false,true,false,true,false,true,false,true,false,true,false};
    
    public boolean[] getP() {
        return p;
    }

    public void setP(boolean[] p) {
        this.p = p;
    }

    public boolean[] getQ() {
        return q;
    }

    public void setQ(boolean[] q) {
        this.q = q;
    }

    public boolean[] getR() {
        return r;
    }

    public void setR(boolean[] r) {
        this.r = r;
    }

    public boolean[] getS() {
        return s;
    }

    public void setS(boolean[] s) {
        this.s = s;
    }
   
    boolean[] calcular_negacion(boolean operador[]){
        boolean vector_negado [] = {};
        for(int i = 0; i < 16;i++){
            if(operador[i]==true)
                vector_negado[i] = false;
            else
                vector_negado[i] = true;
        }
        return vector_negado;
    }
    
    boolean[] calcular_and(boolean operador1[], boolean operador2[]){
        boolean vector_and [] = {};
        for(int i = 0; i < 16;i++){
            if(operador1[i]==true&&operador2[i]==true)
                vector_and[i] = true;
            else  if(operador1[i]==true&&operador2[i]==false)
                vector_and[i] = false;
            else  if(operador1[i]==false&&operador2[i]==true)
                vector_and[i] = false;  
            else  if(operador1[i]==false&&operador2[i]==false)
                vector_and[i] = false;
        }
        return vector_and;
    }
        
    boolean[] calcular_or(boolean operador1[], boolean operador2[]){
         boolean vector_or [] = {};
        for(int i = 0; i < 16;i++){
            if(operador1[i]==true&&operador2[i]==true)
                vector_or[i] = true;
            else  if(operador1[i]==true&&operador2[i]==false)
                vector_or[i] = true;
            else  if(operador1[i]==false&&operador2[i]==true)
                vector_or[i] = true;  
            else  if(operador1[i]==false&&operador2[i]==false)
                vector_or[i] = false;
        }
        return vector_or;
    }
}
