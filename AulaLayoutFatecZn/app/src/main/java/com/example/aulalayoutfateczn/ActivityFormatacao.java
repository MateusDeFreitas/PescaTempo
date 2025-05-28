package com.example.aulalayoutfateczn;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityFormatacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formatacao);

        Intent intent = getIntent();
        String senhaRecebida = intent.getStringExtra("SENHA");

        TextView textViewSenha = findViewById(R.id.editTextText4);
        textViewSenha.setText(senhaRecebida);

        Button btnEnviar = findViewById(R.id.button4);

        btnEnviar.setOnClickListener(v -> {
            String senhaConfirma = textViewSenha.getText().toString();

            Intent intent2 = new Intent(ActivityFormatacao.this, ActivityConfirma.class);
            intent2.putExtra("SENHA", senhaConfirma);

            startActivity(intent2);
        });
    }

    public void gotoReiniciar(View view) {
        Intent intent = new Intent(ActivityFormatacao.this, ActivityReiniciar.class);
        startActivity(intent);
    }

    public void gotoMain(View view) {
        Intent intent = new Intent(ActivityFormatacao.this, MainActivity.class);
        startActivity(intent);
    }

    public void gotoConfirmar(View view) {
        Intent intent = new Intent(ActivityFormatacao.this, ActivityConfirma.class);
        startActivity(intent);
    }

    public void gotoRestaurar(View view) {
        Intent intent = new Intent(ActivityFormatacao.this, ActivityRestaurar.class);
        startActivity(intent);
    }
}
