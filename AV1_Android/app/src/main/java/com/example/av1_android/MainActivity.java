package com.example.av1_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textResultado;
    EditText editBase, editAltura, editResultado;
    Intent intent;
    static final int ENVIAR_SEGUNDA_TELA = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editBase = (EditText) findViewById(R.id.editBase);
        editAltura = (EditText) findViewById(R.id.editAltura);
        editResultado = (EditText) findViewById(R.id.editResultado);
        textResultado = (TextView) findViewById(R.id.textResultado);
    }

    protected void onActivityResult(int requestCode,int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode, data);

        if (requestCode == ENVIAR_SEGUNDA_TELA && resultCode == RESULT_OK){
                String resultado = data.getStringExtra("resultado");
                double valor = Double.parseDouble(resultado);
                textResultado.setVisibility(View.VISIBLE);
                editResultado.setVisibility(View.VISIBLE);
                editResultado.setText(String.format("%.2f", valor));

            //resultado = getIntent().getStringExtra("resultado");
        }

    }

    public void enviarRadioButton(View v){
        if (editBase.getText().toString().trim().equals("") || editAltura.getText().toString().trim().equals("")){
            Toast.makeText(this, "Preencha todos os valores", Toast.LENGTH_LONG).show();
        } else {

            double base, altura;
            base = Double.parseDouble(editBase.getText().toString());
            altura = Double.parseDouble(editAltura.getText().toString());
            intent.putExtra("valor1", String.valueOf(base));
            intent.putExtra("valor2", String.valueOf(altura));
            startActivityForResult(intent, ENVIAR_SEGUNDA_TELA);
        }

    }
    /*
    public void enviarCheckBox(View v){
        Intent intent = new Intent(this, telaRadioButton.class);
        startActivity(intent);
    }

    public void enviarSpinner(View v){
        Intent intent = new Intent(this, telaRadioButton.class);
        startActivity(intent);
    }*/
}