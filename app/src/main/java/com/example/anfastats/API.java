package com.example.anfastats;

import com.example.anfastats.ModelData.GameData;
import com.example.anfastats.ModelData.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {

    @GET("gamedetail/{id}")
    Call<List<GameData>> getgames(@Path("id") int userid);

    @GET("shots/{gameid}/{team}")
    Call<GameData> shots(@Path("gameid") int gameid, @Path("team") int team);

    @GET("shots-on-target/{gameid}/{team}")
    Call<GameData> shotsontarget(@Path("gameid") int gameid, @Path("team") int team);

    @GET("offside/{gameid}/{team}")
    Call<GameData> offside(@Path("gameid") int gameid, @Path("team") int team);

    @GET("pass/{gameid}/{team}")
    Call<GameData> pass(@Path("gameid") int gameid, @Path("team") int team);

    @GET("corner/{gameid}/{team}")
    Call<GameData> corner(@Path("gameid") int gameid, @Path("team") int team);

    @GET("foul/{gameid}/{team}")
    Call<GameData> foul(@Path("gameid") int gameid, @Path("team") int team);



    @FormUrlEncoded
    @POST("login")
    Call<User> verifylogin(
            @Field("contact") String contact,
            @Field("password") String password

    );


}

