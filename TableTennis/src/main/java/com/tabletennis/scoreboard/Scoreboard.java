package com.tabletennis.scoreboard;

import java.util.List;

public class Scoreboard {
    private List<Players> playerList;
    public static final int WIN_SCORE_10 = 10;
    public static final int WIN_SCORE_20 = 20;
    private int gameType;
    private boolean isGameWon;

    public boolean isGameWon() {
        return isGameWon;
    }

    public void setGameWon(boolean gameWon) {
        isGameWon = gameWon;
    }

    public int getGameType() {
        return gameType;
    }

    public void setGameType(int gameType) {
        this.gameType = gameType;
    }

    public List<Players> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Players> playerList) {
        this.playerList = playerList;
    }

    public void displayScore(){
        System.out.println("Scoreboard");
        if( this.playerList.isEmpty() ){
            System.out.println("Match Not Started");
        }
        else{
            System.out.println("Player Name #"+playerList.get(0).getPlayerName()+"Score #"+playerList.get(0).getScore());
            System.out.println("Player Name #"+playerList.get(1).getPlayerName()+"Score #"+playerList.get(1).getScore());
        }
    }

    public int getCurrentScore( int index ){
        return playerList.get(index).getScore();
    }

    public void updateScore( Players player ){
        if( gameType == WIN_SCORE_10 ){
            if( !isGameWon ){
                if(player.getPlayerName().equals(playerList.get(0).getPlayerName())){
                    if( playerList.get(0).getScore() != WIN_SCORE_10 ) {
                        playerList.get(0).setScore(playerList.get(0).getScore() + 1);
                    }else{
                        isGameWon = true;
                        playerList.get(0).setScore(playerList.get(0).getScore() + 1);
                    }
                }
                else if( player.getPlayerName().equals(playerList.get(1).getPlayerName())){
                    if( playerList.get(1).getScore() != WIN_SCORE_10  ) {
                        playerList.get(1).setScore(playerList.get(1).getScore() + 1);
                    }else{
                        isGameWon = true;
                        playerList.get(1).setScore(playerList.get(1).getScore() + 1);
                    }
                }
                else{
                    System.out.println("Invalid Player");
                }
            }
        }
        else{
            if( !isGameWon ){
                int currectScore = getCurrentScore(0);
                if(player.getPlayerName().equals(playerList.get(0).getPlayerName())){
                    if( currectScore != WIN_SCORE_20 ) {
                        playerList.add(0, player);
                    }else{
                        isGameWon = true;
                        playerList.add(0, player);
                    }
                }
                else if( player.getPlayerName().equals(playerList.get(1).getPlayerName())){
                    if( currectScore != WIN_SCORE_20 ) {
                        playerList.add(1, player);
                    }else{
                        isGameWon = true;
                        playerList.add(1, player);
                    }
                }
                else{
                    System.out.println("Invalid Player");
                }
            }
        }

    }
}
