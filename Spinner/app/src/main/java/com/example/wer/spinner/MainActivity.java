package com.example.wer.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Spinner spinner1;
    private EditText et1;
    private EditText et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
    }

    private void  inicializar(){
        et1 = findViewById(R.id.editText1);
        et2 = findViewById((R.id.editText2));
        tv1 = findViewById(R.id.textViewResultado);
        spinner1 = findViewById(R.id.spinner);

        String [] opciones = {"sumar","restar","multriplicar","dividir"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_o,opciones);
        spinner1.setAdapter(adapter);

    }

    //Metodo operaciones
    public void operar(View view)
    {
        Integer valor1;
        Integer valor2;

        valor1 = Integer.valueOf(et1.getText().toString());
        valor2 = Integer.valueOf(et2.getText().toString());

        Integer resultado;

        String seleccion = spinner1.getSelectedItem().toString();

        if(seleccion.equals("sumar")){
            resultado = valor1 + valor2;
            tv1.setText(resultado.toString());
        }
        else if(seleccion.equals("restar")){
            resultado = valor1 - valor2;
            tv1.setText(resultado.toString());
        }
        else if(seleccion.equals("multriplicar")){
            resultado = valor1 * valor2;
            tv1.setText(resultado.toString());
        }
        else if(seleccion.equals("dividir")){
            if(valor2!=0){
                resultado = valor1 / valor2;
                tv1.setText(resultado.toString());
            }
            else{
                Toast.makeText(this,"Ingrese segundo numero diferente de 0",Toast.LENGTH_SHORT).show();
            }

        }

    }






}//Finaliza la clase Main
