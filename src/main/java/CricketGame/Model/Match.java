package CricketGame.Model;

import lombok.Data;
import java.util.ArrayList;

@Data
public class Match {
    private int matchId;
    private int team1Score;
    private int team2Score;
    private Team team1;
    private Team team2;
    private int team2Wickets;
    private int noOfOvers;
    private int winner;
    private ArrayList<Integer[]> team1Batting;
    private ArrayList<Integer[]> team2Batting;
    private ArrayList<Integer[]> team1Bowling;
    private ArrayList<Integer[]> team2Bowling;
    private ArrayList<ArrayList<Integer>> innings1, innings2;

    public Match(int matchId, Team team1, Team team2, int noOfOvers) {
        this.matchId = matchId;
        this.team1 = team1;
        this.team2 = team2;
        this.noOfOvers = noOfOvers;
        this.team1Batting = new ArrayList<>();
        this.team2Batting = new ArrayList<>();
        this.team1Bowling = new ArrayList<>();
        this.team2Bowling = new ArrayList<>();
        this.innings1 = new ArrayList<>();
        this.innings2 = new ArrayList<>();
        for (int i = 0; i < team1.getNoOfPlayers(); i++) {
            team1Batting.add(new Integer[5]);
            team2Batting.add(new Integer[5]);
            for (int j = 0; j < 5; j++) {
                team1Batting.get(i)[j] = 0;
                team2Batting.get(i)[j] = 0;
            }
        }
        for (int i = 0; i < team1.getNoOfBowlers(); i++) {
            team1Bowling.add(new Integer[3]);
            team2Bowling.add(new Integer[3]);
            for (int j = 0; j < 3; j++) {
                team1Bowling.get(i)[j] = 0;
                team2Bowling.get(i)[j] = 0;
            }
        }
    }

    public void update(String bb, Player player, int attr, int val, String t) {
        if (t.equals("t1")) {
            if (bb.equals("bowl")) {
                team1Bowling.get(player.getPlayerNo() - 1 - (team1.getNoOfPlayers() - team1.getNoOfBowlers()))[attr] += val;
                switch (attr) {
                    case 0 -> player.setOversBowled(player.getOversBowled() + val);
                    case 1 -> player.setRunsConceded(player.getRunsConceded() + val);
                    case 2 -> {
                        team1.setWicketsTaken(team1.getWicketsTaken() + 1);
                        player.setWicketsTaken(player.getWicketsTaken() + val);
                    }
                }
            } else {
                team1Batting.get(player.getPlayerNo() - 1)[attr] += val;
                switch (attr) {
                    case 0 -> {
                        team1.setRunsScored(team1.getRunsScored() + 1);
                        player.setRunsScored(player.getRunsScored() + val);
                    }
                    case 1 -> {
                        team1.setSixes(team1.getSixes() + 1);
                        player.setSixes(player.getSixes() + val);
                    }
                    case 2 -> {
                        team1.setFours(team1.getFours() + 1);
                        player.setFours(player.getFours() + val);
                    }
                    case 3 -> player.setBallsPlayed(player.getBallsPlayed() + val);
                    case 4 -> team1Batting.get(player.getPlayerNo() - 1)[attr] = val;
                }
            }
        } else {
            if (bb.equals("bowl")) {
                team2Bowling.get(player.getPlayerNo() - 1 - (team1.getNoOfPlayers() - team1.getNoOfBowlers()))[attr] += val;
                switch (attr) {
                    case 0 -> player.setOversBowled(player.getOversBowled() + val);
                    case 1 -> player.setRunsConceded(player.getRunsConceded() + val);
                    case 2 -> {
                        team2.setWicketsTaken(team2.getWicketsTaken() + 1);
                        player.setWicketsTaken(player.getWicketsTaken() + val);
                    }
                }
            } else {
                team2Batting.get(player.getPlayerNo() - 1)[attr] += val;
                switch (attr) {
                    case 0 -> {
                        team2.setRunsScored(team2.getRunsScored() + 1);
                        player.setRunsScored(player.getRunsScored() + val);
                    }
                    case 1 -> {
                        team2.setSixes(team2.getSixes() + 1);
                        player.setSixes(player.getSixes() + val);
                    }
                    case 2 -> {
                        team2.setFours(team2.getFours() + 1);
                        player.setFours(player.getFours() + val);
                    }
                    case 3 -> player.setBallsPlayed(player.getBallsPlayed() + val);
                    case 4 -> team2Batting.get(player.getPlayerNo() - 1)[attr] = val;
                }
            }
        }
    }


    public void overUpdate(ArrayList<Integer> over, String inn) {
        if (inn.equals("innings1"))
            innings1.add(over);
        else
            innings2.add(over);
    }

    public void innings1TotalScore(int runs) {
        team1Score += runs;
    }


    public void innings2TotalScore(int runs) {
        team2Score += runs;
    }

    public int getTarget() {
        return team1Score + 1;
    }


    public void increaseT2Wicket() {
        team2Wickets++;
    }


    public Integer[] getPlayerStats(String bb, String t, int no) {
        if (t.equals("t1")) {
            if (bb.equals("bat"))
                return team1Batting.get(no - 1);
            else
                return team1Bowling.get(no - 1 - (team1.getNoOfPlayers() - team1.getNoOfBowlers()));
        } else {

            if (bb.equals("bat"))
                return team2Batting.get(no - 1);
            else
                return team2Bowling.get(no - 1 - (team1.getNoOfPlayers() - team1.getNoOfBowlers()));
        }
    }
}
