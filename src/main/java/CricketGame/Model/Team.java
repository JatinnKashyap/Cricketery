package CricketGame.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Team {
    private ArrayList<Player> players;
    private ArrayList<Player> bowlers;
    private int noOfPlayers;
    private Long teamId;
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




    private String teamName;
    public Team(){
        this.bowlers = new ArrayList<>();
        players = new ArrayList<>();
    }

    public Player getPlayer(int index){

        return players.get(index);
    }

    public Player getBowler(int index){
        return bowlers.get(index);
    }
    public void setTeamAttributes(String name,int noOfPlayers , Long teamId){
        this.setTeamName(name);
        this.teamId = teamId;
        this.setNoOfPlayers(noOfPlayers);
        this.setNoOfBowlers(noOfPlayers/2);
    }
}
