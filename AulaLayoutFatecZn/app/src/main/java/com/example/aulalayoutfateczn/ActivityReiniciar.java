package com.example.aulalayoutfateczn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityReiniciar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reiniciar);
    }
    public void gotoFormatacao(View view){
        Intent intent = new Intent(ActivityReiniciar.this, ActivityFormatacao.class);
        startActivity(intent);
    }

}
