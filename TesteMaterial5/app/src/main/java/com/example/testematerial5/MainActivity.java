package com.example.testematerial5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvResp;
    EditText edt1, edt2, edt3, edtResp;
    Intent intent;
    static final int ACTIVITY_REQUEST_SOMAR = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText) findViewById(R.id.editTextv1);
        edt2 = (EditText) findViewById(R.id.editTextv2);
        edt3 = (EditText) findViewById(R.id.editTextv3);
        edtResp = (EditText) findViewById(R.id.editTextResposta);
        tvResp = (TextView) findViewById(R.id.textViewResp);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACTIVITY_REQUEST_SOMAR && resultCode == RESULT_OK){
            String retorno = data.getStringExtra("resp");
            double soma = Double.parseDouble(retorno);
            tvResp.setVisibility(View.VISIBLE);
            edtResp.setVisibility(View.VISIBLE);
            edtResp.setText(String.format("%.2f", soma));
        }
    }

    public void chamarSomar(View v){
        double val1, val2, val3;
        val1 = Double.parseDouble(edt1.getText().toString());
        val2 = Double.parseDouble(edt2.getText().toString());
        val3 = Double.parseDouble(edt3.getText().toString());

        intent = new Intent(getApplicationContext(), TelaSomar.class);

        intent.putExtra("valor1", String.valueOf(val1));
        intent.putExtra("valor2", String.valueOf(val2));
        intent.putExtra("valor3", String.valueOf(val3));

        startActivityForResult(intent, ACTIVITY_REQUEST_SOMAR);
    }
}