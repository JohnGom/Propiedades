package com.herprogramacion.propiedades;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.herprogramacion.propiedades.Adaptador.PropietarioAdapter;
import com.herprogramacion.propiedades.BaseDatos.Conexion;
import com.herprogramacion.propiedades.Datos.Config;
import com.herprogramacion.propiedades.Datos.Proper;
import com.herprogramacion.propiedades.Datos.Propietario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class ListaPropietario extends AppCompatActivity {

    private ListView ListPeli;
    ArrayList<Propietario> pro = new ArrayList<>();
    ArrayList<Proper> prop = new ArrayList<>();
    String namep;
    String idp;

    private String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_propietario);

        ListPeli = (ListView) findViewById(R.id.propieList);
        PropietarioAdapter adapter = new PropietarioAdapter(this, pro);
        ListPeli.setAdapter(adapter);
        getJSON();

        ListPeli.setOnItemClickListener(new ItemList());
    }



    private void showEmployee(){
        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(Config.TAG_ID);
                String name = jo.getString(Config.TAG_NAME);
                String tele = jo.getString(Config.TAG_TEL);
                String prof = jo.getString(Config.TAG_PRO);

                pro.add(new Propietario(name,tele,prof));
                prop.add(new Proper(id,name,tele,prof));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String>{

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ListaPropietario.this,"Fetching Data","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showEmployee();
            }

            @Override
            protected String doInBackground(Void... params) {
                Conexion rh = new Conexion();
                String s = rh.sendGetRequest(Config.URL_GET_ALL);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    private class ItemList implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ViewGroup vg = (ViewGroup) view;
            TextView tv = (TextView) vg.findViewById(R.id.name);
            Intent ven = new Intent(ListaPropietario.this, ListaCasa.class);
            namep = tv.getText().toString();
            for(int i=0; i< prop.size(); i++) {
                if(prop.get(i).getNombre()==namep){
                    idp=prop.get(i).getId();
                }
            }
            ven.putExtra("id", idp);
            startActivity(ven);
        }
    }



}

