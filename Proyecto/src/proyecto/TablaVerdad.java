/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.ArrayList;
import java.util.List;


public class TablaVerdad {

    private int cantidad_filas;
    private int cantidad_columnas;
    private List variables;
    private String expresion;
    private boolean[][] tabla;

    public TablaVerdad(){
        this.cantidad_filas = 0;
        this.cantidad_columnas = 0;
        this.variables = new ArrayList();
        this.expresion = "";
        this.tabla = new boolean[1][1];
    }
   
    
    public boolean[][] getTabla() {
        return tabla;
    }

    public void setTabla(boolean[][] tabla) {
        this.tabla = tabla;
    }

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
        this.variables = obtener_variables(expresion);
        this.tabla = construccion_tabla(this.cantidad_filas);
    }


    public int getCantidad_filas() {
        return cantidad_filas;
    }

    public void setCantidad_filas(int cantidad_filas) {
        this.cantidad_filas = cantidad_filas;
    }

    public int getCantidad_columnas() {
        return cantidad_columnas;
    }

    public void setCantidad_columnas(int cantidad_columnas) {
        this.cantidad_columnas = cantidad_columnas;
    }

    public List getVariables() {
        return variables;
    }

    public void setVariables(List variables) {
        this.variables = variables;
    }
    
    
    private char[] calcular_negacion(char operador[]){
        char vector_negado [] = {};
        for(int i = 0; i < 16;i++){
            if(operador[i]=='V')
                vector_negado[i] = 'F';
            else
                vector_negado[i] = 'V';
        }
        return vector_negado;
    }
    
    public boolean[][] construccion_tabla(int tam){

        this.cantidad_columnas=((int) Math.pow(2, tam));
        boolean[][] tabla = new boolean[tam][cantidad_columnas];
        int aux2 = 1;
        int aux1 = cantidad_columnas / (int) Math.pow(2, aux2);
        int cont = 0;
        boolean b = true;
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < cantidad_columnas; j++) {
                if (cont == aux1) {
                    b = !b;
                    cont = 0;
                } tabla[i][j] = b;
                cont++; 
            }if (cont == aux1) {
                b = !b;
                cont = 0;
            }aux2++;
            aux1 = cantidad_columnas / (int) Math.pow(2, aux2);}
        boolean[][] t2 = new boolean[cantidad_columnas][tam];
        for(int i =0; i< cantidad_columnas; i++){
            for(int j= 0; j< tam; j++){
                t2[i][j] = tabla[j][i];
            }
        }
        int x = this.cantidad_columnas;
        this.cantidad_columnas=this.cantidad_filas;
        this.cantidad_filas = x;
        return t2;
    }
    
//    private char[] calcular_and(char operador1[], char operador2[]){
//        char vector_and [] = {};
//        for(int i = 0; i < 16;i++){
//            if(operador1[i]=='V'&&operador2[i]=='V')
//                vector_and[i] = 'V';
//            else  if(operador1[i]=='V'&&operador2[i]=='F')
//                vector_and[i] = 'F';
//            else  if(operador1[i]=='F'&&operador2[i]=='V')
//                vector_and[i] = 'F';  
//            else  if(operador1[i]=='F'&&operador2[i]=='F')
//                vector_and[i] = 'F';
//        }
//        return vector_and;
//    }
    
    public char obtener_posicion(int i, int j){
        char posicion = 'F';
        if(this.tabla[i][j]==true){
            posicion='V';
        }
        return posicion;
    } 
//    private char[] calcular_or(char operador1[], char operador2[]){
//         char vector_or [] = {};
//        for(int i = 0; i < 16;i++){
//            if(operador1[i]=='V'&&operador2[i]=='V')
//                vector_or[i] = 'V';
//            else  if(operador1[i]=='V'&&operador2[i]=='F')
//                vector_or[i] = 'V';
//            else  if(operador1[i]=='F'&&operador2[i]=='V')
//                vector_or[i] = 'V';  
//            else  if(operador1[i]=='F'&&operador2[i]=='F')
//                vector_or[i] = 'F';
//        }
//        return vector_or;
//    }

    public List obtener_variables(String exp) {
        List variables = new ArrayList();
        for(int i = 0; i< exp.length(); i++){
            if(!this.validar_operadores(String.valueOf(exp.charAt(i)))){
                variables.add(exp.charAt(i));
            }
        }
        this.cantidad_filas = (variables.size());
        return variables;
    }
    
    private boolean validar_operadores(String caracter) {

        if (caracter.equals("<") || caracter.equals("=") || caracter.equals("-") || caracter.equals(">")||
                caracter.equals("+") || caracter.equals("*")|| caracter.equals(")") || caracter.equals("(")||
                caracter.equals("#") || caracter.equals("¬")|| caracter.equals("∧") || caracter.equals("∨")|| 
                caracter.equals("⇒") || caracter.equals("⇔"))
            return true;
         else 
            return false;
    }
}
