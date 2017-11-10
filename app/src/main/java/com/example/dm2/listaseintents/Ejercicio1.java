package com.example.dm2.listaseintents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Ejercicio1 extends AppCompatActivity {

    Spinner cmbPaises;
    TextView lblSuperficie, lblHabitantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        lblSuperficie=(TextView)findViewById(R.id.superficie);
        lblHabitantes=(TextView)findViewById(R.id.habitantes);

        cmbPaises=(Spinner)findViewById(R.id.cmbPaises);
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,
                R.array.paises, android.R.layout.simple_spinner_item);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbPaises.setAdapter(adaptador);

        cmbPaises.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
                switch (adapterView.getSelectedItem().toString()){
                    case "España":
                        lblSuperficie.setText("505,990 km²");
                        lblHabitantes.setText("46.56 millones");
                        break;
                    case "Andorra":
                        lblSuperficie.setText("467.6 km²");
                        lblHabitantes.setText("77,281");
                        break;
                    case "Francia":
                        lblSuperficie.setText("643,801 km²");
                        lblHabitantes.setText("66.9 millones");
                        break;
                    case "Italia":
                        lblSuperficie.setText("301,338 km²");
                        lblHabitantes.setText("60.6 millones");
                        break;
                    case "Alemania":
                        lblSuperficie.setText("357,376 km²");
                        lblHabitantes.setText("82.67 millones");
                        break;
                    case "Groenlandia":
                        lblSuperficie.setText("2.166 millones km²");
                        lblHabitantes.setText("56,186");
                        break;
                    case "Paises Bajos":
                        lblSuperficie.setText("41,543 km²");
                        lblHabitantes.setText("17.02 millones");
                        break;
                }
            }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        
                    }
                });

    }


}
