package com.azzadpandit.azadproject.Connection;

import com.azzadpandit.azadproject.Model.NewModel.Example;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface Api {
//    https://raw.githubusercontent.com/azzadpandit1122/api-json/main/db.json
    @GET("azzadpandit1122/api-json/main/db.json")
    Call<Example> dataofapi();

}
