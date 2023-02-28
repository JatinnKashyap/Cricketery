package CricketGame.Controller;

import CricketGame.Service.TournamentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tournament")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @PostMapping("/run")
    public void start(@RequestBody InputWrapper aObject)throws RuntimeException{
        tournamentService.beginTournament(aObject.noOfTeams, aObject.noOfMatches, aObject.teams);
    }

    @PostMapping("/reset")
    public void reset(){
        tournamentService.reset();
    }

    @PostMapping("/schedule")
    public void displaySchedule(){
        tournamentService.displaySchedule();
    }

    @PostMapping("/auto")
    public void beginTournament(){
        tournamentService.autoRun();
    }

    @PostMapping("/match/{matchId}")
    public void runMatch(@PathVariable Long matchId){
        tournamentService.runMatch(matchId);
    }

    @PostMapping("/finale")
    public void runFinale(){
        tournamentService.finale();
    }
}

@Data
class InputWrapper{
    int noOfTeams;
    int noOfMatches;
    List<String> teams;
}

