package info.androidhive.proguarddemo.model.response;

import java.util.List;

/**
 * Created by Ricardo Bravo on 18/11/16.
 */


public class PokemonResponse {


    /**
     * count : 811
     * previous : null
     * results : [{"url":"http://pokeapi.co/api/v2/pokemon/1/","name":"bulbasaur"},{"url":"http://pokeapi.co/api/v2/pokemon/2/","name":"ivysaur"},{"url":"http://pokeapi.co/api/v2/pokemon/3/","name":"venusaur"},{"url":"http://pokeapi.co/api/v2/pokemon/4/","name":"charmander"},{"url":"http://pokeapi.co/api/v2/pokemon/5/","name":"charmeleon"},{"url":"http://pokeapi.co/api/v2/pokemon/6/","name":"charizard"},{"url":"http://pokeapi.co/api/v2/pokemon/7/","name":"squirtle"},{"url":"http://pokeapi.co/api/v2/pokemon/8/","name":"wartortle"},{"url":"http://pokeapi.co/api/v2/pokemon/9/","name":"blastoise"},{"url":"http://pokeapi.co/api/v2/pokemon/10/","name":"caterpie"},{"url":"http://pokeapi.co/api/v2/pokemon/11/","name":"metapod"},{"url":"http://pokeapi.co/api/v2/pokemon/12/","name":"butterfree"},{"url":"http://pokeapi.co/api/v2/pokemon/13/","name":"weedle"},{"url":"http://pokeapi.co/api/v2/pokemon/14/","name":"kakuna"},{"url":"http://pokeapi.co/api/v2/pokemon/15/","name":"beedrill"},{"url":"http://pokeapi.co/api/v2/pokemon/16/","name":"pidgey"},{"url":"http://pokeapi.co/api/v2/pokemon/17/","name":"pidgeotto"},{"url":"http://pokeapi.co/api/v2/pokemon/18/","name":"pidgeot"},{"url":"http://pokeapi.co/api/v2/pokemon/19/","name":"rattata"},{"url":"http://pokeapi.co/api/v2/pokemon/20/","name":"raticate"}]
     * next : http://pokeapi.co/api/v2/pokemon/?offset=20
     */

    private int count;
    private Object previous;
    private String next;
    private List<ResultsEntity> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<ResultsEntity> getResults() {
        return results;
    }

    public void setResults(List<ResultsEntity> results) {
        this.results = results;
    }

    public static class ResultsEntity {
        /**
         * url : http://pokeapi.co/api/v2/pokemon/1/
         * name : bulbasaur
         */

        private String url;
        private String name;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
