package com.example.aulalayoutfateczn;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.DocumentReference;

import java.util.HashMap;
import java.util.Map;

public class ActivityCadastro extends AppCompatActivity {
    private static final String TAG = "FIREBASE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        Button btnCadastrar = findViewById(R.id.button10);
        EditText nome = findViewById(R.id.editTextText3);
        EditText email = findViewById(R.id.editTextTextEmailAddress3);
        EditText senha = findViewById(R.id.editTextNumberPassword);



        btnCadastrar.setOnClickListener(v -> {

            String Nome = nome.getText().toString();
            String Email = email.getText().toString();
            String Senha = senha.getText().toString();

            Map<String, Object> user = new HashMap<>();
            user.put("nome", Nome);
            user.put("email", Email);
            user.put("senha", Senha);

            FirebaseApp.initializeApp(this);


            FirebaseFirestore db = FirebaseFirestore.getInstance();

            db.collection("usuarios")
                    .add(user)
                    .addOnSuccessListener(new com.google.android.gms.tasks.OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d(TAG, "usuario cadastrado com ID: " + documentReference.getId());
                            Toast.makeText(ActivityCadastro.this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ActivityCadastro.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .addOnFailureListener(new com.google.android.gms.tasks.OnFailureListener() {
                        @Override
                        public void onFailure(Exception e) {
                            Log.w(TAG, "Erro ao cadastrar usuario", e);
                        }
                    });



        });
    }
}
