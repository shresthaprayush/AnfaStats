package com.example.anfastats;

import android.content.Context;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final RetrofitClient mInstance = new RetrofitClient();


    private static final String BaseURL = "http://afs.com.np/api/";
    private static final String BaseURLlcoal = "http://192.168.43.226/login/";

    private Retrofit retrofit;
    public static final String HEADER_CACHE_CONTROL = "Cache-Control";
    public static final String HEADER_PRAGMA = "Pragma";
    public Cache mCache;

    public static RetrofitClient getmInstance() {


        return mInstance;
    }

    private RetrofitClient() {
    }

    public API getretrofit(Context context) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .addInterceptor(provideOfflineCacheInterceptor(context))
                .addNetworkInterceptor(provideCacheInterceptor(context))
                .cache(provideCache(context));



        return new Retrofit.Builder().baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build().create(API.class);
    }

    private Cache provideCache(Context context) {
        if (mCache == null) {
            try {
                mCache = new Cache(new File(context.getCacheDir(), "http-cache"),
                        10 * 1024 * 1024); // 10 MB
            } catch (Exception e) {
                Log.e("sdf", "Could not create Cache!");

            }
        }
        return mCache;
    }

    private Interceptor provideCacheInterceptor(Context context) {
        return chain -> {
            okhttp3.Response response = chain.proceed(chain.request());
            CacheControl cacheControl;

            if (isConnected(context)) {
                cacheControl = new CacheControl.Builder()
                        .maxAge(0, TimeUnit.SECONDS)
                        .build();
            } else {
                cacheControl = new CacheControl.Builder()
                        .maxStale(5, TimeUnit.DAYS)
                        .build();
            }

            return response.newBuilder()
                    .removeHeader(HEADER_PRAGMA)
                    .removeHeader(HEADER_CACHE_CONTROL)
                    .header(HEADER_CACHE_CONTROL, cacheControl.toString())
                    .build();

        };
    }


    private Interceptor provideOfflineCacheInterceptor(Context context) {
        return chain -> {
            Request request = chain.request();

            if (!isConnected(context)) {
                CacheControl cacheControl = new CacheControl.Builder()
                        .maxStale(7, TimeUnit.DAYS)
                        .build();

                request = request.newBuilder()
                        .removeHeader(HEADER_PRAGMA)
                        .removeHeader(HEADER_CACHE_CONTROL)
                        .cacheControl(cacheControl)
                        .build();
            }

            return chain.proceed(request);
        };
    }


    public boolean isConnected(Context context) {
        try {
            android.net.ConnectivityManager e = (android.net.ConnectivityManager) context.getSystemService(
                    Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = e.getActiveNetworkInfo();
            return activeNetwork != null && activeNetwork.isConnected();
        } catch (Exception e) {
            Log.w("Tag", e.toString());
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }

        return false;
    }




}
