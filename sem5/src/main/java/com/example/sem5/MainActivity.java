package com.example.sem5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etDenumire, etPret;
    private Button btnAdauga, btnVeziLista;
    private ArrayList<Produs> listaProduse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDenumire = findViewById(R.id.etDenumire);
        etPret = findViewById(R.id.etPret);
        btnAdauga = findViewById(R.id.btnAdauga);
        btnVeziLista = findViewById(R.id.btnVeziLista);

        listaProduse = new ArrayList<>();

        btnAdauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String denumire = etDenumire.getText().toString().trim();
                String pretStr = etPret.getText().toString().trim();

                if (denumire.isEmpty() || pretStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Completează toate câmpurile!", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    double pret = Double.parseDouble(pretStr);
                    Produs produsNou = new Produs(denumire, pret);
                    listaProduse.add(produsNou);

                    Toast.makeText(MainActivity.this, "Produs adăugat!", Toast.LENGTH_SHORT).show();
                    etDenumire.setText("");
                    etPret.setText("");

                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Introdu un preț valid!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // La apăsarea acestui buton, trimitem lista prin Intent în ListaActivity
        btnVeziLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaActivity.class);
                intent.putExtra("lista_produse", listaProduse);
                startActivity(intent);
            }
        });
    }
}