package CricketGame.Service;

import CricketGame.Entity.MatchEntity;
import CricketGame.Entity.ScheduleEntity;
import CricketGame.Entity.TeamEntity;
import CricketGame.Model.Team;
import CricketGame.Model.Tournament;
import CricketGame.Repository.MatchRepository;
import CricketGame.Repository.ScheduleRepository;
import CricketGame.Model.Match;
import CricketGame.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

@Service
public class TournamentService {

    @Autowired
    private MatchService matchService;

    @Autowired
    private ScoreBoardService scoreBoardService;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamService teamService;

    private Calendar calendar = new GregorianCalendar();

    public HashMap<String, Team> createTeams(int noOfTeams, int noOfPlayers,ArrayList<String> teamList) {
        HashMap<String, Team> teams = new HashMap<>();
        for (int i = 0; i < noOfTeams; i++) {
            Team obj = new Team();
            teamRepository.save(new TeamEntity((i+1), teamList.get(i), 11));
            obj.setTeamAttributes(teamList.get(i), noOfPlayers, (i+1));
            teamService.addPlayers(obj);
            teams.put(teamList.get(i), obj);
        }
        return teams;
    }
    public HashMap<Integer,String[]> createSchedule(int noOfTeams, int noOfMatches, ArrayList<String> teamList) {
        Map<Integer,String[]> schedule = new HashMap<Integer,String[]>();
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
            calendar.add(Calendar.DATE, 4);
            sched.get(i)[2] = calendar.getTime() + "";
            schedule.put(i + 1, sched.get(i));
            scheduleRepository.save(new ScheduleEntity((long)(i+1),sched.get(i)[0], sched.get(i)[1], sched.get(i)[2]));
        }

        return (HashMap) schedule;
    }

    public void beginTournament(){
        Tournament tour = new Tournament();
        Scanner sc = new Scanner(System.in);
        System.out.println("*********** Welcome to the annual Cricket Pg Cup "+ calendar.get(Calendar.YEAR) + " ***********");
        System.out.println("Powered by Tekion Corp and sponsored by ChatGPT.");
        System.out.println("The following simulation will simulate a gaming tournament\n\n\n");
        System.out.println("Enter the number of teams");
        int noOfTeams = sc.nextInt();sc.nextLine();
        System.out.println("Please Enter the number of Matches to be Played between Each Team");
        int noOfMatches = sc.nextInt();sc.nextLine();
        tour.setNoOfMatches(noOfMatches);
        tour.setNoOfTeams(noOfTeams);
        System.out.println("Pick any "+noOfTeams+" Teams:");
        ArrayList<String> teams = new ArrayList<String>();
        for(int i = 0;i < noOfTeams;i++){
            teams.add(sc.nextLine());
        }
        initializeTournament(teams , tour);
        displaySchedule(tour);
        tournamentBegins(tour);
    }
    public void initializeTournament(ArrayList<String> team , Tournament tour) {
        tour.setTeamList(team);
        tour.setTeams(createTeams(tour.getNoOfTeams(),tour.getNoOfPlayers(),tour.getTeamList()));
        tour.setSchedule(createSchedule(tour.getNoOfTeams(), tour.getNoOfMatches(), tour.getTeamList()));
    }

    public void displaySchedule(Tournament tour) {
        System.out.println("Match no.\t\tTeam 1\t\tTeam 2\t\t Date\n\n");
        for (int i = 1; i < tour.getSchedule().size() + 1; i++) {
            System.out.println((i) + "   \t\t" + String.format("%1$" + 10 + "s", tour.getSchedule().get(i)[0]) + "\t\t" + String.format("%1$" + 10 + "s", tour.getSchedule().get(i)[1]) + "\t\t" + tour.getSchedule().get(i)[2]);
        }
    }

    public void tournamentBegins(Tournament tour) {
        Match match;
        for (int i = 1; i < tour.getSchedule().size() + 1; i++) {
            String[] sched = tour.getSchedule().get(i);
            System.out.println("\n\nToday's match is to be played between " + sched[0] + " and " + sched[1] + " .\nMatch No. : " + i + " \nDate and Time : " + sched[2]);
            Team team1 = tour.getTeams().get(sched[0]);
            Team team2 = tour.getTeams().get(sched[1]);
            match = matchService.runMatch(team1, team2, i);
            //tomatchResults.add(result);
            scoreBoardService.displayMatchResult(match);
            matchRepository.save(new MatchEntity(match.getMatchId(), match.getTeam1().getTeamId(), match.getTeam2().getTeamId(), match.getTeam1().getTeamName(), match.getTeam2().getTeamName(), match.getTeam1().getTeamName(), match.getTeam1Score(), match.getTeam2Score(), (match.getWinner() == 1? match.getTeam1().getTeamName(): (match.getWinner() == 2? match.getTeam2().getTeamName() : "Draw"))));

        }
        System.out.println("\n\n\n This is the end of the group stage.");
        String[] finale = scoreBoardService.displayTeamStats(tour.getTeams(),tour.getTeamList());
        calendar.add(Calendar.DATE, 4);
        scoreBoardService.finalePreGameLobby(tour.getTeams().get(finale[0]), tour.getTeams().get(finale[1]), calendar.getTime() + "");
        match = matchService.runMatch(tour.getTeams().get(finale[0]), tour.getTeams().get(finale[1]), tour.getSchedule().size());
//        matchResults.add(result);


        scoreBoardService.displayMatchResult(match);
        scoreBoardService.signingOff();

    }

//    public void awards(){
//        /*best batsman - 0 (highest scorer) - a
//           best bowler - 1 (most wickets) - b
//           the highest score in an innings(team) - 2 - c
//           the highest score in an innings(individual) - 3 - d
//           the lowest score by a team - 4 - e
//           most sixes - individual - f
//        */
//    }

}
