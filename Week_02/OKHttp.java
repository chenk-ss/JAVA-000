package com.chenk.java02;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @Author chenk
 * @create 2020/10/28 19:31
 */
public class OKHttp {
    static OkHttpClient client = new OkHttpClient();
    public static String run(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(run("http://localhost:8801"));
    }
}
