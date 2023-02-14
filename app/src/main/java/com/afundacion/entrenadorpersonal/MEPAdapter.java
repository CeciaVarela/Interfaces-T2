package com.afundacion.entrenadorpersonal;

import android.graphics.Typeface;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MEPAdapter extends RecyclerView.Adapter<MEPAdapter.ViewHolder> {
    private final List<Ejercicio> localDataSet;
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        private final TextView textViewNombre;
        private final TextView textViewDuracion;
        private final TextView textViewCalorias;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            Typeface fuente = Typeface.createFromAsset(view.getContext().getAssets(), "fonts/centurygothic.ttf");
            textViewNombre = (TextView) view.findViewById(R.id.nombre);
            textViewNombre.setTypeface(fuente);
            textViewDuracion = (TextView) view.findViewById(R.id.duracion);
            textViewDuracion.setTypeface(fuente);
            textViewCalorias = (TextView) view.findViewById(R.id.calorias);
            textViewCalorias.setTypeface(fuente);
            view.setOnCreateContextMenuListener(this);
        }

        public TextView getTextView() {
            return textViewNombre;
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {

            contextMenu.add(0,1,0,"editar");
            contextMenu.add(0,2,0,"borrar");
        }

    }

    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public MEPAdapter(List <Ejercicio> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.ec_item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Ejercicio ejercicio = localDataSet.get(position);
        viewHolder.textViewNombre.setText(ejercicio.getNombre());
        viewHolder.textViewDuracion.setText("" + ejercicio.getTime());
        viewHolder.textViewCalorias.setText("" + ejercicio.getCalorias());
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setPosition(viewHolder.getAdapterPosition());
                return false;

            }
        });


        //viewHolder.getTextView().setText(localDataSet[position]);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }


    @Override
    public void onViewRecycled(ViewHolder holder) {
        holder.itemView.setOnLongClickListener(null);
        super.onViewRecycled(holder);
    }
}