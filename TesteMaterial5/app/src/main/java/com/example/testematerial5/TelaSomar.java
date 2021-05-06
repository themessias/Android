package com.example.testematerial5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class TelaSomar extends AppCompatActivity {
    EditText edv1, edv2, edv3, edresp;
    RadioButton rdCm, rdMm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_somar);
        edv1 = (EditText) findViewById(R.id.editTextv1);
        edv2 = (EditText) findViewById(R.id.editTextv2);
        edv3 = (EditText) findViewById(R.id.editTextv3);
        edresp = (EditText) findViewById(R.id.editTextResposta);
        rdCm = (RadioButton) findViewById(R.id.radioCm);
        rdMm = (RadioButton) findViewById(R.id.radioMm);

        edv1.setText(getIntent().getExtras().getString("valor1"));
        edv2.setText(getIntent().getExtras().getString("valor2"));
        edv3.setText(getIntent().getExtras().getString("valor3"));
    }

    public void calcular(View v){
        double resultado,v1,v2,v3;
        v1 = Double.parseDouble(getIntent().getExtras().getString("valor1"));
        v2 = Double.parseDouble(getIntent().getExtras().getString("valor2"));
        v3 = Double.parseDouble(getIntent().getExtras().getString("valor3"));
        resultado = v1 * v2 * v3;
        edresp.setText(String.valueOf(resultado));
    }

    public void voltar(View v){
        String soma = edresp.getText().toString();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("resp", soma);
        setResult(RESULT_OK,returnIntent);

        finish();
    }
}