package com.example.aulalayoutfateczn;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;


import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LOGIN";
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        FirebaseApp.initializeApp(this);
        db = FirebaseFirestore.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        EditText editTextSenha = findViewById(R.id.editTextTextPassword2);
        Button btnEnviar = findViewById(R.id.button);
        Button btnEsqueciSenha = findViewById(R.id.button13);

        btnEnviar.setOnClickListener(v -> {
            String senha = editTextSenha.getText().toString();
            String email = editTextEmail.getText().toString();

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }
            db.collection("usuarios")
                    .whereEqualTo("email", email)
                    .whereEqualTo("senha", senha)
                    .get()
                    .addOnSuccessListener(queryDocumentSnapshots -> {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            for (QueryDocumentSnapshot doc : queryDocumentSnapshots) {
                                Log.d(TAG, "Login bem-sucedido: " + doc.getId());
                            }
                            Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();

                            // Redireciona para tela formatacao
                            Intent intent = new Intent(MainActivity.this, ActivityWeather.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(this, "Email ou senha inválidos", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(e -> {
                        Log.w(TAG, "Erro ao tentar logar", e);
                        Toast.makeText(this, "Erro ao tentar logar", Toast.LENGTH_SHORT).show();
                    });

        });


        btnEsqueciSenha.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Recuperar senha");

            // Input para o e-mail
            final EditText input = new EditText(MainActivity.this);
            input.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
            input.setHint("Digite seu e-mail");
            builder.setView(input);

            // Botão Enviar
            builder.setPositiveButton("Enviar", (dialog, which) -> {
                String email = input.getText().toString();
                if (!email.isEmpty()) {
                    FirebaseAuth auth = FirebaseAuth.getInstance();
                    auth.sendPasswordResetEmail(email)
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "E-mail de recuperação enviado!", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "E-mail de recuperação enviado!", Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(MainActivity.this, "Digite um e-mail válido!", Toast.LENGTH_SHORT).show();
                }
            });


            builder.setNegativeButton("Cancelar", (dialog, which) -> dialog.cancel());

            builder.show();
        });

        //TESTE DO FIREBASE ---------------------------------------------------------------

       // FirebaseApp.initializeApp(this);

        //FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Criando um exemplo de dado
        // Map<String, Object> user = new HashMap<>();
        //user.put("nome", "Leilah");
        //user.put("idade", 19);

        //db.collection("usuarios")
                //.add(user)
                //.addOnSuccessListener(new com.google.android.gms.tasks.OnSuccessListener<DocumentReference>() {
                  //  @Override
                   // public void onSuccess(DocumentReference documentReference) {
                   //     Log.d(TAG, "Documento adicionado com ID: " + documentReference.getId());
                   // }
                //})
                //.addOnFailureListener(new com.google.android.gms.tasks.OnFailureListener() {
                  //  @Override
                  //  public void onFailure(Exception e) {
                     //   Log.w(TAG, "Erro ao adicionar documento", e);
                 //   }
              //  });

    }

    public void gotoFormatacao(View view){
        Intent intent = new Intent(MainActivity.this, ActivityFormatacao.class);
        startActivity(intent);
    }
    public void gotoCadastro (View view) {
        Intent intent = new Intent(MainActivity.this, ActivityCadastro.class);
        startActivity(intent);
    }
    public void gotoRecuperar (View view) {
        Intent intent = new Intent(MainActivity.this, ActivityRecuperar.class);
        startActivity(intent);
    }

    public void gotoTempo (View view){
        Intent intent = new Intent(MainActivity.this, ActivityWeather.class);
        startActivity(intent);
    }


    }
