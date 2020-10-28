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
    private int cantidad_filassolas;
    private List variables;
    private List variablessolas;
    private String expresion;
    private boolean[][] tabla;
    
    private Stack<String> expr = new Stack<>();
    private Stack<Character> operadores = new Stack<>();
    private List<String> exprSep = new ArrayList<>();
    
    public TablaVerdad(){
        this.cantidad_filas = 0;
        this.cantidad_columnas = 0;
        this.variables = new ArrayList();
        this.variablessolas = new ArrayList();
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
        obtener_operaciones(expresion);
        this.variablessolas = obtener_variables(expresion);
        this.variables = obtener_variables(expresion);
        identifiers();
        this.tabla = construccion_tabla(this.cantidad_filassolas);
    }
    
    public int getCantidad_filassolas() {
        return cantidad_filassolas;
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
    
       public List getVariablessolas() {
        return variablessolas;
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

    public List<String> getExprSep() {
        return exprSep;
    }

    public void setExprSep(List<String> exprSep) {
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
        this.cantidad_filassolas = (variables.size());
        return variables;
    }
    
    public void identifiers(){ // crea una lista con los elementos que van en el header de la tabla
        List identifiers = new ArrayList();
        
        for(int i = 0; i < this.variables.size(); i++){ //recorre la lista de variables y las agrega a la nueva lista
            identifiers.add(variables.get(i));
        }
        
        for(int i = 0; i < this.exprSep.size(); i++){
            identifiers.add(exprSep.get(i));
        }
        //recorre la lista de expresiones y las agrega a la nueva lista
        this.cantidad_filas=identifiers.size();
        this.variables=identifiers;
        //return identifiers;
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
    
    /*Este metodo se encarga de recibir la expresion completa y separarla en partes para ser evaluada.*/
    public void obtener_operaciones(String expression) {
        char[] expresionChar = expression.toCharArray();
        exprSep.clear();
        expr.clear();
        
        for (int i = 0; i < expresionChar.length; i++) {
            //Ignorar si el character es un espacio
            if (expresionChar[i] == ' '){
                continue;
            }
            
            //Validar los operadores
            if (expresionChar[i] == '-' && expresionChar[i+1] == '>'){
                expresionChar[i] = '⇒';
                expresionChar[i+1] = ' ';
            }
            
            if (expresionChar[i] == '<' && expresionChar[i+1] == '-' && expresionChar[i+2] == '>'){
                expresionChar[i] = '⇔';
                expresionChar[i+1] = ' ';
                expresionChar[i+2] = ' ';
            }
            
            if (expresionChar[i] == '+'){
                expresionChar[i] = '∨';
            }
            
            if (expresionChar[i] == '*'){
                expresionChar[i] = '∧';
            }
            
            if ((expresionChar[i] == '¬' && expresionChar[i+1] == '¬') || expresionChar[i] == '-' && expresionChar[i+1] == '-'){
                expresionChar[i] = ' ';
                expresionChar[i+1] = ' ';
            }
            
            if (expresionChar[i] == '-'){
                expresionChar[i] = '¬';
            }
            
            if (expresionChar[i] == '#'){
                expresionChar[i] = '⊻';
            }
            
            //Si el character es una letra, meterlo a la stack de expr
            if (Character.isLetter(expresionChar[i])) {
                StringBuilder buffer = new StringBuilder();
                buffer.append(expresionChar[i]);
                expr.push(buffer.toString());
            } else { //Si el character es un parentesis abierto, agregarlo a la stack de operadores
                switch(expresionChar[i]){
                    case '(':
                        operadores.push(expresionChar[i]);
                        break;
                    case ')':
                        while (operadores.peek() != '('){
                            expr.push("(" + operador(operadores.pop(),
                                    expr.pop(),
                                    expr.pop())  + ")");
                        }
                        exprSep.add(expr.peek());
                        operadores.pop();
                        break;
                    case ' ':
                        break;
                    default:
                        while (!operadores.empty() &&
                                precedencia(expresionChar[i],
                                        operadores.peek()))
                            expr.push(operador(operadores.pop(),
                                    expr.pop(),
                                    expr.pop()));
                        
                        operadores.push(expresionChar[i]);
                        break;
                }
            }
        }
        
        while (!operadores.empty())
            expr.push(operador(operadores.pop(),
                    expr.pop(),
                    expr.pop()));
        
        if(expr.size() == 1 && exprSep.isEmpty()){
            exprSep = expr;
        }
        
        if(expresionChar[expresionChar.length-1] != ')' && exprSep.isEmpty()){
            exprSep.add(expr.peek());
        }
        
        if(exprSep.get(exprSep.size()-1).equals(exprSep.get(exprSep.size()-2))){
            exprSep.remove(exprSep.size()-2);
        }
    }
    
    public static boolean precedencia(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')') {return false;}
        if (op2 == '¬' && (op1 == '∧' || op1 == '∨' || op1 == '⇒' || op1 == '⇔')) {return false;}
        if (op2 == '∧' && (op1 == '∨' || op1 == '⇒' || op1 == '⇔')) {return false;}
        if ((op2 == '∨' || op2 == '⊻') && (op1 == '⇒' || op1 == '⇔')) {return false;}
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
            case '⊻':
                return a +  "⊻" +  b;
            case '⇒':
                return a +  "⇒" +  b;
            case '⇔':
                return a +  "⇔" +  b;
            case '¬':
                return "¬" + a;
            default:
                return "";
        }
    }
}
