package com.example.anfastats.ModelData;

import com.google.gson.annotations.SerializedName;

public class GameData {
    private String firstTeam;
    private String secondTeam;
    private String gameTime;
    private String ImgTeam1;
    private String ImgTeam2;
    private int gameid;
    private String gameStadium;


    public GameData(String firstTeam, String secondTeam, String gameTime, String imgTeam1, String imgTeam2, int gameid, String gameStadium) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.gameTime = gameTime;
        ImgTeam1 = imgTeam1;
        ImgTeam2 = imgTeam2;
        this.gameid = gameid;
        this.gameStadium = gameStadium;
    }

    public String getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(String firstTeam) {
        this.firstTeam = firstTeam;
    }

    public String getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(String secondTeam) {
        this.secondTeam = secondTeam;
    }

    public String getGameTime() {
        return gameTime;
    }

    public void setGameTime(String gameTime) {
        this.gameTime = gameTime;
    }

    public String getImgTeam1() {
        return ImgTeam1;
    }

    public void setImgTeam1(String imgTeam1) {
        ImgTeam1 = imgTeam1;
    }

    public String getImgTeam2() {
        return ImgTeam2;
    }

    public void setImgTeam2(String imgTeam2) {
        ImgTeam2 = imgTeam2;
    }

    public int getGameid() {
        return gameid;
    }

    public void setGameid(int gameid) {
        this.gameid = gameid;
    }

    public String getGameStadium() {
        return gameStadium;
    }

    public void setGameStadium(String gameStadium) {
        this.gameStadium = gameStadium;
    }
}
