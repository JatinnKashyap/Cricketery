package CricketGame.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Player {
    private String playerName;
    private int playerNo;
    private String teamName;
    private int runsScored;
    private int sixes;
    private int fours;
    private int ballsPlayed;
    private int oversBowled;
    private int runsConceded;
    private int centuries;
    private int wicketsTaken;
    private int halfCenturies;
    private int[] bowlingProb = {0, 0, 0, 0, 6, -1, 6, 6, 6, 6};
    private int[] battingProb = {0,0, 1, 1, 2, 2, 4, 4, 6, 6};

    public void setPlayerAttrib(int playerNo, String team) {
        this.setPlayerName(team + playerNo);
        this.setPlayerNo(playerNo);
        this.setTeamName(team);
    }

}
