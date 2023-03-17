package CricketGame.Entity.ESEntity;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "team_data")
@NoArgsConstructor
public class TeamESEntity {
    @Id
    @Field(type = FieldType.Long)
    private Long id;

    private String teamName;

    @Field(type = FieldType.Long)
    private Long noOfPlayers;

    @Field(type = FieldType.Long)
    private Long matchesWon = 0l;

    @Field(type = FieldType.Long)
    private Long matchesPlayed = 0l;

    @Field(type = FieldType.Long)
    private Long matchesDrawn = 0l;

    @Field(type = FieldType.Long)
    private Long matchesLost = 0l;

    @Field(type = FieldType.Long)
    private Long runsScored = 0l;

    @Field(type = FieldType.Long)
    private Long oversPlayed = 0l;

    @Field(type = FieldType.Long)
    private Long oversBowled = 0l;

    @Field(type = FieldType.Long)
    private Long runsConceded = 0l;

    @Field(type = FieldType.Long)
    private Long points = 0l;

    @Field(type = FieldType.Long)
    private Long sixes = 0l;

    @Field(type = FieldType.Long)
    private Long wicketsTaken = 0l;

    @Field(type = FieldType.Long)
    private Long fours = 0l;

    @Field(type = FieldType.Float)
    private Float netRunRate = 0f;

    public TeamESEntity(long teamId, String name, long noOfPlayers){
        this.teamName = name;
        this.noOfPlayers = noOfPlayers;
        this.id = teamId;
    }
}
