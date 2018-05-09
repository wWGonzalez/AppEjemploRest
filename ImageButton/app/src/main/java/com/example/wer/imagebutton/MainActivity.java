package com.example.wer.imagebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mensajeArchivo (View view){
        Toast.makeText(this,"Archivo",Toast.LENGTH_SHORT).show();
    }
    public void mensajeDinero (View view){
        Toast.makeText(this,"Dinero",Toast.LENGTH_SHORT).show();
    }
    public void mensajeNave (View view){
        Toast.makeText(this,"Nave",Toast.LENGTH_SHORT).show();
    }
}
