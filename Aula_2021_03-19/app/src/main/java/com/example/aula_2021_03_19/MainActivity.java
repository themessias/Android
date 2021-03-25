package com.example.aula_2021_03_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner sp1;
    EditText edtEscolha1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp1 = (Spinner) findViewById(R.id.spinner1);
        edtEscolha1 = (EditText) findViewById(R.id.editEscolha1);
    }

    public void clicar(View v){
        String escolha1 ="Você escolheu: ";
        //escolha1+= sp1.getSelectedItem().toString();
        if(sp1.getSelectedItem().toString().equals("Feminino")){
            escolha1 += "Feminino.";
        } else if(sp1.getSelectedItem().toString().equals("Masculino")) {
            escolha1 += "Masculino";
        }

        edtEscolha1.setText(escolha1);
    }
}