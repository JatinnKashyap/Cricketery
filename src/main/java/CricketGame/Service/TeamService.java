package CricketGame.Service;


import CricketGame.Entity.PlayerEntity;
import CricketGame.Model.Player;
import CricketGame.Model.Team;
import CricketGame.Repository.PlayerRepositry;
import CricketGame.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private PlayerRepositry playerRepositry;

    @Autowired
    private TeamRepository teamRepository;
    public int getPoints(Team team){
        return team.getMatchesDrawn() + team.getMatchesWon() * 2;
    }



    public float calculateNetRunRate(Team team){

        float netRunRate = (float)team.getRunsScored()/team.getOversPlayed() - (float)team.getRunsConceded()/team.getOversBowled();
        team.setNetRunRate(netRunRate);
        return netRunRate;
    }

    public void addPlayers(Team team){
        for(int i = 0; i < team.getNoOfPlayers();i++){
            Player player = new Player();
            player.setPlayerAttrib(i+1,team.getTeamName());
            team.getPlayers().add(player); playerRepositry.save(new PlayerEntity(player.getPlayerName(),player.getPlayerNo(),team.getTeamName(),player.getRunsScored()));
        }
        for(int i = team.getNoOfPlayers()-1 ; i >= team.getNoOfPlayers()-1-team.getNoOfBowlers(); i--){
            team.getBowlers().add(team.getPlayers().get(i));
        }

    }



}
