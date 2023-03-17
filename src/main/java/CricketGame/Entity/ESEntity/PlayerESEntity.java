package CricketGame.Entity.ESEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "player_data")
@NoArgsConstructor
public class PlayerESEntity {

    @Id
    @Field(type = FieldType.Long)
    private Long id;

    @Field(type = FieldType.Text)
    private String playerName;

    @Field(type = FieldType.Integer)
    private Integer playerNo;


    @Field(type = FieldType.Long)
    private Long teamId;


    @Field(type = FieldType.Text)
    private String teamName;

    @Field(type = FieldType.Integer)
    private int runsScored;

    @Field(type = FieldType.Integer)
    private int sixes;

    @Field(type = FieldType.Integer)
    private int fours;

    @Field(type = FieldType.Integer)
    private int ballsPlayed;

    @Field(type = FieldType.Integer)
    private int oversBowled;

    @Field(type = FieldType.Integer)
    private int runsConceded;

    @Field(type = FieldType.Integer)
    private int centuries;

    @Field(type = FieldType.Integer)
    private int wicketsTaken;

    @Field(type = FieldType.Integer)
    private int halfCenturies;

    public PlayerESEntity(String playerName, Integer playerNo, Long teamId,String teamName, int runsScored, int sixes, int fours, int ballsPlayed, int oversBowled, int runsConceded, int centuries, int wicketsTaken, int halfCenturies) {
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

    public PlayerESEntity(long id,String playerName, Integer playerNo, String teamName, Long teamId) {
        this.id = id;
        this.playerName = playerName;
        this.playerNo = playerNo;
        this.teamName = teamName;
        this.teamId = teamId;
    }
}
