package CricketGame.Model;

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
    private int oversPlayed;
    private int oversBowled;
    private int runsConceded;
    private int sixes;
    private int wicketsTaken;
    private int fours;
    private int noOfBowlers = 5;
    private float netRunRate;
    private int Points;

    public int getPoints(){
        return matchesDrawn + matchesWon * 2;
    }

    public int getOversPlayed() {
        return oversPlayed;
    }

    public float getNetRunRate(){
        netRunRate = (float)runsScored/oversPlayed - (float)runsConceded/oversBowled;
        return netRunRate;
    }

    public void setOversPlayed(int oversPlayed) {
        this.oversPlayed = oversPlayed;
    }

    public int getOversBowled() {
        return oversBowled;
    }

    public void setOversBowled(int oversBowled) {
        this.oversBowled = oversBowled;
    }

    public int getRunsConceded() {
        return runsConceded;
    }

    public void setRunsConceded(int runsConceded) {
        this.runsConceded = runsConceded;
    }


    public int getMatchesWon() {
        return matchesWon;
    }

    public void setMatchesWon(int matchesWon) {
        this.matchesWon = matchesWon;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getMatchesDrawn() {
        return matchesDrawn;
    }

    public void setMatchesDrawn(int matchesDrawn) {
        this.matchesDrawn = matchesDrawn;
    }

    public int getMatchesLost() {
        return matchesLost;
    }

    public void setMatchesLost(int matchesLost) {
        this.matchesLost = matchesLost;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public int getSixes() {
        return sixes;
    }

    public void setSixes(int sixes) {
        this.sixes = sixes;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public void setWicketsTaken(int wicketsTaken) {
        this.wicketsTaken = wicketsTaken;
    }

    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

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
