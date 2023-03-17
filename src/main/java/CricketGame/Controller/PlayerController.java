package CricketGame.Controller;

import CricketGame.Entity.SQLEntity.PlayerEntity;
import CricketGame.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/{id}")
    public PlayerEntity get(@PathVariable Long id){
        return playerService.getPlayer(id);
    }
}
