package CricketGame.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "Schedule")
@Data
@AllArgsConstructor
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long matchNo;
    private String team1;
    private String team2;
    private String date;

    public ScheduleEntity(Long matchNo, String team1, String team2, String date){
        this.matchNo = matchNo;
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;

    }
}
