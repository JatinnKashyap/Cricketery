package CricketGame.Service;

import CricketGame.Model.Player;
import CricketGame.Model.Team;
import CricketGame.Model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ScoreBoardService {
    @Autowired
    TeamService ts;

    public void displayMatchResult(Match match) {

//        System.out.println("Displaying result");
        System.out.println(match.getTeam1().getTeamName() + " won the toss and have elected to bat first\n");
        System.out.println("Innings 1 ScoreBoard : \n\n" + match.getTeam1().getTeamName() + " Batting!");
        System.out.println("Player no.\t\tPlayer name\t\tRuns Scored\t\t Balls Faced\t\tSixes/Fours\t\tStrike Rate\n");
        for (int i = 0; i < match.getTeam1().getNoOfPlayers(); i++) {
            Player player = match.getTeam1().getPlayer(i);
            Integer[] playerStats = match.getPlayerStats("bat", "t1", player.getPlayerNo());
            String no = String.format("%1$" + 10 + "s", player.getPlayerNo());
            String name = String.format("%1$" + 10 + "s", player.getPlayerName());
            String run = String.format("%1$" + 10 + "s", playerStats[0]);
            String balls = String.format("%1$" + 10 + "s", playerStats[3]);
            String sf = String.format("%1$" + 10 + "s", (playerStats[1] + " / " + playerStats[2]));
            float sr;
            try {
                sr = (float) playerStats[0] / playerStats[3];
            } catch (Exception e) {
                sr = 0;
            }
            String sra = String.format("%1$" + 10 + "s", String.format("%.2f", sr * 100));
            System.out.println(no + "\t\t" + name + (playerStats[4] == -1 ? "*" : "") + "\t\t" + run + "\t\t" + balls + "\t\t" + sf + "\t\t" + sra + "\t\t" + (playerStats[4] != -1 ? (playerStats[4] == 0 ? "Did not Bat" : "Bowled out by " + match.getTeam2().getPlayer(playerStats[4] - 1).getPlayerName()) : "Not Out"));
        }
        System.out.println("\n" + match.getTeam2().getTeamName() + " Bowling!");

        System.out.println("Player no.\t\tPlayer name\t\tRuns Conceded\t\t Overs Bowled\t\tWickets\t\tEconomy\n");
        for (int i = 0; i < match.getTeam1().getNoOfBowlers(); i++) {
            Player player = match.getTeam2().getBowler(i);
            Integer[] playerStats = match.getPlayerStats("bowl", "t2", player.getPlayerNo());
            String no = String.format("%1$" + 10 + "s", player.getPlayerNo());
            String name = String.format("%1$" + 10 + "s", player.getPlayerName());
            String run = String.format("%1$" + 10 + "s", playerStats[1]);
            String overs = String.format("%1$" + 10 + "s", playerStats[0]);
            String wickets = String.format("%1$" + 10 + "s", playerStats[2]);
            float economy;
            try {
                economy = (float) playerStats[1] / playerStats[0];
            } catch (Exception e) {
                economy = 0;
            }
            String eco = String.format("%1$" + 10 + "s", String.format("%.2f", economy));
            System.out.println(no + "\t\t" + name + "\t\t" + run + "\t\t" + overs + "\t\t" + wickets + "\t\t" + eco);
        }
        System.out.println("Innings 2 ScoreBoard : \n\n" + match.getTeam2().getTeamName() + " Batting!");

        System.out.println("Player no.\t\tPlayer name\t\tRuns Scored\t\t Balls Faced\t\tSixes/Fours\t\tStrike Rate\n");
        for (int i = 0; i < match.getTeam1().getNoOfPlayers(); i++) {
            Player player = match.getTeam2().getPlayer(i);
            Integer[] playerStats = match.getPlayerStats("bat", "t2", player.getPlayerNo());
            String no = String.format("%1$" + 10 + "s", player.getPlayerNo());
            String name = String.format("%1$" + 10 + "s", player.getPlayerName());
            String run = String.format("%1$" + 10 + "s", playerStats[0]);
            String balls = String.format("%1$" + 10 + "s", playerStats[3]);
            String sf = String.format("%1$" + 10 + "s", (playerStats[1] + " / " + playerStats[2]));
            float sr;
            try {
                sr = (float) playerStats[0] / playerStats[3];
            } catch (Exception e) {
                sr = 0;
            }
            String sra = String.format("%1$" + 10 + "s", String.format("%.2f", sr * 100));
            System.out.println(no + "\t\t" + name + (playerStats[4] == -1 ? "*" : "") + "\t\t" + run + "\t\t" + balls + "\t\t" + sf + "\t\t" + sra + "\t\t" + (playerStats[4] != -1 ? (playerStats[4] == 0 ? "Did not Bat" : "Bowled out by " + match.getTeam1().getPlayer(playerStats[4] - 1).getPlayerName()) : "Not Out"));
        }
        System.out.println("\n" + match.getTeam1().getTeamName() + " Bowling!");

        System.out.println("Player no.\t\tPlayer name\t\tRuns Conceded\t\t Overs Bowled\t\tWickets\t\tEconomy\n");
        for (int i = 0; i < match.getTeam1().getNoOfBowlers(); i++) {
            Player player = match.getTeam1().getBowler(i);
            Integer[] playerStats = match.getPlayerStats("bowl", "t1", player.getPlayerNo());
            String no = String.format("%1$" + 10 + "s", player.getPlayerNo());
            String name = String.format("%1$" + 10 + "s", player.getPlayerName());
            String run = String.format("%1$" + 10 + "s", playerStats[1]);
            String overs = String.format("%1$" + 10 + "s", playerStats[0]);
            String wickets = String.format("%1$" + 10 + "s", playerStats[2]);
            float economy;
            try {
                economy = (float) playerStats[1] / playerStats[0];
            } catch (Exception e) {
                economy = 0;
            }
            String eco = String.format("%1$" + 10 + "s", String.format("%.2f", economy));
            System.out.println(no + "\t\t" + name + "\t\t" + run + "\t\t" + overs + "\t\t" + wickets + "\t\t" + eco);
        }
        System.out.println("\n" + match.getTeam1().getTeamName() + " Total : " + (match.getTarget() - 1));
        System.out.println("Target for " + match.getTeam2().getTeamName() + " : " + match.getTarget());
        System.out.println(match.getTeam2().getTeamName() + " Total : " + match.getTeam2Score());
        if (match.getWinner() == 2) {
            System.out.println(match.getTeam2().getTeamName() + " won by " + (match.getTeam1().getNoOfPlayers() - match.getTeam2Wickets() - 1) + " Wickets!\n\n");

        } else if (match.getWinner() == 0) {
            System.out.println("Match Drawn!");
        } else {
            System.out.println(match.getTeam1().getTeamName() + " won by " + (match.getTarget() - 1 - match.getTeam2Score()) + " runs!!\n\n");
        }
    }

    public String[] displayTeamStats(Map<String, Team> teams, ArrayList<String> teamList) {
        System.out.println("Current Standings are : \n\n");
        Map<Integer, String> nRRMap = new HashMap<>();
        float[][] nRR = new float[teamList.size()][3];
        for (int i = 0; i < teamList.size(); i++) {
            Team t = teams.get(teamList.get(i));
            ts.calculateTeamStuff(t);
            nRRMap.put(i, t.getTeamName());
            nRR[i][0] = t.getNetRunRate();
            nRR[i][1] = t.getPoints();
            nRR[i][2] = i;
        }
        Arrays.sort(nRR, new Comparator<float[]>() {
            @Override
            public int compare(float[] o1, float[] o2) {
                if (o1[1] > o2[1]) return -1;
                else if (o1[1] < o2[1]) return 1;
                else if (o1[1] == o2[1] && o1[0] > o2[0]) return -1;
                else if (o1[1] == o2[1] && o1[0] < o2[0]) return 1;
                else return 0;
            }
        });
        System.out.println("\tTeam name\t\tGames Played\t\tGames won\t\tGames lost\t\tGames drawn\t\tSixes/Fours\t\tWickets Taken\t\tPoints\t\t Net Run Rate  \n");
        for (float[] floats : nRR) {
            Team t = teams.get(nRRMap.get((int) floats[2]));
            String name = String.format("%1$" + 11 + "s", t.getTeamName());
            String gp = String.format("%1$" + 11 + "s", t.getMatchesPlayed());
            String gw = String.format("%1$" + 12 + "s", t.getMatchesWon());
            String gl = String.format("%1$" + 11 + "s", t.getMatchesLost());
            String gd = String.format("%1$" + 11 + "s", t.getMatchesDrawn());
            String sf = String.format("%1$" + 12 + "s", t.getSixes() + "/" + t.getFours());
            String wickets = String.format("%1$" + 10 + "s", t.getWicketsTaken());
            String points = String.format("%1$" + 8 + "s", t.getPoints());
            String nr = String.format("%1$" + 11 + "s", String.format("%.2f", floats[0]));
            System.out.println(name + "\t\t" + gp + "\t\t" + gw + "\t\t" + gl + "\t\t" + gd + "\t\t" + sf + "\t\t" + wickets + "\t\t" + points + "\t\t" + nr);

        }
        return new String[]{nRRMap.get((int) nRR[0][2]), nRRMap.get((int) nRR[1][2])};
    }

    public void finalePreGameLobby(Team t1, Team t2, String date) {
        System.out.println("\n\n\n***** Welcome to finale of the Annual Cricket PG cup *****");
        System.out.println("Teams have toiled and worked for weeks and months and now we have arrived to the conclusion of this epic saga!!");
        System.out.println("The finale is to be held between " + t1.getTeamName() + " and " + t2.getTeamName() + " on " + date);
        System.out.println("Let's have a look at the batting and bowling line-ups of both the teams.");
        System.out.println(t1.getTeamName() + " Batting Line up:\n\n");
        System.out.println("Player no.\t\tPlayer name\t\tRuns Scored\t\t Balls Faced\t\tSixes/Fours\t\tStrike Rate\t\t Centuries/Half-Centuries\n");
        for (int i = 0; i < t1.getNoOfPlayers(); i++) {
            Player player = t1.getPlayer(i);
            String no = String.format("%1$" + 10 + "s", player.getPlayerNo());
            String name = String.format("%1$" + 10 + "s", player.getPlayerName());
            String run = String.format("%1$" + 10 + "s", player.getRunsScored());
            String balls = String.format("%1$" + 10 + "s", player.getBallsPlayed());
            String sf = String.format("%1$" + 10 + "s", (player.getSixes() + " / " + player.getFours()));
            String chc = String.format("%1$" + 10 + "s", player.getCenturies() + "/" + player.getHalfCenturies());
            float sr;
            try {
                sr = (float) player.getRunsScored() / player.getBallsPlayed();
            } catch (Exception e) {
                sr = 0;
            }
            String sra = String.format("%1$" + 10 + "s", String.format("%.2f", sr * 100));
            System.out.println(no + "\t\t" + name + "\t\t" + run + "\t\t" + balls + "\t\t" + sf + "\t\t" + sra + "\t\t" + chc);
        }

        System.out.println("\n\n" + t1.getTeamName() + " Bowling Line Up:\n\n");

        System.out.println("Player no.\t\tPlayer name\t\tRuns Conceded\t\t Overs Bowled\t\tWickets\t\tEconomy\n");
        for (int i = 0; i < t1.getNoOfBowlers(); i++) {
            Player player = t1.getBowler(i);
            String no = String.format("%1$" + 10 + "s", player.getPlayerNo());
            String name = String.format("%1$" + 10 + "s", player.getPlayerName());
            String run = String.format("%1$" + 10 + "s", player.getRunsConceded());
            String overs = String.format("%1$" + 10 + "s", player.getOversBowled());
            String wickets = String.format("%1$" + 10 + "s", player.getWicketsTaken());
            float economy;
            try {
                economy = (float) player.getRunsConceded() / player.getOversBowled();
            } catch (Exception e) {
                economy = 0;
            }
            String eco = String.format("%1$" + 10 + "s", String.format("%.2f", economy));
            System.out.println(no + "\t\t" + name + "\t\t" + run + "\t\t" + overs + "\t\t" + wickets + "\t\t" + eco);
        }
        System.out.println(t2.getTeamName() + " Batting Line up:\n\n");
        System.out.println("Player no.\t\tPlayer name\t\tRuns Scored\t\t Balls Faced\t\tSixes/Fours\t\tStrike Rate\t\t Centuries/Half-Centuries\n");
        for (int i = 0; i < t2.getNoOfPlayers(); i++) {
            Player player = t2.getPlayer(i);
            String no = String.format("%1$" + 10 + "s", player.getPlayerNo());
            String name = String.format("%1$" + 10 + "s", player.getPlayerName());
            String run = String.format("%1$" + 10 + "s", player.getRunsScored());
            String balls = String.format("%1$" + 10 + "s", player.getBallsPlayed());
            String sf = String.format("%1$" + 10 + "s", (player.getSixes() + " / " + player.getFours()));
            String chc = String.format("%1$" + 10 + "s", player.getCenturies() + "/" + player.getHalfCenturies());
            float sr;
            try {
                sr = (float) player.getRunsScored() / player.getBallsPlayed();
            } catch (Exception e) {
                sr = 0;
            }
            String sra = String.format("%1$" + 10 + "s", String.format("%.2f", sr * 100));
            System.out.println(no + "\t\t" + name + "\t\t" + run + "\t\t" + balls + "\t\t" + sf + "\t\t" + sra + "\t\t" + chc);
        }

        System.out.println("\n\n" + t2.getTeamName() + " Bowling Line Up:\n\n");

        System.out.println("Player no.\t\tPlayer name\t\tRuns Conceded\t\t Overs Bowled\t\tWickets\t\tEconomy\n");
        for (int i = 0; i < t1.getNoOfBowlers(); i++) {
            Player player = t2.getBowler(i);
            String no = String.format("%1$" + 10 + "s", player.getPlayerNo());
            String name = String.format("%1$" + 10 + "s", player.getPlayerName());
            String run = String.format("%1$" + 10 + "s", player.getRunsConceded());
            String overs = String.format("%1$" + 10 + "s", player.getOversBowled());
            String wickets = String.format("%1$" + 10 + "s", player.getWicketsTaken());
            float economy;
            try {
                economy = (float) player.getRunsConceded() / player.getOversBowled();
            } catch (Exception exception) {
                economy = 0;
            }
            String eco = String.format("%1$" + 10 + "s", String.format("%.2f", economy));
            System.out.println(no + "\t\t" + name + "\t\t" + run + "\t\t" + overs + "\t\t" + wickets + "\t\t" + eco);
        }
        System.out.println("The Finale begins!!\n\n");

    }

    public void signingOff() {
        System.out.println("\n\nWith that our tournament comes to an end! In a battle that lasted for 2 months,\n there was but one team that did not waver for even a second");
        System.out.println("I would like to thank our sponsors Tekion and chatGPT. \nIt has been a pleasure.\nJatin Kashyap Signing off ");
    }
}

