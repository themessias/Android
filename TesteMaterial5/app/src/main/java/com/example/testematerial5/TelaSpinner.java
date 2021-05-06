package com.example.testematerial5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class TelaSpinner extends AppCompatActivity {
    EditText edtBase, edtAltura, edtComprimento, edtResp;
    Spinner sp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_spinner);
        edtBase = (EditText) findViewById(R.id.editTextv1);
        edtAltura = (EditText) findViewById(R.id.editTextv2);
        edtComprimento = (EditText) findViewById(R.id.editTextv3);
        edtResp = (EditText) findViewById(R.id.editTextResposta);
        sp1 = (Spinner) findViewById(R.id.spinner);
    }

    public void calcular(View v){
        double v1,v2,v3,resultado;
        String medida;
        v1 = Double.parseDouble(edtBase.getText().toString());
        v2 = Double.parseDouble(edtAltura.getText().toString());
        v3 = Double.parseDouble(edtComprimento.getText().toString());
        Funcoes funcao = new Funcoes(v1,v2,v3);
        resultado = funcao.volumePiramide();
        if (sp1.getSelectedItem().toString().equals("cm")){
            medida = " cm³";
        } else {
            medida = " mm³";
        }
        edtResp.setText(String.valueOf(resultado) + medida);
    }


    public void voltar(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}