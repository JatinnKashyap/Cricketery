package CricketGame.Controller;

import CricketGame.Model.Tournament;

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
