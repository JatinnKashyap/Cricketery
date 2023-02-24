package CricketGame.Controller;

import CricketGame.Service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tournament")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @GetMapping("/run")
    public void start(){
        tournamentService.beginTournament();
    }

    // "/reset" --> wipe the database to start a new tournament
}
