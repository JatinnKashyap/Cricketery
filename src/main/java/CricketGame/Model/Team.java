package CricketGame.Model;

import CricketGame.View.DataBase;

import java.util.ArrayList;

public class Team {
    private ArrayList<Player> players;

    public String getTeamName() {
        return teamName;
    }

    private String teamName;
    public Team(String name){
        this.teamName = name;
        players = new ArrayList<Player>();
        for(int i = 0; i < 11;i++){
            players.add(new Player(i+1,teamName));
        }
    }
}
