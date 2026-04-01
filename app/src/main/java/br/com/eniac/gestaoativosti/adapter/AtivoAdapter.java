package br.com.eniac.gestaoativosti.adapter;
import br.com.eniac.gestaoativosti.model.Ativo;
import br.com.eniac.gestaoativosti.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Locale;

public class AtivoAdapter extends RecyclerView.Adapter<AtivoAdapter.AtivoViewHolder> {

    private List<Ativo> listaAtivos;
    public AtivoAdapter(List<Ativo> listaAtivos) {
        this.listaAtivos = listaAtivos;
    }

    @NonNull
    @Override
    public AtivoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Pega o XML do card e "infla" (transforma em objeto Java)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ativo, parent, false);
        return new AtivoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AtivoViewHolder holder, int position) {
        // Pega o ativo na posição atual e preenche o Card
        Ativo ativo = listaAtivos.get(position);

        holder.textNome.setText(ativo.getNome());
        holder.textTipo.setText("Categoria: " + ativo.getTipo());

        String valorFormatado = String.format(Locale.getDefault(), "R$ %.2f", ativo.getValor());
        holder.textValor.setText(valorFormatado);
    }

    @Override
    public int getItemCount() {
        return listaAtivos.size();
    }

    static class AtivoViewHolder extends RecyclerView.ViewHolder {
        TextView textNome, textTipo, textValor;

        public AtivoViewHolder(@NonNull View itemView) {
            super(itemView);
            textNome = itemView.findViewById(R.id.textItemNome);
            textTipo = itemView.findViewById(R.id.textItemTipo);
            textValor = itemView.findViewById(R.id.textItemValor);
        }
    }
}