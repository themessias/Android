package com.example.somar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editValor1, editValor2, editResultado;
    double valor1,valor2,resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editValor1 = (EditText) findViewById(R.id.editValor1);
        editValor2 = (EditText) findViewById(R.id.editValor2);
        editResultado = (EditText) findViewById(R.id.editResultado);
    }

    public void calcular(View v){
        // entrada
        valor1 = Double.parseDouble(editValor1.getText().toString());
        valor2 = Double.parseDouble(editValor2.getText().toString());
        // resultado
        Calculadora calc = new Calculadora(valor1, valor2);
        resultado = calc.somar();
        //saída
        editResultado.setText(calc.formatar(resultado, 2));
    }

    public void substrair(View v){
        // entrada
        valor1 = Double.parseDouble(editValor1.getText().toString());
        valor2 = Double.parseDouble(editValor2.getText().toString());
        // resultado
        resultado = valor1 - valor2;

        //saída
        editResultado.setText(String.valueOf(resultado));
    }

    public void multiplicar(View v){
        // entrada
        valor1 = Double.parseDouble(editValor1.getText().toString());
        valor2 = Double.parseDouble(editValor2.getText().toString());
        // resultado
        resultado = valor1 * valor2;

        //saída
        editResultado.setText(String.valueOf(resultado));
    }

    public void dividir(View v){
        // entrada
        valor1 = Double.parseDouble(editValor1.getText().toString());
        valor2 = Double.parseDouble(editValor2.getText().toString());
        // resultado
        resultado = valor1 / valor2;

        //saída
        editResultado.setText(String.valueOf(resultado));
    }
}