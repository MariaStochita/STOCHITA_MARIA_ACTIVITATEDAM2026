package com.example.dam_laboratoare;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class activitate3 extends AppCompatActivity {

    private static final String TAG = "activitate3";
    private int suma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitate3);

        TextView txtAfisare = findViewById(R.id.txtAfisare);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String mesaj = bundle.getString("mesaj");
            int numar1 = bundle.getInt("numar1", 0);
            int numar2 = bundle.getInt("numar2", 0);

            int suma = numar1 + numar2;

            String textAfisat = mesaj + " Suma: " + suma;

            txtAfisare.setText(textAfisat);

            Toast.makeText(this, textAfisat, Toast.LENGTH_LONG).show();
            Log.d(TAG, textAfisat);
        }
        Button btnInapoi = findViewById(R.id.btnInapoi);
        btnInapoi.setOnClickListener(v -> {
            Intent intentRezultat = new Intent();
            intentRezultat.putExtra("mesajInapoi", "Am primit datele cu succes!");
            intentRezultat.putExtra("sumaCalculata", suma);

            setResult(RESULT_OK, intentRezultat);
            finish();
        });
    }

}