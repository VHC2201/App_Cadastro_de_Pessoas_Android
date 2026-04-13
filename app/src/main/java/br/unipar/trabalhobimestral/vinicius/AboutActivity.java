package br.unipar.trabalhobimestral.vinicius;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * Activity estática destinada a exibir os dados acadêmicos e a 
 * autoria do projeto (A "Capa" do trabalho).
 * * @author Vinicius Cordeiro
 */
public class AboutActivity extends AppCompatActivity {

    private static final String TAG = "LIFECYCLE_ABOUT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Log.i(TAG, "onCreate: AboutActivity instanciada.");

        // Habilita a seta de voltar na Toolbar (Up Navigation)
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish(); // Encerra a tela atual e volta para a anterior
        return true;
    }

    // --- Logs do Ciclo de Vida ---

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: AboutActivity visível.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: AboutActivity em primeiro plano.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: AboutActivity perdendo foco.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: AboutActivity parada.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: AboutActivity destruída.");
    }
}