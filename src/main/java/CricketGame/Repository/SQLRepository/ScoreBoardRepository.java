package CricketGame.Repository.SQLRepository;

import CricketGame.Entity.ScoreBoard;
import org.springframework.data.repository.CrudRepository;

public interface ScoreBoardRepository extends CrudRepository<ScoreBoard,Long> {
}
