package CricketGame.Service;


import CricketGame.Entity.ESEntity.PlayerESEntity;
import CricketGame.Entity.ESEntity.TeamESEntity;
import CricketGame.Entity.SQLEntity.PlayerEntity;
import CricketGame.Entity.SQLEntity.TeamEntity;
import CricketGame.Model.Match;
import CricketGame.Model.Player;
import CricketGame.Model.Team;
import CricketGame.Repository.ESRepository.ESPlayerRepository;
import CricketGame.Repository.ESRepository.ESTeamRepository;
import CricketGame.Repository.SQLRepository.PlayerRepository;
import CricketGame.Repository.SQLRepository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private ESTeamRepository esTeamRepository;

    @Autowired
    private ESPlayerRepository esPlayerRepository;


    public void calculateTeamStuff(Team team){
        float netRunRate = (float)team.getRunsScored()/team.getOversPlayed() - (float)team.getRunsConceded()/team.getOversBowled();
        team.setNetRunRate(netRunRate);
        int point =  team.getMatchesDrawn() + team.getMatchesWon() * 2;
        team.setPoints(point);
    }

    public void addPlayers(Team team){
        for(int i = 0; i < team.getNoOfPlayers();i++){
            Player player = new Player();
            player.setPlayerAttrib(i+1, team.getTeamName());
            PlayerEntity pe = new PlayerEntity(1+ 11L *i+i, player.getPlayerName(),player.getPlayerNo(),team.getTeamName(),team.getTeamId());
            PlayerESEntity pes = new PlayerESEntity(1+11L*i+i, player.getPlayerName(),player.getPlayerNo(),team.getTeamName(),team.getTeamId());
            playerRepository.save(pe);
            esPlayerRepository.save(pes);
            player.setPlayerId(pe.getId());
            player.setTeamId(team.getTeamId());
            team.getPlayers().add(player);

        }
        for(int i = team.getNoOfPlayers()-1 ; i >= team.getNoOfPlayers()-1-team.getNoOfBowlers(); i--){
            team.getBowlers().add(team.getPlayers().get(i));
        }

    }

    public void autoSave(Match match){
        this.autoSaveSQL(match);
        this.autoSaveES(match);
    }

    private void autoSaveSQL(Match match){

        TeamEntity team1 = teamRepository.findById(match.getTeam1().getTeamId()).orElse(null);
        TeamEntity team2 = teamRepository.findById(match.getTeam2().getTeamId()).orElse(null);
        assert team1 != null;
        team1.setMatchesPlayed(team1.getMatchesPlayed() + 1 );
        assert team2 != null;
        team2.setMatchesPlayed(team2.getMatchesPlayed() + 1 );
        team1.setRunsScored(team1.getRunsScored() + match.getTeam1Score());
        team2.setRunsScored(team2.getRunsScored() + match.getTeam2Score());
        team1.setRunsConceded(team1.getRunsConceded() + match.getTeam2Score());
        team2.setRunsConceded(team2.getRunsConceded() + match.getTeam1Score());
        int fours = 0, sixes = 0 ,overs = 0, wickets = 0;
        for(int i = 0 ; i < match.getTeam1Batting().size() ; i++){
            sixes += match.getTeam1Batting().get(i)[1];
            fours += match.getTeam1Batting().get(i)[2];
        }
        team1.setFours(team1.getFours() + fours);
        team1.setSixes(team1.getSixes() + sixes);
        sixes = fours = 0;
        for(int i = 0 ; i < match.getTeam2Batting().size() ; i++){
            sixes += match.getTeam2Batting().get(i)[1];
            fours += match.getTeam2Batting().get(i)[2];
        }
        team2.setFours(team2.getFours() + fours);
        team2.setSixes(team2.getSixes() + sixes);
        for(int i = 0 ; i < match.getTeam1Bowling().size(); i++){
            overs += match.getTeam1Bowling().get(i)[0];
            wickets += match.getTeam1Bowling().get(i)[2];
        }
        team1.setOversBowled(team1.getOversBowled() + overs);
        team2.setOversPlayed(team2.getOversPlayed() + overs);
        team1.setWicketsTaken(team1.getWicketsTaken() + wickets);
        overs = wickets = 0;
        for(int i = 0 ; i < match.getTeam2Bowling().size(); i++){
            overs += match.getTeam2Bowling().get(i)[0];
            wickets += match.getTeam2Bowling().get(i)[2];
        }
        team2.setOversBowled(team2.getOversBowled() + overs);
        team1.setOversPlayed(team1.getOversPlayed() + overs);
        team2.setWicketsTaken(team2.getWicketsTaken() + wickets);
        switch(match.getWinner()){
            case 1 -> {
                team1.setMatchesWon(team1.getMatchesWon()+1);
                team2.setMatchesLost(team2.getMatchesLost()+1);
            }
            case 2 -> {
                team2.setMatchesWon(team2.getMatchesWon()+1);
                team1.setMatchesLost(team1.getMatchesLost()+1);
            }
            case 0 -> {
                team1.setMatchesDrawn(team1.getMatchesDrawn()+1);
                team2.setMatchesDrawn(team2.getMatchesDrawn()+1);
            }
        }
        team1.setNetRunRate((float)team1.getRunsScored()/team1.getOversPlayed() - (float)team1.getRunsConceded()/team1.getOversBowled());
        team1.setPoints(team1.getMatchesDrawn() + team1.getMatchesWon() * 2);
        team2.setNetRunRate((float)team2.getRunsScored()/team2.getOversPlayed() - (float)team2.getRunsConceded()/team2.getOversBowled());
        team2.setPoints(team2.getMatchesDrawn() + team2.getMatchesWon() * 2);
        teamRepository.save(team1);
        teamRepository.save(team2);
    }
    private void autoSaveES(Match match){
        TeamESEntity team1 = esTeamRepository.findById(match.getTeam1().getTeamId()).orElse(null);
        TeamESEntity team2 = esTeamRepository.findById(match.getTeam2().getTeamId()).orElse(null);
        assert team1 != null;
        team1.setMatchesPlayed(team1.getMatchesPlayed() + 1 );
        assert team2 != null;
        team2.setMatchesPlayed(team2.getMatchesPlayed() + 1 );
        team1.setRunsScored(team1.getRunsScored() + match.getTeam1Score());
        team2.setRunsScored(team2.getRunsScored() + match.getTeam2Score());
        team1.setRunsConceded(team1.getRunsConceded() + match.getTeam2Score());
        team2.setRunsConceded(team2.getRunsConceded() + match.getTeam1Score());
        int fours = 0, sixes = 0 ,overs = 0, wickets = 0;
        for(int i = 0 ; i < match.getTeam1Batting().size() ; i++){
            sixes += match.getTeam1Batting().get(i)[1];
            fours += match.getTeam1Batting().get(i)[2];
        }
        team1.setFours(team1.getFours() + fours);
        team1.setSixes(team1.getSixes() + sixes);
        sixes = fours = 0;
        for(int i = 0 ; i < match.getTeam2Batting().size() ; i++){
            sixes += match.getTeam2Batting().get(i)[1];
            fours += match.getTeam2Batting().get(i)[2];
        }
        team2.setFours(team2.getFours() + fours);
        team2.setSixes(team2.getSixes() + sixes);
        for(int i = 0 ; i < match.getTeam1Bowling().size(); i++){
            overs += match.getTeam1Bowling().get(i)[0];
            wickets += match.getTeam1Bowling().get(i)[2];
        }
        team1.setOversBowled(team1.getOversBowled() + overs);
        team2.setOversPlayed(team2.getOversPlayed() + overs);
        team1.setWicketsTaken(team1.getWicketsTaken() + wickets);
        overs = wickets = 0;
        for(int i = 0 ; i < match.getTeam2Bowling().size(); i++){
            overs += match.getTeam2Bowling().get(i)[0];
            wickets += match.getTeam2Bowling().get(i)[2];
        }
        team2.setOversBowled(team2.getOversBowled() + overs);
        team1.setOversPlayed(team1.getOversPlayed() + overs);
        team2.setWicketsTaken(team2.getWicketsTaken() + wickets);
        switch(match.getWinner()){
            case 1 -> {
                team1.setMatchesWon(team1.getMatchesWon()+1);
                team2.setMatchesLost(team2.getMatchesLost()+1);
            }
            case 2 -> {
                team2.setMatchesWon(team2.getMatchesWon()+1);
                team1.setMatchesLost(team1.getMatchesLost()+1);
            }
            case 0 -> {
                team1.setMatchesDrawn(team1.getMatchesDrawn()+1);
                team2.setMatchesDrawn(team2.getMatchesDrawn()+1);
            }
        }
        team1.setNetRunRate((float)team1.getRunsScored()/team1.getOversPlayed() - (float)team1.getRunsConceded()/team1.getOversBowled());
        team1.setPoints(team1.getMatchesDrawn() + team1.getMatchesWon() * 2);
        team2.setNetRunRate((float)team2.getRunsScored()/team2.getOversPlayed() - (float)team2.getRunsConceded()/team2.getOversBowled());
        team2.setPoints(team2.getMatchesDrawn() + team2.getMatchesWon() * 2);
        esTeamRepository.save(team1);
        esTeamRepository.save(team2);
    }
    public void reset(){

        teamRepository.deleteAll();
        esTeamRepository.deleteAll();
    }

    public TeamEntity getTeam(Long id){
        return teamRepository.findById(id).orElse(null);
    }

}
