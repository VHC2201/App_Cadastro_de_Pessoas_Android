package br.unipar.trabalhobimestral.vinicius;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

/**
 * Classe principal responsável por gerenciar a tela de entrada de dados do usuário.
 * Interage com o layout activity_main e prepara os dados para transição via Intent.
 * * @author Vinicius Cordeiro
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LIFECYCLE_MAIN";
    private EditText entradaNome, entradaIdade, entradaEndereco;
    private Button botaoSalvarDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: Activity instanciada e layout carregado na memória.");

        // Amarração dos componentes do nosso novo XML
        entradaNome = findViewById(R.id.entrada_nome);
        entradaIdade = findViewById(R.id.entrada_idade);
        entradaEndereco = findViewById(R.id.entrada_endereco);
        botaoSalvarDados = findViewById(R.id.botao_salvar_dados);

        // Listener do botão para capturar e enviar os dados
        botaoSalvarDados.setOnClickListener(v -> enviarDadosParaResultado());

        // Verifica se a Activity foi aberta recebendo dados de volta
        processarIntentRecebida(getIntent());
    }

    /**
     * Empacota os dados preenchidos nos EditTexts e inicia a ResultActivity.
     */
    private void enviarDadosParaResultado() {
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("NOME_USUARIO", entradaNome.getText().toString());
        intent.putExtra("IDADE_USUARIO", entradaIdade.getText().toString());
        intent.putExtra("ENDERECO_USUARIO", entradaEndereco.getText().toString());
        startActivity(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        processarIntentRecebida(intent);
    }

    /**
     * Processa a Intent recebida, seja para limpar os campos (caso o usuário tenha
     * confirmado) ou para repovoá-los (caso o usuário queira editar).
     * * @param intent Intent recebida contendo as flags de controle.
     */
    private void processarIntentRecebida(Intent intent) {
        if (intent == null) return;

        if (intent.getBooleanExtra("LIMPAR_DADOS", false)) {
            entradaNome.setText("");
            entradaIdade.setText("");
            entradaEndereco.setText("");
            intent.removeExtra("LIMPAR_DADOS");
        } else if (intent.hasExtra("NOME_USUARIO")) {
            entradaNome.setText(intent.getStringExtra("NOME_USUARIO"));
            entradaIdade.setText(intent.getStringExtra("IDADE_USUARIO"));
            entradaEndereco.setText(intent.getStringExtra("ENDERECO_USUARIO"));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_about) {
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // --- Logs do Ciclo de Vida Exigidos pelo Professor ---

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: Activity tornou-se visível ao usuário.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: Activity em primeiro plano, pronta para interação.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: Activity perdendo o foco principal.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: Activity não é mais visível.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: Activity sendo destruída pelo sistema.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: Activity voltando do estado de Stop.");
    }
}