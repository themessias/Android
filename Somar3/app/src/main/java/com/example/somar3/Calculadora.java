package com.example.somar3;

public class Calculadora {
    //Atributos
    double valor1, valor2;// Construtores
    public Calculadora() {}
    public Calculadora(double v1, double v2){
        setValor1(v1);
        setValor2(v2);
    }
    // Métodos de Acesso
    public void setValor1(double valor){
        valor1 = valor;
    }
    public double getValor1(){
        return valor1;
    }
    public void setValor2(double valor){
        valor2 = valor;
    }
    public double getValor2(){
        return valor2;
    }
    //Métodos extras
    public double somar(){
        return valor1 + valor2;
    }
    public double subtrair(){return valor1 - valor2;}
    public double multiplicar(){return valor1 * valor2;}
    public double dividir(){return valor1 / valor2;}
    public String formatar(double valor, int nc){
        return String.format("%." + String.valueOf(nc) +  "f", valor);
    }
}
