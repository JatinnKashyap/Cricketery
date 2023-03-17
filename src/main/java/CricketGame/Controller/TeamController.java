package CricketGame.Controller;

import CricketGame.Entity.SQLEntity.TeamEntity;
import CricketGame.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping("/{id}")
    public TeamEntity get(@PathVariable Long id){
        return teamService.getTeam(id);
    }
}
