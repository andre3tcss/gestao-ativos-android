package br.com.eniac.gestaoativosti.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import br.com.eniac.gestaoativosti.R;
import br.com.eniac.gestaoativosti.adapter.AtivoAdapter;
import br.com.eniac.gestaoativosti.dao.AtivoDAO;
import br.com.eniac.gestaoativosti.model.Ativo;

public class ListagemActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AtivoAdapter adapter;
    private AtivoDAO ativoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        recyclerView = findViewById(R.id.recyclerViewAtivos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ativoDAO = new AtivoDAO(this);
        List<Ativo> ativosSalvos = ativoDAO.listarTodos();

        adapter = new AtivoAdapter(ativosSalvos);
        recyclerView.setAdapter(adapter);
    }
}