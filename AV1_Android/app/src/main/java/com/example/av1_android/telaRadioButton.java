package com.example.av1_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class telaRadioButton extends AppCompatActivity {
    EditText editBase, editAltura, editResultado;
    RadioButton radioCm, radioMm;
    double base,altura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_v1__android2);
        editBase = (EditText) findViewById(R.id.editBase);
        editAltura = (EditText) findViewById(R.id.editAltura);
        editResultado = (EditText) findViewById(R.id.editResultado);
        radioCm = (RadioButton) findViewById(R.id.radioCm);
        radioMm = (RadioButton) findViewById(R.id.radioMm);

        editBase.setText(getIntent().getExtras().getString("valorl1"));
        editAltura.setText(getIntent().getExtras().getString("valor2"));

        /*base = getIntent().getDoubleExtra("base",2f);
        altura = getIntent().getDoubleExtra("altura",2f);

        editBase.setText(String.valueOf(base));
        editAltura.setText(String.valueOf(altura));*/


    }

    public void calcular(View v) {
        double resultado;
        String medida,msg;

        func func = new func(base,altura);
        resultado = func.volumeQuadrado();
        if (radioCm.isChecked()){
            medida = "cm";
        } else {
            medida = "mm";
        }
        msg = func.formatar(resultado,2,medida);

        editResultado.setText(msg);

        Intent returnIntent = new Intent();
        returnIntent.putExtra("resultado", msg);
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}