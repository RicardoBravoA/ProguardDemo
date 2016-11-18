package info.androidhive.proguarddemo.api;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import info.androidhive.proguarddemo.R;
import info.androidhive.proguarddemo.api.listener.PokemonListener;
import info.androidhive.proguarddemo.model.response.PokemonResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ricardo Bravo on 18/11/16.
 */


public class ApiCallManager {

    private PokemonListener pokemonListener;
    private Context context;

    public ApiCallManager(Context context, PokemonListener pokemonListener){
        this.pokemonListener = pokemonListener;
        this.context = context;
    }

    public void getPokemon(){

        Call<PokemonResponse> call = ApiManager.apiManager().getPokemon();
        call.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if(response.isSuccessful()){
                    pokemonListener.onResponse(response.body());
                }else{
                    pokemonListener.onFailure(context.getString(R.string.error_ocurred));
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                pokemonListener.onFailure(t.getMessage());
            }
        });
    }

}
