package com.android.elmaghraby.bakingapp2.internet.Api;

import com.google.gson.JsonArray;
import com.android.elmaghraby.bakingapp2.internet.Routes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET(Routes.END_URL)
    Call<JsonArray> getJson();
}
