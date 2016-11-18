package info.androidhive.proguarddemo.api;

import java.util.concurrent.TimeUnit;

import info.androidhive.proguarddemo.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ricardo Bravo on 18/11/16.
 */


public class ApiManager {

    private static ApiInterface apiInterface;

    public static ApiInterface apiManager() {

        if(apiInterface == null){

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

            logging.setLevel(HttpLoggingInterceptor.Level.NONE);

            if(BuildConfig.IS_DEBUG){
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            }

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .build();

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


            apiInterface = client.create(ApiInterface.class);
        }

        return apiInterface;
    }


}
