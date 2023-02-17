package CricketGame.Controller;

import CricketGame.Model.Player;
import CricketGame.Model.Team;
import CricketGame.View.Result;
import CricketGame.View.ScoreBoard;

import java.util.*;

public abstract class Tournament {
    private int noOfTeams;
    private int noOfMatches;
    private Map<String, Team> teams;
    private ArrayList<String> teamList;
    private Map<Integer, String[]> schedule;
    private ArrayList<Result> matchResults;
    private int noOfOvers;
    private int noOfPlayers;
    private Calendar cd;
    private Match match;
    private ScoreBoard sb;

    public Tournament(int noOfOvers, int noOfMatches, int noOfTeams) {
        this.noOfMatches = noOfMatches;
        this.noOfTeams = noOfTeams;
        this.teams = new HashMap<String, Team>();
        this.schedule = new HashMap<Integer, String[]>();
        this.teamList = new ArrayList<String>();
        this.noOfOvers = noOfOvers;
        this.noOfPlayers = 11;
        this.cd = new GregorianCalendar();
        this.matchResults = new ArrayList<Result>();
        this.match = new Match(noOfOvers);
        this.sb = new ScoreBoard();
    }

    //    public void displayTeams(){
//        db.displayTeamsList();
//    }
    public void createSchedule() {
        ArrayList<String[]> sched = new ArrayList<>();
        for (int i = 0; i < noOfMatches; i++) {
            for (int j = 0; j < noOfTeams; j++) {
                for (int k = j + 1; k < noOfTeams; k++) {
                    String[] scd = {teamList.get(j), teamList.get(k), ""};
                    sched.add(scd);
                }
            }
        }
        Collections.shuffle(sched);
        for (int i = 0; i < sched.size(); i++) {
            cd.add(cd.DATE, 4);
            sched.get(i)[2] = cd.getTime() + "";
            schedule.put(i + 1, sched.get(i));

        }
    }

    public void createTeams() {
        for (int i = 0; i < noOfTeams; i++) {
            teams.put(teamList.get(i), new Team(teamList.get(i) , noOfPlayers));
        }

    }

    public void initializeTournament(ArrayList<String> teams) {
        this.teamList = teams;
        createTeams();
        createSchedule();
    }

    public void displaySchedule() {
        System.out.println("Match no.\t\tTeam 1\t\tTeam 2\t\t Date\n\n");
        for (int i = 1; i < schedule.size() + 1; i++) {
            System.out.println((i) + "   \t\t" + String.format("%1$" + 10 + "s", schedule.get(i)[0]) + "\t\t" + String.format("%1$" + 10 + "s", schedule.get(i)[1]) + "\t\t" + schedule.get(i)[2]);
        }
    }

    public void tournamentBegins() {
        Result result;
        for (int i = 1; i < schedule.size() + 1; i++) {
            String sched[] = schedule.get(i);
            System.out.println("\n\nToday's match is to be played between " + sched[0] + " and " + sched[1] + " .\nMatch No. : " + i + " \nDate and Time : " + sched[2]);
            result = match.runMatch(teams.get(sched[0]), teams.get(sched[1]));
            matchResults.add(result);
            sb.displayMatchResult(result);

        }
        System.out.println("\n\n\n This is the end of the group stage.");
        String[] finale = sb.displayTeamStats(teams,teamList);
        cd.add(cd.DATE, 4);
        sb.finalePreGameLobby(teams.get(finale[0]), teams.get(finale[1]), cd.getTime() + "");
        result = match.runMatch(teams.get(finale[0]), teams.get(finale[1]));
        matchResults.add(result);
        sb.displayMatchResult(result);
        sb.signingOff();

    }

    public void awards(){
        /*best batsman - 0 (highest scorer) - a
           best bowler - 1 (most wickets) - b
           highest score in an innings(team) - 2 - c
           highest score in an innings(individual) - 3 - d
           lowest score by a team - 4 - e
           most sixes - individual - f
        */
    }




}
