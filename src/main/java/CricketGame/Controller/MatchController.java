package CricketGame.Controller;

import CricketGame.Entity.SQLEntity.MatchEntity;
import CricketGame.Service.MatchService;
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
