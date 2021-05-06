package com.example.testematerial5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvResp;
    EditText edt1, edt2, edt3, edtResp;
    Intent intent;
    static final int ACTIVITY_REQUEST_CUBO = 1;
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
        if (requestCode == ACTIVITY_REQUEST_CUBO && resultCode == RESULT_OK){
            String retorno = data.getStringExtra("resp");
            tvResp.setVisibility(View.VISIBLE);
            edtResp.setVisibility(View.VISIBLE);
            edtResp.setText(retorno);
            limpar();
        }
    }

    public void chamarCubo(View v) {
        if (edt1.getText().toString().isEmpty() || edt2.getText().toString().isEmpty() ||
                edt3.getText().toString().isEmpty()) {
            Toast.makeText(this, "Preencha todos os valores", Toast.LENGTH_LONG).show();
        } else {
            double val1, val2, val3;
            val1 = Double.parseDouble(edt1.getText().toString());
            val2 = Double.parseDouble(edt2.getText().toString());
            val3 = Double.parseDouble(edt3.getText().toString());

            intent = new Intent(getApplicationContext(), TelaRadio.class);

            intent.putExtra("base", String.valueOf(val1));
            intent.putExtra("altura", String.valueOf(val2));
            intent.putExtra("comprimento", String.valueOf(val3));

            startActivityForResult(intent, ACTIVITY_REQUEST_CUBO);
        }
    }

    public void chamarPrisma(View v) {
        if (!edt1.getText().toString().isEmpty() || !edt2.getText().toString().isEmpty() ||
                !edt3.getText().toString().isEmpty()) {
            Toast.makeText(this, "Todos os campos devem estar vazios", Toast.LENGTH_LONG).show();
        } else {
            intent = new Intent(getApplicationContext(), TelaCheckBox.class);
            startActivity(intent);
        }
    }


    public void chamarPiramide(View v) {
        if (!edt1.getText().toString().isEmpty() || !edt2.getText().toString().isEmpty() ||
                !edt3.getText().toString().isEmpty()) {
            Toast.makeText(this, "Todos os campos devem estar vazios", Toast.LENGTH_LONG).show();
        } else {
            intent = new Intent(getApplicationContext(), TelaSpinner.class);
            startActivity(intent);
        }
    }

    public void limpar(){
        edt1.requestFocus();
        edt1.setText("");
        edt2.setText("");
        edt3.setText("");
    }
}