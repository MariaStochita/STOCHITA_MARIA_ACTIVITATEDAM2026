package com.example.dam_laboratoare;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class activitate2 extends AppCompatActivity {

    private final ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    String mesaj = result.getData().getStringExtra("mesajInapoi");
                    int sumaPrimita = result.getData().getIntExtra("sumaCalculata", 0);

                    Toast.makeText(this, mesaj + " Suma: " + sumaPrimita, Toast.LENGTH_LONG).show();
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitate2);

        Button btnDeschide3 = findViewById(R.id.btnDeschide3);
        btnDeschide3.setOnClickListener(v -> {
            Intent intent = new Intent(activitate2.this, activitate3.class);
            Bundle bundle = new Bundle();
            bundle.putString("mesaj", "Salut din Activitatea 2!");
            bundle.putInt("numar1", 5);
            bundle.putInt("numar2", 10);
            intent.putExtras(bundle);

            launcher.launch(intent);
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("activitate2", "onStart apelat");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("activitate2", "onResume apelat");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w("activitate2", "onPause apelat");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("activitate2", "onStop apelat");
    }
}