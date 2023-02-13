package CricketGame.Model;

import CricketGame.View.DataBase;

import java.util.ArrayList;

public class Team {
    private ArrayList<Player> players;
    private ArrayList<Player> bowlers;
    private int noOfPlayers;
    private int matchesWon;
    private int matchesPlayed;
    private int matchesDrawn;
    private int matchesLost;
    private int runsScored;
    private int sixes;
    private int fours;
    private int noOfBowlers = 5;

    public String getTeamName() {
        return teamName;
    }

    private String teamName;
    public Team(String name,int noOfPlayers){
        this.teamName = name;
        this.noOfPlayers = noOfPlayers;
        this.noOfBowlers = noOfPlayers/2;
        this.bowlers = new ArrayList<>();
        players = new ArrayList<Player>();
        for(int i = 0; i < noOfPlayers;i++){
            players.add(new Player(i+1,teamName));
        }
        for(int i = noOfPlayers-1 ; i >= noOfPlayers-1-noOfBowlers; i--){
            bowlers.add(players.get(i));
        }
    }

    public int getNoOfPlayers() {
        return noOfPlayers;
    }


    public int getNoOfBowlers() {
        return noOfBowlers;
    }

    public Player getPlayer(int index){
        return players.get(index);
    }

    public Player getBowler(int index){
        return bowlers.get(index);
    }



}
