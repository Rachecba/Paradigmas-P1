/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package proyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class TablaVerdad {
    
    private int cantidad_filas;
    private int cantidad_columnas;
    private List variables;
    private String expresion;
    private boolean[][] tabla;
    
    private Stack<String> expr = new Stack<>();
    private Stack<Character> operadores = new Stack<>();
    private Stack<String> exprSep = new Stack<>();
    
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

    public Stack<String> getExpr() {
        return expr;
    }

    public void setExpr(Stack<String> expr) {
        this.expr = expr;
    }

    public Stack<Character> getOperadores() {
        return operadores;
    }

    public void setOperadores(Stack<Character> operadores) {
        this.operadores = operadores;
    }

    public Stack<String> getExprSep() {
        return exprSep;
    }

    public void setExprSep(Stack<String> exprSep) {
        this.exprSep = exprSep;
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
    
    public List identifiers(String exp){ // crea una lista con los elementos que van en el header de la tabla
        List identifiers = new ArrayList();
        
        for(int i = 0; i < this.variables.size(); i++){ //recorre la lista de variables y las agrega a la nueva lista
            identifiers.add(variables.get(i));
        }
        
        //recorre la lista de expresiones y las agrega a la nueva lista
        
        identifiers.add(exp); //agrega la expresion a la lista.
        
        return identifiers;
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
    
    public String obtener_operaciones(String expression) {
        char[] expresion = expression.toCharArray();
        
        
        for (int i = 0; i < expresion.length; i++) {
            //Ignorar si el character es un espacio
            if (expresion[i] == ' '){
                continue;
            }
            
            //Validar los operadores
            if (expresion[i] == '-' && expresion[i+1] == '>'){
                expresion[i] = '⇒';
                expresion[i+1] = ' ';
            }
            
            if (expresion[i] == '<' && expresion[i+1] == '-' && expresion[i+2] == '>'){
                expresion[i] = '⇔';
                expresion[i+1] = ' ';
                expresion[i+2] = ' ';
            }
            
            if (expresion[i] == '+'){
                expresion[i] = '∨';
            }
            
            if (expresion[i] == '*'){
                expresion[i] = '∧';
            }
            
            //Si el character es una letra, meterlo a la stack de expr
            if (Character.isLetter(expresion[i])) {
                StringBuilder buffer = new StringBuilder();
                buffer.append(expresion[i]);
                expr.push(buffer.toString());
            } else { //Si el character es un parentesis abierto, agregarlo a la stack de operadores
                if (expresion[i] == '(') {
                    operadores.push(expresion[i]);
                } else { //Si el character es un parentesis cerrado, evaluar
                    if (expresion[i] == ')') {
                        while (operadores.peek() != '('){
                            expr.push("(" + operador(operadores.pop(),
                                    expr.pop(),
                                    expr.pop())  + ")");
                            exprSep.push(expr.peek());
                        }
                        operadores.pop();
                    } else { //Si el character es un operador, agregarlo a la stack de operadores
                        while (!operadores.empty() &&
                                precedencia(expresion[i],
                                        operadores.peek()))
                            expr.push(operador(operadores.pop(),
                                    expr.pop(),
                                    expr.pop()));
                        
                        operadores.push(expresion[i]);
                    }
                }
            }
        }
        
        while (!operadores.empty())
            expr.push(operador(operadores.pop(),
                    expr.pop(),
                    expr.pop()));
        
        return expr.pop();
    }
    
    public static boolean precedencia(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')') {return false;}
        if (op2 == '¬' && (op1 == '∧' || op1 == '∨' || op1 == '⇒' || op1 == '⇔')) {return false;}
        if (op2 == '∧' && (op1 == '∨' || op1 == '⇒' || op1 == '⇔')) {return false;}
        if (op2 == '∨' && (op1 == '⇒' || op1 == '⇔')) {return false;}
        if (op2 == '⇒' && (op1 == '⇔')) {return false;}
        
        return true;
    }
    
    public static String operador(char op, String b, String a)
    {
        switch (op)
        {
            case '∨':
                return a +  "∨" +  b;
            case '∧':
                return a +  "∧" +  b;
            case '⇒':
                return a +  "⇒" +  b;
            case '⇔':
                return a +  "⇔" +  b;
            default:
                return "";
        }
    }
}
