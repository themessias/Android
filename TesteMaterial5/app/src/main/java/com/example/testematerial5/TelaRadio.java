package com.example.testematerial5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class TelaRadio extends AppCompatActivity {
    EditText edtBase, edtAltura, edtComprimento, edresp;
    RadioButton rdCm, rdMm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_radio);
        edtBase = (EditText) findViewById(R.id.editTextv1);
        edtAltura = (EditText) findViewById(R.id.editTextv2);
        edtComprimento = (EditText) findViewById(R.id.editTextv3);
        edresp = (EditText) findViewById(R.id.editTextResposta);
        rdCm = (RadioButton) findViewById(R.id.radioCm);
        rdMm = (RadioButton) findViewById(R.id.radioMm);

        edtBase.setText(getIntent().getExtras().getString("base"));
        edtAltura.setText(getIntent().getExtras().getString("altura"));
        edtComprimento.setText(getIntent().getExtras().getString("comprimento"));
    }

    public void calcular(View v){
        double resultado,v1,v2,v3;
        String medida;
        v1 = Double.parseDouble(getIntent().getExtras().getString("base"));
        v2 = Double.parseDouble(getIntent().getExtras().getString("altura"));
        v3 = Double.parseDouble(getIntent().getExtras().getString("comprimento"));
        if (rdCm.isChecked()){
            medida = " cm³";
        } else {
            medida = " mm³";
        }

        Funcoes funcao = new Funcoes(v1,v2,v3);
        resultado = funcao.volumeCubo();

        edresp.setText(String.valueOf(resultado)+medida);
    }

    public void voltar(View v){
        String soma = edresp.getText().toString();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("resp", soma);
        setResult(RESULT_OK,returnIntent);
        finish();
    }
}