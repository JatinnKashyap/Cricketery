package CricketGame.Entity.SQLEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Schedule")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleEntity {
    @Id
    private Long id;

    private Long matchNo;
    private String team1;
    private String team2;
    private String date;

    public ScheduleEntity(long id,long matchNo, String team1, String team2, String date){
        this.id = id;
        this.matchNo = matchNo;
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;

    }

}
