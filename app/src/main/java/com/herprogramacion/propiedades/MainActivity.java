package com.herprogramacion.propiedades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (Button) findViewById(R.id.btnlist);
        lista.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent signup = new Intent(MainActivity.this, ListaPropietario.class);
                startActivity(signup);

            }
        });
    }
}
