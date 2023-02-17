package CricketGame.Model;

import CricketGame.Controller.Match;

public class Player {
    private int[] battingProb = {0,0, 1, 1, 2, 2, 4, 4, 6, 6};
    private String playerName;
    private int playerNo;
    private String teamName;
    private int runsScored;
    private int sixes;
    private int fours;
    private int ballsPlayed;
    private int oversBowled;
    private int runsConceded;
    private int centuries;
    private int wicketsTaken;
    private int halfCenturies;
    private int[] bowlingProb = {0, 0, 0, 0, 6, -1, 6, 6, 6, 6};


    public String getTeamName(){
        return teamName;
    }

    public String getPlayerName() {
        return playerName;
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

    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

    public int getBallsPlayed() {
        return ballsPlayed;
    }

    public void setBallsPlayed(int ballsPlayed) {
        this.ballsPlayed = ballsPlayed;
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

    public int getCenturies() {
        return centuries;
    }

    public void setCenturies(int centuries) {
        this.centuries = centuries;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public void setWicketsTaken(int wicketsTaken) {
        this.wicketsTaken = wicketsTaken;
    }

    public int getHalfCenturies() {
        return halfCenturies;
    }

    public void setHalfCenturies(int halfCenturies) {
        this.halfCenturies = halfCenturies;
    }
    Player(int playerNo, String team) {
        playerName = team + playerNo;
        this.playerNo = playerNo;
        this.teamName = team;
    }
    public int getPlayerNo(){
        return playerNo;
    }

    public int bat() {
        return battingProb[(int) (Math.random() * battingProb.length)];
    }
    public int bowl(){
        return bowlingProb[(int) (Math.random() * battingProb.length)];
    }

}
