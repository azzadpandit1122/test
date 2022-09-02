package com.azzadpandit.azadproject.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.azzadpandit.azadproject.Connection.Api;
import com.azzadpandit.azadproject.Connection.RetrofitManager;
import com.azzadpandit.azadproject.Model.NewModel.Example;
import com.azzadpandit.azadproject.R;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataActvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_actvity);

        getDat();
    }

    private void getDat() {
//        ArrayList<Example> data1 = new ArrayList<>();
        Example example = new Example();
        Call<Example> call = RetrofitManager.getApiClient().create(Api.class).dataofapi();
       call.enqueue(new Callback<Example>() {
           @Override
           public void onResponse(Call<Example> call, Response<Example> response) {
               Log.d("TAG", "onResponse: "+response.body().toString());

           }

           @Override
           public void onFailure(Call<Example> call, Throwable t) {

           }
       });
    }
}