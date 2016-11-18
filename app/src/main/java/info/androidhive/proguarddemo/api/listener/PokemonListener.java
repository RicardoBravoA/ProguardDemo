package info.androidhive.proguarddemo.api.listener;

import info.androidhive.proguarddemo.model.response.PokemonResponse;

/**
 * Created by Ricardo Bravo on 18/11/16.
 */


public interface PokemonListener {

    void onResponse(PokemonResponse pokemonResponse);
    void onFailure(String error);

}
