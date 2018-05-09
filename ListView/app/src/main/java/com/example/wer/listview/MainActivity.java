package com.example.wer.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private ListView lv1;

    private String nombre []= {"valentina","sofia","wer","armando","lucho"};
    private String edad[] = {"12","8","25","22","4"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();

    }

    private void inicializar(){
        tv1 = findViewById(R.id.textView1);
        lv1 = findViewById(R.id.listView1);

        ArrayAdapter<String> lista = new ArrayAdapter<String>(this,R.layout.list_item_o, nombre);
        lv1.setAdapter(lista);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tv1.setText("La edad de: " + lv1.getItemAtPosition(i) + " es: "+ edad[i]+ " años" + lv1.getCount()
                );
            }
        });
    }




}//Finaliza la clase main
