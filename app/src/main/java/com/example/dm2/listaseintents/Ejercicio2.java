package com.example.dm2.listaseintents;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Ejercicio2 extends AppCompatActivity {

    ListView listWebs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        Web[] webs = new Web[]{new Web("Youtube","http://www.Youtube.com",R.drawable.youtube),
                new Web("Twitch","http://www.Twitch.com",R.drawable.tiwtch),
                new Web("asdasd","asdadsa",R.drawable.asdasd)};

        AdaptadorWebs adaptador = new AdaptadorWebs(this,webs);

        listWebs=(ListView)findViewById(R.id.listaWebs);
        listWebs.setAdapter(adaptador);
        listWebs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String url = ((Web)parent.getItemAtPosition(position)).getUrl();
                System.out.print(url);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });

    }

    public class Web{

        String titulo,url;
        int imagen;

        public Web(String titulo,String url,int imagen) {
            this.titulo = titulo;
            this.url = url;
            this.imagen = imagen;
        }

        public String  getTitulo(){
            return titulo;
        }

        public String getUrl(){
            return url;
        }

        public int getImagen(){
            return imagen;
        }
    }


    class AdaptadorWebs extends ArrayAdapter<Web> {
        public AdaptadorWebs(Context context, Web[] datos) {
            super(context, R.layout.listawebs, datos);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listawebs, null);

            TextView lblNombre= (TextView) item.findViewById(R.id.nombreWeb);
            lblNombre.setText(getItem(position).getTitulo());
            TextView lblURL = (TextView)item.findViewById(R.id.URLweb);
            lblURL.setText(getItem(position).getUrl());
            ImageView imagen =(ImageView)item.findViewById(R.id.imagenWeb);
            imagen.setImageResource(getItem(position).getImagen());
            return (item);
        }
    }

}
