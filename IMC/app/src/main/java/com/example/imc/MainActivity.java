package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    EditText editPeso, editAltura, editImc, editSituacao;
    CheckBox checkIdade;
    RadioButton radioFeminino, radioMasculino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editPeso = (EditText) findViewById(R.id.editPeso);
        editAltura = (EditText) findViewById(R.id.editAltura);
        editImc = (EditText) findViewById(R.id.editImc);
        editSituacao = (EditText) findViewById(R.id.editSituacao);
        checkIdade = (CheckBox) findViewById(R.id.checkIdade);
        radioFeminino = (RadioButton) findViewById(R.id.radioFeminino);
        radioMasculino = (RadioButton) findViewById(R.id.radioMasculino);
    }

    public void calcularImc(View v){
        double peso, altura, imc;
        boolean idade;
        int sexo; // 1 - Feminino, 2- Masculino
        String situacao;
        //entradas
        peso = Double.parseDouble(editPeso.getText().toString());
        altura = Double.parseDouble(editAltura.getText().toString());
        if(checkIdade.isChecked()){
            idade = true;// > 15 anos
        } else {
            idade = false;// <= 15 anos
        }
        if(radioFeminino.isChecked()){
            sexo = 1;// Feminino
        } else {
            sexo = 2;// Masculino
        }
        //processamento
        imc = peso / Math.pow(altura, 2);

        if (idade == false){
            editSituacao.setText(String.valueOf("Situação não deve ser calculada!"));

        } else if (sexo == 1){
            if (imc <= 19.1) {
                editSituacao.setText("Abaixo do peso.");
            } else if (imc <= 25.8){
                editSituacao.setText("No peso normal.");
            } else if (imc <= 27.3) {
                editSituacao.setText("Marginalmente acima do peso.");
            } else if (imc <= 32.3) {
                editSituacao.setText("Acima do peso ideal.");
            } else {
                editSituacao.setText("Obesa.");
            }
            //saída
            editImc.setText(String.format("%.2f", imc));
        } else {
            if (imc <= 20.7) {
                editSituacao.setText("Abaixo do peso.");
            } else if (imc <= 26.4){
                editSituacao.setText("No peso normal.");
            } else if (imc <= 27.8) {
                editSituacao.setText("Marginalmente acima do peso.");
            } else if (imc <= 31.1) {
                editSituacao.setText("Acima do peso ideal.");
            } else {
                editSituacao.setText("Obesa.");
            }
            //saída
            editImc.setText(String.format("%.2f", imc));
        }



    }
}