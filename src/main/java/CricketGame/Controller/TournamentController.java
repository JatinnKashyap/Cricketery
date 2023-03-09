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
    public void start(@RequestBody InputWrapper input)throws RuntimeException{
        tournamentService.beginTournament(input.noOfTeams, input.noOfMatches, input.teams);
        return "Successfull";
    }

    @PostMapping("/reset")
    public void reset(){
        tournamentService.reset();
    }

    @PostMapping("/schedule")// return data to api call
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

// make new branch and debug 2nd innings score > 6


