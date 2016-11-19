package info.androidhive.proguarddemo.util;

/**
 * Created by Ricardo Bravo on 18/11/16.
 */


public class Util {

    public static String capitalize(String text){
        try{
            text = text.substring(0,1).toUpperCase() + text.substring(1).toLowerCase();
        }catch (Exception e){
            e.printStackTrace();
            return text;
        }
        return text;
    }

}
