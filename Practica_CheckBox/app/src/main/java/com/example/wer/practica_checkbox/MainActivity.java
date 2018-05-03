package com.example.wer.practica_checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private CheckBox cb1, cb2;
    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();



    }

    protected void inicializar(){
        et1 = findViewById(R.id.txt1);
        et2 = findViewById(R.id.txt2);
        cb1 = findViewById((R.id.checkBox));
        cb2 = findViewById((R.id.checkBox2));
        tv1 = findViewById((R.id.textView));

    }

    public void calcular(View view){
        Integer num1, num2;
        Integer resultado;


        num1 = Integer.valueOf(et1.getText().toString());
        num2 = Integer.valueOf(et2.getText().toString());

        try {
            if (cb1.isChecked()) {
                resultado = num1 + num2;
                tv1.setText(resultado.toString());
            } else if (cb2.isChecked()) {
                resultado = num1 - num2;
                tv1.setText(resultado.toString());

            }
        }catch (Exception e){
            Toast.makeText(this, "Faltan Valores",Toast.LENGTH_SHORT).show();
        }

    }


}//Finaliza la clase


