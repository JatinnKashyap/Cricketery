package CricketGame.Controller;

import CricketGame.Entity.MatchEntity;
import CricketGame.Entity.PlayerEntity;
import CricketGame.Service.MatchService;
import CricketGame.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    MatchService matchService;

    @GetMapping("/{id}")
    public MatchEntity get(@PathVariable Long id){
        return matchService.getMatch(id);
    }
}
