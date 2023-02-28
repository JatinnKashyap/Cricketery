package CricketGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameManager {
    public static void main(String[] args) {
        SpringApplication.run(GameManager.class, args);
        //launcher class - google
        // user input from api - done
        // multiple api for user inputs - done
        //tournamentBegins(Tournament tour) --> don't pass Tournament object  fetch the schedule and teams from database
    }
}
