package com.example.somar2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;import android.widget.EditText;
import android.widget.RadioButton;


public class MainActivity extends AppCompatActivity {
    EditText editValor1, editValor2, editResultado;
    RadioButton radioSomar, radioSubtrair, radioMultiplicar, radioDividir;
    double valor1,valor2,resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editValor1 = (EditText) findViewById(R.id.editValor1);
        editValor2 = (EditText) findViewById(R.id.editValor2);
        editResultado = (EditText) findViewById(R.id.editResultado);
        radioSomar = (RadioButton) findViewById(R.id.radioSomar);
        radioSubtrair = (RadioButton) findViewById(R.id.radioSubtrair);
        radioMultiplicar = (RadioButton) findViewById(R.id.radioMultiplicar);
        radioDividir = (RadioButton) findViewById(R.id.radioDividir);
    }

    public void somar(){
        // entrada
        valor1 = Double.parseDouble(editValor1.getText().toString());
        valor2 = Double.parseDouble(editValor2.getText().toString());
        // resultado
        com.example.somar2.Calculadora calc = new com.example.somar2.Calculadora(valor1, valor2);
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

    public void calcular(View v){
        if (radioSomar.isChecked()){
            somar();
        } else if (radioSubtrair.isChecked()){
            subtrair();
        } else if (radioMultiplicar.isChecked()){
            multiplicar();
        } else if (radioDividir.isChecked()){
            dividir();
        }
    }
}