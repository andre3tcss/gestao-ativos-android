package br.com.eniac.gestaoativosti.view;

import android.content.Intent; // Importação necessária para a navegação
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import br.com.eniac.gestaoativosti.R;
import br.com.eniac.gestaoativosti.dao.AtivoDAO;
import br.com.eniac.gestaoativosti.model.Ativo;

public class MainActivity extends AppCompatActivity {

    private EditText editNome, editTipo, editValor;
    private Button btnSalvar;
    private AtivoDAO ativoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ativoDAO = new AtivoDAO(this);

        editNome = findViewById(R.id.editNome);
        editTipo = findViewById(R.id.editTipo);
        editValor = findViewById(R.id.editValor);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(v -> salvarAtivo());
    }

    private void salvarAtivo() {
        String nome = editNome.getText().toString().trim();
        String tipo = editTipo.getText().toString().trim();
        String valorString = editValor.getText().toString().trim();

        if (nome.isEmpty() || tipo.isEmpty() || valorString.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double valor = Double.parseDouble(valorString);

            Ativo novoAtivo = new Ativo(0, nome, tipo, "01/04/2026", valor, "Ativo");

            ativoDAO.salvar(novoAtivo);

            Toast.makeText(this, "Salvo com sucesso no SQLite!", Toast.LENGTH_SHORT).show();

            editNome.setText("");
            editTipo.setText("");
            editValor.setText("");
            editNome.requestFocus();

            Intent intent = new Intent(MainActivity.this, ListagemActivity.class);
            startActivity(intent);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Erro no formato do valor numérico", Toast.LENGTH_SHORT).show();
        }
    }
}