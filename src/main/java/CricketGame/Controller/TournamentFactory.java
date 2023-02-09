package CricketGame.Controller;

import CricketGame.Controller.T20;
import CricketGame.Controller.Tournament;

public class TournamentFactory {
    public Tournament createTournament(String type , int noOfMatches,int noOfTeams){
        if(type.equals("T20")){
            return new T20(noOfMatches,noOfTeams);
        }
        else{
            return null;
        }
    }
}
