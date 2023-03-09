package CricketGame.Service;

import CricketGame.Model.Match;
import CricketGame.Model.Team;
import CricketGame.Repository.MatchRepository;
import CricketGame.Repository.PlayerRepositry;
import CricketGame.Repository.TeamRepository;
import jakarta.xml.bind.ValidationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.relational.core.sql.In;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class MatchServiceTest {
    @Mock
    MatchRepository matchRepository;

    @Mock
    PlayerService playerService;

    @InjectMocks
    MatchService matchService;


    private Team firstTeam,secondTeam;

    @BeforeEach
    public void beforeMethod(){
        firstTeam = new Team();
        firstTeam.setTeamAttributes("FirstTeam", 11, 1l);
        secondTeam = new Team();
        secondTeam.setTeamAttributes("SecondTeam", 11, 2l);

    }

    @Test
    void ballResultTest() throws ValidationException {
        Assert.assertEquals(2, matchService.ballResult(2,0));
    }
}