package com.tabletennis.scoreboard;

import javax.sound.midi.Soundbank;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// input P1 means P1 got the point input P2 means P2 got the point

        Players player1 = new Players("P1",0);
        Players player2 = new Players("P2",0);
        List<Players> playerList = new ArrayList();
        playerList.add(player1);
        playerList.add(player2);

        Scoreboard scoreboard = new Scoreboard();
        System.out.println("Game Type 10/20 points Game");
        System.out.println("1 : 10 point game");
        System.out.println("2 : 20 point game");
        int gameType = sc.nextInt();
        scoreboard.setGameType(gameType == Scoreboard.WIN_SCORE_10 ? Scoreboard.WIN_SCORE_10:Scoreboard.WIN_SCORE_20);//Scoreboard.WIN_SCORE_20
        scoreboard.setPlayerList(playerList);
        int count = 1;

        System.out.println("Starting the TT Match");
        System.out.println("Call for Toss Select Player");
        System.out.println("1: Player1");
        System.out.println("2: Player2");
        int selectedPlayer = sc.nextInt();
        System.out.println("Select Head or Tail");
        System.out.println("1: Head");
        System.out.println("2: Tail");
        int choice = sc.nextInt();

        int rndChoice = (int) ( Math.random() * 2 + 1);

        if( rndChoice == 1 ){
            System.out.println("Toss Result :: Head");
        }
        else{
            System.out.println("Toss Result :: Tail");
        }

        if(selectedPlayer == 1 ){
            if(choice == rndChoice)
            System.out.println("Player1 Starting to serve");
            else
                System.out.println("Player2 Starting to serve");
        }
        if( selectedPlayer == 2 ){
            if(choice == rndChoice)
            System.out.println("Player2 Starting to serve");
            else
                System.out.println("Player1 Starting to serve");
        }

        System.out.println("Game Started Selecte the Palyer won the point");
        scoreboard.setGameWon(false);
        System.out.println("1: Player1");
        System.out.println("2: Player2");
        while( !scoreboard.isGameWon() ){
            int pointForPlayer = sc.nextInt();
            if(pointForPlayer == 1){
                //players = new Players("P1",scoreboard.getCurrentScore(0) + 1);
                scoreboard.updateScore(player1);
                scoreboard.displayScore();
            }else if( pointForPlayer == 2 ){
                scoreboard.updateScore(player2);
                scoreboard.displayScore();
            }else{
                System.out.println("Bad data");
                count --;
            }
            count ++;
        }


    }

}
