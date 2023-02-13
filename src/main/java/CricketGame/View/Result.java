package CricketGame.View;
import CricketGame.Model.Player;
import CricketGame.Model.Team;

import java.util.ArrayList;

public class Result {
    public int t1Score;
    public int t2Score;
    public Team t1;
    public Team t2;
    public int t2Wickets;
    public int noOfOvers;
    public ArrayList<Integer[]> team1Batting;
    public ArrayList<Integer[]> team2Batting;
    public ArrayList<Integer[]> team1Bowling;
    public ArrayList<Integer[]> team2Bowling;
    public ArrayList<ArrayList<Integer>> innings1, innings2;

    public Result(Team t1, Team t2,int noOfOvers){
        this.t1 = t1;
        this.t2 = t2;
        this.noOfOvers = noOfOvers;
        this.team1Batting = new ArrayList<>();
        this.team2Batting = new ArrayList<>();
        this.team1Bowling = new ArrayList<>();
        this.team2Bowling = new ArrayList<>();
        this.innings1 = new ArrayList<ArrayList<Integer>>();
        this.innings2 = new ArrayList<ArrayList<Integer>>();
        for(int i = 0 ; i < t1.getNoOfPlayers(); i++){
            team1Batting.add(new Integer[5]);
            team2Batting.add(new Integer[5]);
            for(int j = 0 ; j < 5;j++){
                team1Batting.get(i)[j]=0;
                team2Batting.get(i)[j]=0;
            }
        }
        for(int i = 0 ; i < t1.getNoOfBowlers(); i++){
            team1Bowling.add(new Integer[3]);
            team2Bowling.add(new Integer[3]);
            for(int j = 0 ; j < 3;j++){
                team1Bowling.get(i)[j]=0;
                team2Bowling.get(i)[j]=0;
            }
        }
    }
    public void update(String bb, Player player, int attr, int val, String t){
        if(t.equals("t1")){
            if(bb.equals("bowl")){
                team1Bowling.get(player.getPlayerNo()-1-(t1.getNoOfPlayers()-t1.getNoOfBowlers()))[attr]+=val;
                switch(attr){
                    case 0:
                        player.setOversBowled(player.getOversBowled()+val);
                        break;
                    case 1:
                        player.setRunsConceded(player.getRunsConceded()+val);
                        break;
                    case 2:
                        player.setWicketsTaken(player.getWicketsTaken()+val);
                        break;
                }
            }
            else{
                team1Batting.get(player.getPlayerNo()-1)[attr]+=val;
                switch(attr){
                    case 0:
                        player.setRunsScored(player.getRunsScored()+val);
                        break;
                    case 1:
                        player.setSixes(player.getSixes()+val);
                        break;
                    case 2:
                        player.setFours(player.getFours()+val);
                        break;
                    case 3:
                        player.setBallsPlayed(player.getBallsPlayed()+val);
                        break;
                    case 4:
                        team1Batting.get(player.getPlayerNo()-1)[attr] = val;
                }
            }
        }else{
            if(bb.equals("bowl")){
                team2Bowling.get(player.getPlayerNo()-1-(t1.getNoOfPlayers()-t1.getNoOfBowlers()))[attr]+=val;
                switch(attr){
                    case 0:
                        player.setOversBowled(player.getOversBowled()+val);
                        break;
                    case 1:
                        player.setRunsConceded(player.getRunsConceded()+val);
                        break;
                    case 2:
                        player.setWicketsTaken(player.getWicketsTaken()+val);
                        break;
                }
            }
            else{
                team2Batting.get(player.getPlayerNo()-1)[attr]+=val;
                switch(attr){
                    case 0:
                        player.setRunsScored(player.getRunsScored()+val);
                        break;
                    case 1:
                        player.setSixes(player.getSixes()+val);
                        break;
                    case 2:
                        player.setFours(player.getFours()+val);
                        break;
                    case 3:
                        player.setBallsPlayed(player.getBallsPlayed()+val);
                        break;
                    case 4:
                        team2Batting.get(player.getPlayerNo()-1)[attr] = val;
                }
            }
        }
    }
//
//    public void out(Player batsmen, Player bowler){
//
//    }
    public void overUpdate(ArrayList<Integer> over, String inn){
        if(inn.equals(innings1))
            innings1.add(over);
        else
            innings2.add(over);
    }
    public void innings1TotalScore(int runs){
        t1Score += runs;
    }

    public void innings2TotalScore(int runs){
        t2Score += runs;
    }
    public int getTarget(){
        return t1Score+1;
    }
    public int  getT2Total(){
        return t2Score;
    }
    public void increaseT2Wicket(){
        t2Wickets++;
    }
    public int getT2Wickets(){
        return t2Wickets;
    }
    public Integer[] getPlayerStats(String bb, String t, int no){
        if(t.equals("t1")){
            if(bb.equals("bat"))
                return team1Batting.get(no-1);
            else
                return team1Bowling.get(no-1-(t1.getNoOfPlayers()-t1.getNoOfBowlers()));
        }
        else{

            if(bb.equals("bat"))
                return team2Batting.get(no-1);
            else
                return team2Bowling.get(no-1-(t1.getNoOfPlayers()-t1.getNoOfBowlers()));
        }
    }
//    public void allOut(){
//
//    }
}
