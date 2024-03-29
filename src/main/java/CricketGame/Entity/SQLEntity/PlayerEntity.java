package CricketGame.Entity.SQLEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Player", indexes = {@Index(name = "idx_player_name", columnList = "playerName")})
@NoArgsConstructor
public class PlayerEntity {

    @Id
    private Long id;

    private String playerName;
    private Integer playerNo;
    private Long teamId;
    private String teamName;
    private int runsScored;
    private int sixes;
    private int fours;
    private int ballsPlayed;
    private int oversBowled;
    private int runsConceded;
    private int centuries;
    private int wicketsTaken;
    private int halfCenturies;

    public PlayerEntity(String playerName, Integer playerNo, Long teamId,String teamName, int runsScored, int sixes, int fours, int ballsPlayed, int oversBowled, int runsConceded, int centuries, int wicketsTaken, int halfCenturies) {
        this.playerName = playerName;
        this.playerNo = playerNo;
        this.teamId = teamId;
        this.teamName = teamName;
        this.runsScored = runsScored;
        this.sixes = sixes;
        this.fours = fours;
        this.ballsPlayed = ballsPlayed;
        this.oversBowled = oversBowled;
        this.runsConceded = runsConceded;
        this.centuries = centuries;
        this.wicketsTaken = wicketsTaken;
        this.halfCenturies = halfCenturies;
    }

    public PlayerEntity(long id,String playerName, Integer playerNo, String teamName, Long teamId) {
        this.id = id;
        this.playerName = playerName;
        this.playerNo = playerNo;
        this.teamName = teamName;
        this.teamId = teamId;
    }
}
