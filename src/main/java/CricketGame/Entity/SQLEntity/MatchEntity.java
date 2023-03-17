package CricketGame.Entity.SQLEntity;

import CricketGame.Service.MatchService;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Matches", indexes = {@Index(name = "idx_winner_team", columnList = "winner")})
@Data
@NoArgsConstructor
public class MatchEntity {
    @Id
    private Long id;

    private Long team1Id;
    private Long team2Id;
    private String team1Name;
    private String team2Name;
    private String battingFirst;
    private Long innings1Total;
    private Long innings2Total;
    private String winner;

    public MatchEntity(long matchId, long team1Id, long team2Id, String team1Name, String team2Name, String battingFirst, long innings1Total, long innings2Total, String winner){
        this.id = matchId;
        this.team1Id = team1Id;
        this.team2Id = team2Id;
        this.team1Name = team1Name;
        this.team2Name = team2Name;
        this.battingFirst = battingFirst;
        this.innings1Total = innings1Total;
        this.innings2Total = innings2Total;
        this.winner = winner;
    }

}
