package com.example.anfastats;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cuboid.cuboidcirclebutton.CuboidButton;
import com.example.anfastats.ModelData.GameData;

import java.util.List;

import at.markushi.ui.CircleButton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateStats extends AppCompatActivity {

    int gameid;
    String team1, team2;
    Vibrator vibe;

    CuboidButton buttonshotsteam1, buttonshotsteam2 , buttonoffsideteam1, buttonoffsideteam2,
            buttoncornerteam1, buttoncornerteam2, buttonontargetteam1, buttonontargetteam2 , buttonfoulsteam1 ,
            buttonfoulsteam2 , buttonpassteam1 , buttonpassteam2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_stats);

        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        getSupportActionBar().hide();
        gameid = getIntent().getIntExtra("gameid",0);

        team1 = getIntent().getStringExtra("team1");
        team2 = getIntent().getStringExtra("team2");


        Toast.makeText(this, String.valueOf(gameid), Toast.LENGTH_SHORT).show();


        TextView team1text = (TextView)this.findViewById(R.id.team1textview);
        TextView team2text = (TextView)this.findViewById(R.id.team2textview);



        team1text.setText(team1);
        team2text.setText(team2);

        buttonshotsteam1 = findViewById(R.id.buttonshotsteam1);
        buttonshotsteam2 = findViewById(R.id.buttonshotsteam2);
        buttoncornerteam1 = findViewById(R.id.buttoncornersteam1);
        buttoncornerteam2 = findViewById(R.id.buttoncornersteam2);
        buttonoffsideteam1 = findViewById(R.id.buttonoffsideteam1);
        buttonoffsideteam2 = findViewById(R.id.buttonoffsideteam2);
        buttonfoulsteam1 = findViewById(R.id.buttonfoulsteam1);
        buttonfoulsteam2 = findViewById(R.id.buttonfoulsteam2);
        buttonontargetteam1 = findViewById(R.id.buttonshotsontargetteam1);
        buttonontargetteam2 = findViewById(R.id.buttonshotsontargetteam2);
        buttonpassteam1 = findViewById(R.id.buttonpassteam1);
        buttonpassteam2 = findViewById(R.id.buttonpassteam2);



        buttonpassteam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseteam1pass();
            }
        });

        buttonpassteam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseteam2pass();

            }
        });

        buttonontargetteam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseteam1ontarget();

            }
        });


        buttonontargetteam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseontargetteam2();


            }
        });




        buttonoffsideteam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseoffsideteam1();
            }
        });

        buttonoffsideteam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                increaseoffsideteam2();

            }
        });

        buttoncornerteam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                increasecornertteam1();

            }
        });

        buttoncornerteam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increasecornerteam2();
            }
        });



        buttonshotsteam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseshotsteam1();
            }
        });

        buttonshotsteam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                increaseshotsteam2();


            }
        });
        
        
        buttonfoulsteam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                increasefoulteam1();

                
            }
        });
        
        buttonfoulsteam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increasefoulsteam2();
            }
        });

    }

    private void increaseteam2pass() {

        Call<GameData> call = RetrofitClient.getmInstance().getretrofit(getApplicationContext()).pass(gameid,2);
        call.enqueue(new Callback<GameData>() {
            @Override
            public void onResponse(Call<GameData> call, Response<GameData> response) {
                Toast.makeText(UpdateStats.this, "Pass2", Toast.LENGTH_SHORT).show();
                vibe.vibrate(100);


            }

            @Override
            public void onFailure(Call<GameData> call, Throwable t) {
                Toast.makeText(UpdateStats.this, "Fail"+t, Toast.LENGTH_SHORT).show();

            }
        });



    }

    private void increaseteam1ontarget() {

        Call<GameData> call = RetrofitClient.getmInstance().getretrofit(getApplicationContext()).shotsontarget(gameid,1);
        call.enqueue(new Callback<GameData>() {
            @Override
            public void onResponse(Call<GameData> call, Response<GameData> response) {
                Toast.makeText(UpdateStats.this, "Shot1", Toast.LENGTH_SHORT).show();
                vibe.vibrate(100);



            }

            @Override
            public void onFailure(Call<GameData> call, Throwable t) {

                Toast.makeText(UpdateStats.this, "miss"+t, Toast.LENGTH_SHORT).show();


            }
        });



    }

    private void increaseontargetteam2() {

        Call<GameData> call =  RetrofitClient.getmInstance().getretrofit(getApplicationContext()).shotsontarget(gameid,2);
        call.enqueue(new Callback<GameData>() {
            @Override
            public void onResponse(Call<GameData> call, Response<GameData> response) {
                Toast.makeText(UpdateStats.this, "Shot2", Toast.LENGTH_SHORT).show();
                vibe.vibrate(100);



            }

            @Override
            public void onFailure(Call<GameData> call, Throwable t) {

                Toast.makeText(UpdateStats.this, "miss"+t, Toast.LENGTH_SHORT).show();


            }
        });


    }

    private void increaseoffsideteam1() {

        Call<GameData> call = RetrofitClient.getmInstance().getretrofit(getApplicationContext()).offside(gameid,1);
        call.enqueue(new Callback<GameData>() {
            @Override
            public void onResponse(Call<GameData> call, Response<GameData> response) {
                Toast.makeText(UpdateStats.this, "Offside1", Toast.LENGTH_SHORT).show();
                vibe.vibrate(100);



            }

            @Override
            public void onFailure(Call<GameData> call, Throwable t) {

                Toast.makeText(UpdateStats.this, "miss"+t, Toast.LENGTH_SHORT).show();


            }
        });




    }

    private void increaseoffsideteam2() {

        Call<GameData> call = RetrofitClient.getmInstance().getretrofit(getApplicationContext()).offside(gameid,2);
        call.enqueue(new Callback<GameData>() {
            @Override
            public void onResponse(Call<GameData> call, Response<GameData> response) {
                Toast.makeText(UpdateStats.this, "Offside2", Toast.LENGTH_SHORT).show();
                vibe.vibrate(100);



            }

            @Override
            public void onFailure(Call<GameData> call, Throwable t) {

                Toast.makeText(UpdateStats.this, "miss"+t, Toast.LENGTH_SHORT).show();


            }
        });

    }

    private void increasecornertteam1() {

        Call<GameData> call = RetrofitClient.getmInstance().getretrofit(getApplicationContext()).corner(gameid,1);
        call.enqueue(new Callback<GameData>() {
            @Override
            public void onResponse(Call<GameData> call, Response<GameData> response) {
                Toast.makeText(UpdateStats.this, "Corner1", Toast.LENGTH_SHORT).show();
                vibe.vibrate(100);



            }

            @Override
            public void onFailure(Call<GameData> call, Throwable t) {

                Toast.makeText(UpdateStats.this, "miss"+t, Toast.LENGTH_SHORT).show();


            }
        });

    }

    private void increasecornerteam2() {

        Call<GameData> call = RetrofitClient.getmInstance().getretrofit(getApplicationContext()).corner(gameid,2);
        call.enqueue(new Callback<GameData>() {
            @Override
            public void onResponse(Call<GameData> call, Response<GameData> response) {
                Toast.makeText(UpdateStats.this, "Corner2", Toast.LENGTH_SHORT).show();
                vibe.vibrate(100);



            }

            @Override
            public void onFailure(Call<GameData> call, Throwable t) {

                Toast.makeText(UpdateStats.this, "miss"+t, Toast.LENGTH_SHORT).show();


            }
        });

    }

    private void increasefoulteam1() {

        Call<GameData> call = RetrofitClient.getmInstance().getretrofit(getApplicationContext()).foul(gameid,1);
        call.enqueue(new Callback<GameData>() {
            @Override
            public void onResponse(Call<GameData> call, Response<GameData> response) {
                Toast.makeText(UpdateStats.this, "Foul1", Toast.LENGTH_SHORT).show();
                vibe.vibrate(100);



            }

            @Override
            public void onFailure(Call<GameData> call, Throwable t) {

                Toast.makeText(UpdateStats.this, "miss"+t, Toast.LENGTH_SHORT).show();


            }
        });




    }


    private void increasefoulsteam2() {

        Call<GameData> call = RetrofitClient.getmInstance().getretrofit(getApplicationContext()).foul(gameid,2);
        call.enqueue(new Callback<GameData>() {
            @Override
            public void onResponse(Call<GameData> call, Response<GameData> response) {
                Toast.makeText(UpdateStats.this, "Foul2", Toast.LENGTH_SHORT).show();
                vibe.vibrate(100);


            }

            @Override
            public void onFailure(Call<GameData> call, Throwable t) {
                Toast.makeText(UpdateStats.this, "miss"+t, Toast.LENGTH_SHORT).show();


            }
        });


    }

    private void increaseteam1pass() {
        Call<GameData> call = RetrofitClient.getmInstance().getretrofit(getApplicationContext()).pass(gameid,1);
        call.enqueue(new Callback<GameData>() {
            @Override
            public void onResponse(Call<GameData> call, Response<GameData> response) {

                Toast.makeText(UpdateStats.this, "Pass1", Toast.LENGTH_SHORT).show();
                vibe.vibrate(100);


            }

            @Override
            public void onFailure(Call<GameData> call, Throwable t) {
                Toast.makeText(UpdateStats.this, "miss"+t, Toast.LENGTH_SHORT).show();


            }
        });


    }

    private void increaseshotsteam1() {

        Call<GameData> call = RetrofitClient.getmInstance().getretrofit(getApplicationContext()).shots(gameid,1);
        call.enqueue(new Callback<GameData>() {
            @Override
            public void onResponse(Call<GameData> call, Response<GameData> response) {
                Toast.makeText(UpdateStats.this, "Shot1", Toast.LENGTH_SHORT).show();
                vibe.vibrate(100);

            }

            @Override
            public void onFailure(Call<GameData> call, Throwable t) {
                Toast.makeText(UpdateStats.this, "Miss"+t, Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void increaseshotsteam2() {

        Call<GameData> call = RetrofitClient.getmInstance().getretrofit(getApplicationContext()).shots(gameid,2);
        call.enqueue(new Callback<GameData>() {
            @Override
            public void onResponse(Call<GameData> call, Response<GameData> response) {
                Toast.makeText(UpdateStats.this, "Shot2", Toast.LENGTH_SHORT).show();
                vibe.vibrate(100);

            }

            @Override
            public void onFailure(Call<GameData> call, Throwable t) {
                Toast.makeText(UpdateStats.this, "Miss2"+t, Toast.LENGTH_SHORT).show();

            }
        });

    }
}
