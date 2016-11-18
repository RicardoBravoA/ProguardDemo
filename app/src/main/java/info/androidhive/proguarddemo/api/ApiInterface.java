package info.androidhive.proguarddemo.api;

import info.androidhive.proguarddemo.BuildConfig;
import info.androidhive.proguarddemo.model.response.PokemonResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ricardo Bravo on 18/11/16.
 */


public interface ApiInterface {

    @GET(BuildConfig.URL_POKEMON)
    Call<PokemonResponse> getPokemon();
}
