package com.example.wer.appclient.interfaces;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wer.appclient.R;
import com.example.wer.appclient.clases.Persona;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class PersonaFormulario extends AppCompatActivity {
    EditText cedula, nombre, apellido;
    Persona persona;
    String id_persona;

    //operacion: insertar, actualizar

    String operacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona_formulario);
        inicializar();

        Bundle bundle = getIntent().getExtras();
        this.operacion = bundle.getString("operacion");

        if (this.operacion.equals("actualizar")){
            this.id_persona = bundle.getString("id_persona");
            //obtener persona
            new ObtenerPersona().execute();
        } else {
            this.id_persona = "";
        }

    }

    public void inicializar(){
        this.cedula = (EditText) findViewById(R.id.editTextCedula);
        this.nombre = (EditText) findViewById(R.id.editTextNombre);
        this.apellido = (EditText) findViewById(R.id.editTextApellido);
    }

    public void btn_clickGuardarPersona(View view){
        persona = new Persona();
        persona.setDpi(cedula.getText().toString().trim());
        persona.setNombre(nombre.getText().toString().trim());
        persona.setApellido(apellido.getText().toString().trim());

        if (this.operacion.equals("actualizar"))
            new ActualizarPersona().execute();
        if (this.operacion.equals("insertar"))
            new InsertarPersona().execute();
    }

    public void btn_clickEliminarPersona(View view){
        if (id_persona != ""){
            new EliminarPersona().execute();
        } else
            Toast.makeText(PersonaFormulario.this, "Esta opcion se encuentra disponible \n para personas registradas", Toast.LENGTH_LONG).show();
    }

    private class EliminarPersona extends AsyncTask<Void, Void, Boolean> {
        public Boolean doInBackground(Void... params) {
            HttpClient httpClient = new DefaultHttpClient();

            HttpDelete httpDelete = new HttpDelete("http://192.168.0.107:8000/rest/persona/"+id_persona+"/");
            httpDelete.setHeader("Content-Type", "application/json");

            try {
                httpClient.execute(httpDelete);
                return true;
            } catch (IOException e){
                e.printStackTrace();
                return false;
            }
        }

        public void onPostExecute(Boolean result){
            if(result){
                Toast.makeText(PersonaFormulario.this, "Eliminado Correctamente", Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(PersonaFormulario.this, "Problema al Eliminar", Toast.LENGTH_LONG).show();
        }
    }


    //Insertar Persona
    private class InsertarPersona extends AsyncTask<Void, Void, Boolean> {
        public Boolean doInBackground(Void... params) {
            HttpClient httpClient = new DefaultHttpClient();

            HttpPost httpPost = new HttpPost("http://192.168.0.107:8000/rest/persona/");
            httpPost.setHeader("Content-Type", "application/json");

            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("dpi", persona.getDpi());
                jsonObject.put("nombre", persona.getNombre());
                jsonObject.put("apellido", persona.getApellido());

                StringEntity stringEntity = new StringEntity(jsonObject.toString());
                httpPost.setEntity(stringEntity);
                httpClient.execute(httpPost);

                return true;
            } catch (org.json.JSONException e) {
                return false;
            } catch (java.io.UnsupportedEncodingException e) {
                return false;
            } catch (org.apache.http.client.ClientProtocolException e) {
                return false;
            } catch (java.io.IOException e) {
                return false;
            }
        }

        public void onPostExecute(Boolean result){
            if(result){
                Toast.makeText(PersonaFormulario.this, "Insertado Correctamente", Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(PersonaFormulario.this, "Problema al Insertar", Toast.LENGTH_LONG).show();
        }
    }



    private class ActualizarPersona extends AsyncTask<Void, Void, Boolean>{
        public Boolean doInBackground(Void... params) {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPut httpPut = new HttpPut("http://192.168.0.107:8000/rest/persona/" + id_persona + "/");
            httpPut.setHeader("Content-Type", "application/json");

            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("dpi", persona.getDpi());
                jsonObject.put("nombre", persona.getNombre());
                jsonObject.put("apellido", persona.getApellido());

                StringEntity stringEntity = new StringEntity(jsonObject.toString());
                httpPut.setEntity(stringEntity);
                httpClient.execute(httpPut);

                return true;
            } catch (JSONException e){
                e.printStackTrace();
                return false;
            } catch (java.io.UnsupportedEncodingException e){
                return false;
            } catch (java.io.IOException e){
                return false;
            }
        }

        public void onPostExecute(Boolean result){
            String msj;
            if (result) {
                msj = "Actualizado Correctamente";
            } else {
                msj = "Problemas al actualizar";
            }
                Toast.makeText(PersonaFormulario.this, msj, Toast.LENGTH_SHORT).show();
        }
    }

    private class ObtenerPersona extends AsyncTask<Void, Void, Persona>{
        public Persona doInBackground(Void... params) {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet("http://192.168.0.107:8000/rest/persona/" + id_persona + "/");
            httpGet.setHeader("Content-Type", "application/json");
            persona = new Persona();
            try {
                HttpResponse response = httpClient.execute(httpGet);
                String responString = EntityUtils.toString(response.getEntity());
                JSONObject jsonObject = new JSONObject(responString);

                persona.setDpi(jsonObject.getString("dpi"));
                persona.setNombre(jsonObject.getString("nombre"));
                persona.setApellido(jsonObject.getString("apellido"));

                return persona;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        public void onPostExecute(Persona persona){
            super.onPostExecute(persona);
            if (persona != null){
                cedula.setText(persona.getDpi());
                nombre.setText(persona.getNombre());
                apellido.setText(persona.getApellido());
            } else
                Toast.makeText(PersonaFormulario.this, "Problemas al obtener el objeto", Toast.LENGTH_LONG).show();
        }

    }
}
