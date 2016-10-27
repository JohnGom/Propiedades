package com.herprogramacion.propiedades;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.herprogramacion.propiedades.Adaptador.CasaAdaptador;
import com.herprogramacion.propiedades.Adaptador.PropietarioAdapter;
import com.herprogramacion.propiedades.BaseDatos.Conexion;
import com.herprogramacion.propiedades.Datos.Casa;
import com.herprogramacion.propiedades.Datos.Config;
import com.herprogramacion.propiedades.Datos.Propietario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListaCasa extends AppCompatActivity {

    String id;
    ArrayList<Casa> cas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_casa);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        System.out.println(id);
        ListView ListPeli = (ListView) findViewById(R.id.casaList);
        CasaAdaptador adapter = new CasaAdaptador(this, cas);
        ListPeli.setAdapter(adapter);
        getJSON();
    }


    private void showEmplo(String json){
        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(Config.CAS_ID);
                String name = jo.getString(Config.CAS_NAME);
                String tama = jo.getString(Config.CAS_TAM);
                String pre = jo.getString(Config.CAS_PRE);

                cas.add(new Casa(name, tama, pre));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ListaCasa.this,"Fetching Data","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmplo(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                Conexion rh = new Conexion();
                String s = rh.sendGetRequestParam(Config.URL_GET_CAS,id);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }
}