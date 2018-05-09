package com.example.wer.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SegundoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
    }

    //Boton para regresar
    public void anterior(View view){
        Intent ant = new Intent(this, MainActivity.class);
        startActivity(ant);
    }

}
