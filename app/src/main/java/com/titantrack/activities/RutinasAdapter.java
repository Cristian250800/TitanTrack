package com.titantrack.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.titantrack.R;
import java.util.List;

public class RutinasAdapter extends RecyclerView.Adapter<RutinasAdapter.RutinaViewHolder> {

private List<RutinaModel> listaRutinas;

public RutinasAdapter(List<RutinaModel> listaRutinas) {
    this.listaRutinas = listaRutinas;
}

@NonNull
@Override
public RutinaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rutina, parent, false);
    return new RutinaViewHolder(view);
}

@Override
public void onBindViewHolder(@NonNull RutinaViewHolder holder, int position) {
    RutinaModel rutina = listaRutinas.get(position);
    holder.tvTitulo.setText(rutina.getTitulo());
    holder.tvDetalle.setText(rutina.getDetalles());
}

@Override
public int getItemCount() {
    return listaRutinas.size();
}

public static class RutinaViewHolder extends RecyclerView.ViewHolder {
    TextView tvTitulo;
    TextView tvDetalle;

    public RutinaViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTitulo = itemView.findViewById(R.id.tvTituloRutina);
        tvDetalle = itemView.findViewById(R.id.tvDetalleRutina);
    }
}
}