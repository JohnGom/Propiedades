package com.herprogramacion.propiedades.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.herprogramacion.propiedades.Datos.Casa;
import com.herprogramacion.propiedades.Datos.Propietario;
import com.herprogramacion.propiedades.R;

import java.util.ArrayList;

/**
 * Created by lds on 26/10/2016.
 */
public class CasaAdaptador  extends ArrayAdapter<Casa> {

    private final Context contexto;
    private ArrayList<Casa> datospeli;

    public CasaAdaptador(Context context, ArrayList<Casa> datospeli) {
        super(context, -1, datospeli);
        this.contexto = context;
        this.datospeli = datospeli;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) contexto
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View LayoutPro = inflater.inflate(R.layout.adapter_casa, parent, false);

        TextView namec = (TextView) LayoutPro.findViewById(R.id.namecasa);
        TextView tamc = (TextView) LayoutPro.findViewById(R.id.tamaño);
        TextView prec= (TextView) LayoutPro.findViewById(R.id.precio);

        Casa datos = datospeli.get(position);

        namec.setText(datos.getNombre());
        tamc.setText(datos.getTamaño());
        prec.setText(datos.getPrecio());

        return LayoutPro;

    }


}
