package CricketGame.Entity.ESEntity;

import CricketGame.Service.MatchService;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Data
@Document(indexName = "match_data")
@NoArgsConstructor
public class MatchESEntity {
    @Id
    @Field(type = FieldType.Long)
    private Long id;

    @Field(type = FieldType.Long)
    private Long team1Id;

    @Field(type = FieldType.Long)
    private Long team2Id;

    @Field(type = FieldType.Text)
    private String team1Name;

    @Field(type = FieldType.Text)
    private String team2Name;

    @Field(type = FieldType.Text)
    private String battingFirst;

    @Field(type = FieldType.Long)
    private Long innings1Total;

    @Field(type = FieldType.Long)
    private Long innings2Total;

    @Field(type = FieldType.Text)
    private String winner;

    public MatchESEntity(long matchId, long team1Id, long team2Id, String team1Name, String team2Name, String battingFirst, long innings1Total, long innings2Total, String winner){
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
