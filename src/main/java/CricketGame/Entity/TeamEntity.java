package CricketGame.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Team")
@NoArgsConstructor
public class TeamEntity {
    @Id
    private Long id;

    private String teamName;
    private Long noOfPlayers;
    private Long matchesWon = 0l;
    private Long matchesPlayed = 0l;
    private Long matchesDrawn = 0l;
    private Long matchesLost = 0l;
    private Long runsScored = 0l;
    private Long oversPlayed = 0l;
    private Long oversBowled = 0l;
    private Long runsConceded = 0l;
    private Long points = 0l;
    private Long sixes = 0l;
    private Long wicketsTaken = 0l;
    private Long fours = 0l;
    private Float netRunRate = 0f;

    public TeamEntity(long teamId, String name, long noOfPlayers){
        this.teamName = name;
        this.noOfPlayers = noOfPlayers;
        this.id = teamId;
    }
}
