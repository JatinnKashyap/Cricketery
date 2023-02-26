package CricketGame.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ScoreBoard")
public class ScoreBoard {
    @Id
    private Long playerId;
    private Long matchId;
    private String playerName;
    private Integer playerNo;
    private Long teamId;
    private Long teamName;
    private Long runsScored;
    private Long sixes;
    private Long fours;
    private Long ballsPlayed;
    private Long oversBowled;
    private Long runsConceded;
    private Long centuries;
    private Long wicketsTaken;
    private Long halfCenturies;
}
