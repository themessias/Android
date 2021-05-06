package com.example.av1_android;

public class func {
    double base,altura, comprimento;

    public func(double base, double altura){
        setBase(base);
        setAltura(altura);
    }

    public void setBase(double valor){base = valor;}
    public double getBase(){return base;}

    public void setAltura(double valor){altura = valor;}
    public double getAltura(){return altura;}

    public void setComprimento(double valor){comprimento = valor;}
    public double getComprimento(){return comprimento;}

    public double volumeQuadrado(){return base * altura;}

    public String formatar(double valor, int nc, String medida){
        return String.format("%." + nc + "f" + " %s", valor,medida);
    }
}
