package com.example.wer.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Boton Siguiente
    public void siguiente(View view){
    Intent sig = new Intent(this, SegundoActivity.class);
    startActivity(sig);

    }

}//Finaliza Main
