package info.androidhive.proguarddemo.view.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import info.androidhive.proguarddemo.R;
import info.androidhive.proguarddemo.model.response.PokemonResponse;
import info.androidhive.proguarddemo.util.Util;

/**
 * Created by Ricardo Bravo on 18/11/16.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {

    private final List<PokemonResponse.ResultsEntity> resultsEntityList;
    private Context context;

    public PokemonAdapter(Context context, List<PokemonResponse.ResultsEntity> resultsEntityList) {
        this.context = context;
        this.resultsEntityList = resultsEntityList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.item_pokemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PokemonResponse.ResultsEntity resultsEntity = resultsEntityList.get(position);
        holder.lblDescription.setText(Util.capitalize(resultsEntity.getName()));
    }

    @Override
    public int getItemCount() {
        return resultsEntityList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView lblDescription;
        private final CardView cvPokemon;

        public ViewHolder(View view) {
            super(view);

            lblDescription = (TextView) view.findViewById(R.id.lblDescription);
            cvPokemon = (CardView) view.findViewById(R.id.cvPokemon);

            cvPokemon.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.cvPokemon){
                Toast.makeText(context, context.getString(R.string.message_toast,
                        Util.capitalize(resultsEntityList.get(getAdapterPosition()).getName())),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}