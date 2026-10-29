package com.example.sem5;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {

    private ListView listViewProduse;
    private ArrayList<Produs> listaProduse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listViewProduse = findViewById(R.id.listViewProduse);

        // Preluăm lista trimisă prin Intent din MainActivity
        listaProduse = (ArrayList<Produs>) getIntent().getSerializableExtra("lista_produse");

        if (listaProduse != null && !listaProduse.isEmpty()) {
            // Folosim ArrayAdapter pentru a afișa obiectele (va folosi automat toString() din clasa Produs)
            ArrayAdapter<Produs> adapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    listaProduse
            );

            listViewProduse.setAdapter(adapter);

            // Cerința 3: Click simplu pe un obiect din ListView afișează un Toast cu detaliile
            // Click simplu pe un obiect din ListView
            listViewProduse.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(android.widget.AdapterView<?> parent, android.view.View view, int position, long id) {
                    Produs produsSelectat = listaProduse.get(position);
                    Toast.makeText(ListaActivity.this, "Selectat: " + produsSelectat.toString(), Toast.LENGTH_SHORT).show();
                }
            });

            // Cerința 4: Click lung șterge obiectul din ListView și din ArrayList
            listViewProduse.setOnItemLongClickListener((parent, view, position, id) -> {
                Produs produsSters = listaProduse.get(position);
                listaProduse.remove(position);
                adapter.notifyDataSetChanged(); // Actualizăm vizualizarea listei
                Toast.makeText(ListaActivity.this, "Sters: " + produsSters.getDenumire(), Toast.LENGTH_SHORT).show();
                return true;
            });
        } else {
            Toast.makeText(this, "Lista este goală!", Toast.LENGTH_SHORT).show();
        }
    }
}