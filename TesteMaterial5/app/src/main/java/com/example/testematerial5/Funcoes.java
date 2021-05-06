package com.example.testematerial5;

public class Funcoes {
    double base,altura, comprimento;

    public Funcoes(){}
    public Funcoes(double base, double altura, double comprimento){
        setBase(base);
        setAltura(altura);
        setComprimento(comprimento);
    }
    public void setBase(double valor){base = valor;}
    public double getBase(){return base;}

    public void setAltura(double valor){altura = valor;}
    public double getAltura(){return altura;}

    public void setComprimento(double valor){comprimento = valor;}
    public double getComprimento(){return comprimento;}

    public double volumeCubo(){
        return base * altura * comprimento;
    }

    public double volumePrisma(){
        return (base * altura) / 2 * comprimento;
    }

    public double volumePiramide(){
        return (base * comprimento * altura) / 6;
    }

}
