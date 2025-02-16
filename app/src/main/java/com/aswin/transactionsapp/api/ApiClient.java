package com.aswin.transactionsapp.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static String WEB_BASE_URL = "https://payzana.remitap.com";

    public static String country = "Botswana/";


    private static String BASE_URL = "http://192.168.48.16:8080/lab/"; // UAT

    private static OkHttpClient.Builder httpClient = null;

    public static Retrofit getRetrofit() {
        return new Retrofit.Builder().baseUrl(ApiClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getHttpClient().build())
                .build();
    }

    private static OkHttpClient.Builder getHttpClient() {
        if (httpClient == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient = new OkHttpClient.Builder();
            httpClient.connectTimeout(15000, TimeUnit.SECONDS);
            httpClient.readTimeout(60000, TimeUnit.SECONDS).build();
            httpClient.addInterceptor(logging);
        }
        return httpClient;
    }

    public static String getUrlType() {
        if (BASE_URL.contains("https://payzana.remitap.com/Mobile/")) {
            return "LIVE";
        }else if (BASE_URL.contains("http://stagebotswana.remitap.com:9091/MobileAPI/")) {
            return "STAGE";
        }else if (BASE_URL.contains("https://payzana.remitap.com/MobileAPI/")) {
            return "CLOUD STAGE";
        }else if (BASE_URL.contains("http://stagebotswana.remitap.com:9091/MobileAPILive/")) {
            return "UAT";
        }
        return "";
    }
}
