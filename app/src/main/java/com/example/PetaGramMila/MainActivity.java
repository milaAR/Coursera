package com.example.PetaGramMila;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.example.PetaGramMila.Objetos.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    RecyclerView rvMascota;
    MascotaAdaptador mascotaAdaptador;
    androidx.appcompat.widget.Toolbar actionbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionbar = findViewById(R.id.miActionBar);
        setSupportActionBar(actionbar);
        rvMascota = findViewById(R.id.rvMascota);
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Casilda", 3, "Perro", "Perro", "Juan", R.drawable.dog1));
        mascotas.add(new Mascota("Anastasio", 2, "Perro", "Perro", "Felipe", R.drawable.dog2));
        mascotas.add(new Mascota("Valiente", 4, "Perro", "Perro", "Tomasa", R.drawable.dog3));
        mascotas.add(new Mascota("Chispas", 7, "Perro", "Perro", "Daniel", R.drawable.dog4));
        mascotas.add(new Mascota("Rex", 1, "Perro", "Perro", "Max", R.drawable.dog5));

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascota.setLayoutManager(llm);
        mascotaAdaptador = new MascotaAdaptador(mascotas, this);
        rvMascota.setAdapter(mascotaAdaptador);
    }

    private void setSupportActionBar(Toolbar actionbar) {
    }

    //Para que se ponga en mi action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favorit:
//                Bundle bundle=new Bundle();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("arreglo",mascotas);
                startActivity(intent);
                return true;
            case R.id.opciones:
               return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}