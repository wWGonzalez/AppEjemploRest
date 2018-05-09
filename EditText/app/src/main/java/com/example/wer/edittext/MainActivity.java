package com.example.wer.edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1; //Edittext que contien el nombre
    private EditText ep1;// EditText que contiene el password

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.txt_Name);
        ep1 = findViewById(R.id.txt_Pass);


    }

    public void register(View view){
        String name = et1.getText().toString();
        String pass = ep1.getText().toString();

        if(name.length() == 0){
            Toast.makeText(this,"Ingrese un nombre", Toast.LENGTH_SHORT).show();
        }
        if(pass.length() == 0){
            Toast.makeText(this,"Ingrese un password", Toast.LENGTH_SHORT).show();
        }
        if(name.length() != 0 && pass.length() != 0){
            Toast.makeText(this, "Registro en Proceso",Toast.LENGTH_SHORT).show();
        }

    }//Finish register


}//Finaliza clase Main
