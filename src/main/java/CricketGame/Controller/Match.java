package CricketGame.Controller;

import CricketGame.Model.Team;
import CricketGame.View.Result;
public class Match {
    public Match(){


    }
    public Result runMatch(Team t1, Team t2){
        System.out.println("Running Match between " +t1.getTeamName() + " and " + t2.getTeamName());
        return null;
    }
}
