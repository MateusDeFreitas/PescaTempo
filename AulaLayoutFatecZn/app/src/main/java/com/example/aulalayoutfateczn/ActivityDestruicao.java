package com.example.aulalayoutfateczn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityDestruicao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autodestruicao);

        Intent intent = getIntent();
        String senhaRecebida = intent.getStringExtra("SENHA");

        TextView textViewSenha = findViewById(R.id.editTextText2);
        textViewSenha.setText(senhaRecebida);

        Button btnEnviar = findViewById(R.id.button8);

        btnEnviar.setOnClickListener(v -> {
            String senhaDest = textViewSenha.getText().toString();

            Intent intent3 = new Intent(ActivityDestruicao.this, ActivityFormatacao.class);
            intent3.putExtra("SENHA", senhaDest);

            startActivity(intent3);
        });

    }

    public void gotoFormatacao(View view){
        Intent intent = new Intent(ActivityDestruicao.this, ActivityFormatacao.class);
        startActivity(intent);
    }
}
