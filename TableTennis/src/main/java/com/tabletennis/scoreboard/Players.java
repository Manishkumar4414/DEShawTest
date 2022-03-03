package com.tabletennis.scoreboard;

public class Players{

    private String playerName;
    private int score;

    public Players( String playerName, int score ){
        this.playerName = playerName;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
