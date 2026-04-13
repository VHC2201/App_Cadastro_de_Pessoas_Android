package br.unipar.trabalhobimestral.vinicius;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Classe responsável por exibir os dados trafegados da tela principal e 
 * solicitar a validação do usuário (Sim/Não).
 * * @author Vinicius Cordeiro
 */
public class ResultActivity extends AppCompatActivity {

    private static final String TAG = "LIFECYCLE_RESULT";
    private TextView textoNome, textoIdade, textoEndereco;
    private Button botaoSim, botaoNao;
    private String nomeRecebido, idadeRecebida, enderecoRecebido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Log.i(TAG, "onCreate: ResultActivity instanciada.");

        // Amarração dos componentes do nosso novo XML
        textoNome = findViewById(R.id.texto_resultado_nome);
        textoIdade = findViewById(R.id.texto_resultado_idade);
        textoEndereco = findViewById(R.id.texto_resultado_endereco);
        botaoSim = findViewById(R.id.botao_sim);
        botaoNao = findViewById(R.id.botao_nao);

        recuperarExibirDados();
        configurarBotoesAcao();
    }

    /**
     * Desempacota o Bundle recebido via Intent e popula os TextViews da interface.
     */
    private void recuperarExibirDados() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            nomeRecebido = extras.getString("NOME_USUARIO");
            idadeRecebida = extras.getString("IDADE_USUARIO");
            enderecoRecebido = extras.getString("ENDERECO_USUARIO");

            textoNome.setText(nomeRecebido);
            textoIdade.setText(idadeRecebida);
            textoEndereco.setText(enderecoRecebido);
        }
    }

    /**
     * Configura os listeners dos botões de confirmação e negação, definindo 
     * o comportamento de retorno para a MainActivity usando flags adequadas.
     */
    private void configurarBotoesAcao() {
        botaoSim.setOnClickListener(v -> {
            Toast.makeText(ResultActivity.this, R.string.toast_saved, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            intent.putExtra("LIMPAR_DADOS", true);
            startActivity(intent);
            finish();
        });

        botaoNao.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            intent.putExtra("NOME_USUARIO", nomeRecebido);
            intent.putExtra("IDADE_USUARIO", idadeRecebida);
            intent.putExtra("ENDERECO_USUARIO", enderecoRecebido);
            startActivity(intent);
            finish();
        });
    }

    // --- Logs do Ciclo de Vida ---

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ResultActivity visível.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ResultActivity em primeiro plano.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ResultActivity perdendo foco.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ResultActivity parada.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ResultActivity destruída.");
    }
}