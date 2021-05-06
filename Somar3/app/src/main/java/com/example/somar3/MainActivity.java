package com.example.somar3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner sp1;
    EditText editValor1, editValor2, editResultado;
    double valor1,valor2,resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editValor1 = (EditText) findViewById(R.id.editValor1);
        editValor2 = (EditText) findViewById(R.id.editValor2);
        editResultado = (EditText) findViewById(R.id.editResultado);
        sp1 = (Spinner) findViewById(R.id.spinner1);
    }

    public void somar(){
        // entrada
        valor1 = Double.parseDouble(editValor1.getText().toString());
        valor2 = Double.parseDouble(editValor2.getText().toString());
        // resultado
        com.example.somar3.Calculadora calc = new com.example.somar3.Calculadora(valor1, valor2);
        resultado = calc.somar();
        //saída
        editResultado.setText(calc.formatar(resultado, 2));
    }

    public void subtrair(){
        // entrada
        valor1 = Double.parseDouble(editValor1.getText().toString());
        valor2 = Double.parseDouble(editValor2.getText().toString());
        // resultado
        resultado = valor1 - valor2;

        //saída
        editResultado.setText(String.valueOf(resultado));
    }

    public void multiplicar(){
        // entrada
        valor1 = Double.parseDouble(editValor1.getText().toString());
        valor2 = Double.parseDouble(editValor2.getText().toString());
        // resultado
        resultado = valor1 * valor2;

        //saída
        editResultado.setText(String.valueOf(resultado));
    }

    public void dividir(){
        // entrada
        valor1 = Double.parseDouble(editValor1.getText().toString());
        valor2 = Double.parseDouble(editValor2.getText().toString());
        // resultado
        resultado = valor1 / valor2;

        //saída
        editResultado.setText(String.valueOf(resultado));
    }

    public void calcular(View v) {
        if (sp1.getSelectedItem().toString().equals("Somar")) {
            somar();
        } else if (sp1.getSelectedItem().toString().equals("Subtrair")) {
            subtrair();
        } else if (sp1.getSelectedItem().toString().equals("Multiplicar")) {
            multiplicar();
        } else if (sp1.getSelectedItem().toString().equals("Dividir")) {
            dividir();
        }

    }


}