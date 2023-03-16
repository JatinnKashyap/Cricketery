package CricketGame.Service;

import CricketGame.Model.Match;
import CricketGame.Model.Player;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class PlayerServiceTest {

    @Mock
    PlayerService playerService;

    private Player player;
    private Match match;

    @BeforeEach
    void beforeMethod(){
        player = new Player();
        player.setPlayerAttrib(1,"testTeam");

    }

    @Test
    void bat() {
        Assert.assertTrue(Arrays.asList(1,2,4,6,0).contains(playerService.bat(player)));
    }

    @Test
    void bowl() {
        Assert.assertTrue(Arrays.asList(-1,6,0).contains(playerService.bowl(player)));
    }

}