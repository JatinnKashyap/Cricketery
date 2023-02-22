package CricketGame.Model;

import CricketGame.Service.MatchService;
import CricketGame.View.Result;
import CricketGame.Service.ScoreBoardService;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

@Data
@Component
public class Tournament {
    private int noOfTeams;
    private int noOfMatches;
    private Map<String, Team> teams;
    private ArrayList<String> teamList;
    private Map<Integer, String[]> schedule;
    private ArrayList<Result> matchResults;
    private int noOfOvers;
    private int noOfPlayers;
    private Calendar cd;
    private MatchService match;
    private ScoreBoardService sb;

    public Tournament() {
        this.teams = new HashMap<String, Team>();
        this.schedule = new HashMap<Integer, String[]>();
        this.teamList = new ArrayList<String>();
        this.noOfOvers = 20;
        this.noOfPlayers = 11;
        this.cd = new GregorianCalendar();
        this.matchResults = new ArrayList<Result>();
        this.sb = new ScoreBoardService();
    }
}
