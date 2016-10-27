package com.herprogramacion.propiedades.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.herprogramacion.propiedades.Datos.Propietario;
import com.herprogramacion.propiedades.R;

import java.util.ArrayList;

/**
 * Created by lds on 24/10/2016.
 */
public class PropietarioAdapter extends ArrayAdapter<Propietario> {

    private final Context contexto;
    private ArrayList<Propietario> datospeli;

    public PropietarioAdapter(Context context, ArrayList<Propietario> datospeli) {
        super(context, -1, datospeli);
        this.contexto = context;
        this.datospeli = datospeli;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) contexto
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View LayoutPro = inflater.inflate(R.layout.adapter_propietario, parent, false);

        TextView namePro = (TextView) LayoutPro.findViewById(R.id.name);
        TextView telPro = (TextView) LayoutPro.findViewById(R.id.telefono);
        TextView profPro = (TextView) LayoutPro.findViewById(R.id.profesion);

        Propietario datos = datospeli.get(position);

        namePro.setText(datos.getNombre());
        telPro.setText(datos.getTelefono());
        profPro.setText(datos.getProfecion());

        return LayoutPro;

    }


}