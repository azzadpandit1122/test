package com.azzadpandit.azadproject.Connection;

import com.azzadpandit.azadproject.Model.LoginModel;
import com.azzadpandit.azadproject.Model.NewModel.Example;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ConnectionInterface {

    @POST("azzadpandit1122/api-json/main/db.json")
    Call<Example> login();
}
