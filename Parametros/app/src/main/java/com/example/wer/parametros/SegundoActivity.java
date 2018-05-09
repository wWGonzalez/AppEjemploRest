package com.example.wer.parametros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SegundoActivity extends AppCompatActivity {

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
    tv1 = findViewById(R.id.textView);
    String dato = getIntent().getStringExtra("dato");
    tv1.setText("Hola" + dato.toString());
    }

    public  void regresar(View view){
        Intent o = new Intent(this, MainActivity.class);
        startActivity(o);
    }


}
