package com.example.maktaba;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.HttpUrl;
import okhttp3.Request;

public class OpenlibService {
    public static void findBooks(String book, Callback callback){
        OkHttpClient client=new OkHttpClient.Builder().build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BOOKS_BASE_URL).newBuilder();
        String url=urlBuilder.build().toString();

        Request request=new Request.Builder().url(url).build();

        Call call= client.newCall(request);
        call.enqueue(callback);
    }

}
