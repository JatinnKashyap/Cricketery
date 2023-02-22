package CricketGame.Service;

import CricketGame.Entity.MatchEntity;
import CricketGame.Entity.PlayerEntity;
import CricketGame.Model.Player;
import CricketGame.Repository.MatchRepository;
import CricketGame.Repository.PlayerRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepositry playerRepositry;

    public int bat(Player player) {
        return player.getBattingProb()[(int) (Math.random() * player.getBattingProb().length)];
    }
    public int bowl(Player player){
        return player.getBowlingProb()[(int) (Math.random() * player.getBowlingProb().length)];
    }

}


