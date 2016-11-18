package info.androidhive.proguarddemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.proguarddemo.R;
import info.androidhive.proguarddemo.api.ApiCallManager;
import info.androidhive.proguarddemo.api.listener.PokemonListener;
import info.androidhive.proguarddemo.model.response.PokemonResponse;
import info.androidhive.proguarddemo.view.adapter.PokemonAdapter;

public class MainActivity extends AppCompatActivity implements PokemonListener {

    private RecyclerView rcvPokemon;
    private PokemonAdapter pokemonAdapter;
    private final List<PokemonResponse.ResultsEntity> resultsEntityList = new ArrayList<>();
    private ApiCallManager apiCallManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvPokemon = (RecyclerView) findViewById(R.id.rcvPokemon);

        apiCallManager = new ApiCallManager(this, this);
        LinearLayoutManager layoutManager;layoutManager = new LinearLayoutManager(this);
        rcvPokemon.setLayoutManager(layoutManager);

        pokemonAdapter = new PokemonAdapter(this, resultsEntityList);
        rcvPokemon.setAdapter(pokemonAdapter);
        rcvPokemon.setItemAnimator(new DefaultItemAnimator());

        apiCallManager.getPokemon();

    }

    @Override
    public void onResponse(PokemonResponse pokemonResponse) {
        resultsEntityList.addAll(pokemonResponse.getResults());
        pokemonAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(String error) {
        Toast.makeText(this, getString(R.string.error_ocurred), Toast.LENGTH_SHORT).show();
    }

}
