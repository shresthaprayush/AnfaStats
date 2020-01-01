package com.example.anfastats;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.anfastats.ModelData.GameData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity2 extends AppCompatActivity {


    private Button button;
    private String username;
    RecyclerView recyclerView;
    private  int userid;
    List<GameData> gameData;
    MatchAdapter matchAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        username = SharedPreferencemanager.getmInstance(this).getUser().getName();
        userid = SharedPreferencemanager.getmInstance(this).getUser().getUserid();

        recyclerView = findViewById(R.id.recycleviewgamedata);

        Toast.makeText(this, "Hello"+username+ userid, Toast.LENGTH_SHORT).show();


        getdata(userid);


    }

    private void getdata(int userid) {

        Call<List<GameData>> call = RetrofitClient.getmInstance().getretrofit(getApplicationContext()).getgames(userid);

        call.enqueue(new Callback<List<GameData>>() {
            @Override
            public void onResponse(Call<List<GameData>> call, Response<List<GameData>> response) {

                if(response.body()!=null){

                    gameData = response.body();
                    matchAdapter = new MatchAdapter(gameData,getApplicationContext());
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView.setAdapter(matchAdapter);




                }

                else {
                    Toast.makeText(Activity2.this, "We have an error", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<GameData>> call, Throwable t) {

                Toast.makeText(Activity2.this, "Something Went Wrong"+t, Toast.LENGTH_LONG).show();

            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

        if (!SharedPreferencemanager.getmInstance(this).isLoggedIn()){

            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }
    }
}
