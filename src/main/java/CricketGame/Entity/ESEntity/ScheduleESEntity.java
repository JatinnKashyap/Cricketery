package CricketGame.Entity.ESEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Data
@Document(indexName = "schedule_data")
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleESEntity {
    @Id
    @Field(type = FieldType.Long)
    private Long id;


    @Field(type = FieldType.Long)
    private Long matchNo;


    @Field(type = FieldType.Text)
    private String team1;

    @Field(type = FieldType.Text)
    private String team2;

    @Field(type = FieldType.Text)
    private String date;

    public ScheduleESEntity(long id,long matchNo, String team1, String team2, String date){
        this.id = id;
        this.matchNo = matchNo;
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;

    }
}
