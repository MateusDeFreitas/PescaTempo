package com.example.aulalayoutfateczn;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityConfirma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirma);

        Intent intent = getIntent();
        String senhaRecebida = intent.getStringExtra("SENHA");

        TextView textViewSenha = findViewById(R.id.editTextText);
        textViewSenha.setText(senhaRecebida);

        Button btnEnviar = findViewById(R.id.button9);

        btnEnviar.setOnClickListener(v -> {
            String senhaConfirma = textViewSenha.getText().toString();

            Intent intent2 = new Intent(ActivityConfirma.this, ActivityDestruicao.class);
            intent2.putExtra("SENHA", senhaConfirma);

            startActivity(intent2);
        });
    }

    public void gotoDestruir(View view) {
        Intent intent = new Intent(ActivityConfirma.this, ActivityDestruicao.class);
        startActivity(intent);
    }
}
