package CricketGame.Service;

import CricketGame.Entity.MatchEntity;
import CricketGame.Entity.PlayerEntity;
import CricketGame.Model.Match;
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

    public void autoSave(Match match){
        ArrayList<Integer[]> team1Batting = match.getTeam1Batting();
        for(int j = 0; j < team1Batting.size(); j++){
            PlayerEntity pe = playerRepositry.findById(match.getTeam1().getPlayer(j).getPlayerId()).orElse(null);
            pe.setRunsScored(pe.getRunsScored() + team1Batting.get(j)[0]);
            pe.setSixes(pe.getSixes() + team1Batting.get(j)[1]);
            pe.setFours(pe.getFours() + team1Batting.get(j)[2]);
            pe.setBallsPlayed(pe.getBallsPlayed() + team1Batting.get(j)[3]);
            if(team1Batting.get(j)[0] >= 100)pe.setCenturies(pe.getCenturies()+1);
            else if(team1Batting.get(j)[0] >= 50)pe.setHalfCenturies(pe.getHalfCenturies()+1);
            playerRepositry.save(pe);
        }
        ArrayList<Integer[]> team2Batting = match.getTeam2Batting();
        for(int j = 0; j < team2Batting.size(); j++){
            PlayerEntity pe = playerRepositry.findById(match.getTeam2().getPlayer(j).getPlayerId()).orElse(null);
            pe.setRunsScored(pe.getRunsScored() + team2Batting.get(j)[0]);
            pe.setSixes(pe.getSixes() + team2Batting.get(j)[1]);
            pe.setFours(pe.getFours() + team2Batting.get(j)[2]);
            pe.setBallsPlayed(pe.getBallsPlayed() + team2Batting.get(j)[3]);
            if(team2Batting.get(j)[0] >= 100)pe.setCenturies(pe.getCenturies()+1);
            else if(team2Batting.get(j)[0] >= 50)pe.setHalfCenturies(pe.getHalfCenturies()+1);
            playerRepositry.save(pe);
        }
        ArrayList<Integer[]> team1Bowling = match.getTeam1Bowling();
        for(int j = 0; j < team1Bowling.size(); j++){
            PlayerEntity pe = playerRepositry.findById(match.getTeam1().getBowler(j).getPlayerId()).orElse(null);
            pe.setRunsConceded(pe.getRunsConceded() + team1Bowling.get(j)[1]);
            pe.setOversBowled(pe.getOversBowled() + team1Bowling.get(j)[0]);
            pe.setWicketsTaken(pe.getWicketsTaken() + team1Bowling.get(j)[2]);
            playerRepositry.save(pe);
        }
        ArrayList<Integer[]> team2Bowling = match.getTeam2Bowling();
        for(int j = 0; j < team2Bowling.size(); j++){
            PlayerEntity pe = playerRepositry.findById(match.getTeam2().getBowler(j).getPlayerId()).orElse(null);
            pe.setRunsConceded(pe.getRunsConceded() + team2Bowling.get(j)[1]);
            pe.setOversBowled(pe.getOversBowled() + team2Bowling.get(j)[0]);
            pe.setWicketsTaken(pe.getWicketsTaken() + team2Bowling.get(j)[2]);
            playerRepositry.save(pe);
        }
    }

    public void reset(){
        playerRepositry.deleteAll();
    }

}


