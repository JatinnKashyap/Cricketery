package CricketGame.Service;

import CricketGame.Model.Player;
import CricketGame.Model.Team;
import CricketGame.View.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MatchService {
    private int noOfOvers;
    private Result res;

    @Autowired
    private PlayerService ps;

    public MatchService() {
        this.noOfOvers = 20;
    }

    public Result runMatch(Team t1, Team t2) {
        if (toss() == 0) {
            Team temp = t1;
            t1 = t2;
            t2 = temp;
        }
        res = new Result(t1, t2, noOfOvers);
        innings1(t1, t2);
        innings2(t1, t2);
        t1.setMatchesPlayed(t1.getMatchesPlayed()+1);
        t2.setMatchesPlayed(t2.getMatchesPlayed()+1);
        if(res.getT2Total() >= res.getTarget()){
            res.winner = 2;
            t2.setMatchesWon(t2.getMatchesWon()+1);
            t1.setMatchesLost(t1.getMatchesLost()+1);
        }
        else if(res.getT2Total() == res.getTarget()-1){
            res.winner = 0;
            t1.setMatchesDrawn(t1.getMatchesDrawn()+1);
            t2.setMatchesDrawn(t2.getMatchesDrawn()+1);
        }else{
            res.winner = 1;

            t1.setMatchesWon(t1.getMatchesWon()+1);
            t2.setMatchesLost(t2.getMatchesLost()+1);
        }

        return res;
    }

    public int toss() {
        return (int) (Math.random() * 2);
    }

    public int ballResult(int bat, int bowl) {
        if (bowl == 0) {
            if (bat == 0 || bat == 1 || bat == 2) return bat;
            else return 0;
        } else if (bowl == -1) {
            if (bat == 4 || bat == 6) return -1;
            else return bat;
        } else return bat;
    }

    public void innings1(Team t1, Team t2) {
        int index = 2;
        int runs = 0, overs = 1;
        Player striker = t1.getPlayer(0);
        Player runner = t1.getPlayer(1);
        res.update("bat",striker,4,-1,"t1");
        res.update("bat",runner,4,-1,"t1");
        Player bowler;
//        System.out.println("Innings 1 begins!!!!\n"+t1.getTeamName()+" won the toss and elected to bat first.");
//        System.out.println("The batting line up will be opened by "+striker.getPlayerName()+" at the striker end and "+runner.getPlayerName()+" at the runners end");
        outer:
        for (int i = 1; i <= noOfOvers; i++,overs++) {
            //bowler attr - 0:overs, 1: runsConceded, 2:wickets
            //batsmen attr - 0:runs, 1:sixes, 2: fours, 3: bowlsFaced, 4: out(bowler no)/no(-1)
            bowler = t2.getBowler(i % t2.getNoOfBowlers());
            ArrayList<Integer> over = new ArrayList<Integer>();
            over.add(bowler.getPlayerNo());
            res.update("bowl",bowler, 0,1,"t2");
            for (int j = 0; j < 6; j++) {
                int ballResult = ballResult(ps.bat(striker), ps.bowl(bowler));
                over.add(ballResult);
                switch (ballResult) {
                    case -1:
                        res.update("bowl", bowler ,2 ,1 ,"t2");
                        res.update("bat", striker , 4 , bowler.getPlayerNo(), "t1");
                        res.update("bat", striker ,3 ,1 ,"t1");
                        if (index == 11) {
//                            res.allOut();
                            index++;
                            res.overUpdate(over,"innings1");
                            break outer;
                        }
                        striker = t1.getPlayer(index++);
                        res.update("bat",striker,4,-1,"t1");
                        break;
                    case 0:
                        res.update("bat", striker,3,1,"t1");
                        break;
                    case 1:
                        res.update("bowl",bowler,1,1,"t2");
                        res.update("bat", striker,0,1,"t1");
                        res.update("bat", striker,3,1,"t1");
                        res.innings1TotalScore(1);
                        Player temp = striker;
                        striker = runner;
                        runner = temp;
                        runs+=ballResult;
                        break;
                    case 2:
                        res.update("bowl",bowler,1,2,"t2");
                        res.update("bat", striker,0,2,"t1");
                        res.update("bat", striker,3,1,"t1");
                        res.innings1TotalScore(2);
                        runs+=ballResult;
                        break;
                    case 4:
                        res.update("bowl",bowler,1,4,"t2");
                        res.update("bat", striker,0,4,"t1");
                        res.update("bat", striker,2,1,"t1");
                        res.update("bat", striker,3,1,"t1");
                        res.innings1TotalScore(4);
                        runs+=ballResult;
                        break;
                    case 6:
                        res.update("bowl",bowler,1,6,"t2");
                        res.update("bat", striker,0,6,"t1");
                        res.update("bat", striker,1,1,"t1");
                        res.update("bat", striker,3,1,"t1");
                        res.innings1TotalScore(6);
                        runs+=ballResult;
                        break;
                }
            }
            Player temp = striker;
            striker = runner;
            runner = temp;
            res.overUpdate(over,"innings1");
        }
        if(index == 12)overs = noOfOvers;
        t1.setRunsScored(t1.getRunsScored()+runs);
        t1.setOversPlayed(t1.getOversPlayed()+overs);
        t2.setRunsConceded(t2.getRunsConceded()+runs);
        t2.setOversBowled(t2.getOversBowled()+overs);
        for(int i = 0 ; i < 10 ; i++)
            if(res.team1Batting.get(i)[0] >= 100)t1.getPlayer(i).setCenturies(t1.getPlayer(i).getCenturies()+1);
            else if(res.team1Batting.get(i)[0] >= 50)t1.getPlayer(i).setHalfCenturies(t1.getPlayer(i).getHalfCenturies()+1);

    }

    public void innings2(Team t1, Team t2) {
        int index = 2;
        int runs = 0, overs = 1;
        Player striker = t2.getPlayer(0);
        Player runner = t2.getPlayer(1);
        res.update("bat",striker,4,-1,"t2");
        res.update("bat",runner,4,0-1,"t2");
        Player bowler;
//        System.out.println("Innings 2 begins!!!!\n"+t1.getTeamName()+" won the toss and elected to bat first.");
//        System.out.println("The batting line up will be opened by "+striker.getPlayerName()+" at the striker end and "+runner.getPlayerName()+" at the runners end");
        outer:
        for (int i = 1; i <= noOfOvers; i++,overs++) {
            //bowler attr - 0:overs, 1: runsConceded, 2:wickets
            //batsmen attr - 0:runs, 1:sixes, 2: fours, 3: bowlsFaced, 4: out(bowler no)/no(-1)
            bowler = t1.getBowler(i % t2.getNoOfBowlers());
            ArrayList<Integer> over = new ArrayList<Integer>();
            over.add(bowler.getPlayerNo());
            res.update("bowl",bowler, 0,1,"t1");
            for (int j = 0; j < 6; j++) {
                int ballResult = ballResult(ps.bat(striker), ps.bowl(bowler));
                over.add(ballResult);
                switch (ballResult) {
                    case -1:
                        res.increaseT2Wicket();
                        res.update("bowl",bowler,2,1,"t1");
                        res.update("bat",striker, 4, bowler.getPlayerNo(), "t2");
                        res.update("bat", striker,3,1,"t2");
                        if (index == 11) {
//                            res.allOut();
                            index++;
                            res.overUpdate(over,"innings2");
                            break outer;
                        }
                        striker = t2.getPlayer(index++);
                        res.update("bat",striker,4,-1,"t2");
                        break;
                    case 0:
                        res.update("bat", striker,3,1,"t2");
                        break;
                    case 1:
                        runs+=ballResult;
                        res.update("bowl",bowler,1,1,"t1");
                        res.update("bat", striker,0,1,"t2");
                        res.update("bat", striker,3,1,"t2");
                        res.innings2TotalScore(1);
                        Player temp = striker;
                        striker = runner;
                        runner = temp;
                        break;
                    case 2:
                        runs+=ballResult;
                        res.update("bowl",bowler,1,2,"t1");
                        res.update("bat", striker,0,2,"t2");
                        res.update("bat", striker,3,1,"t2");
                        res.innings2TotalScore(2);
                        break;
                    case 4:
                        runs+= ballResult;
                        res.update("bowl",bowler,1,4,"t1");
                        res.update("bat", striker,0,4,"t2");
                        res.update("bat", striker,2,1,"t2");
                        res.update("bat", striker,3,1,"t2");
                        res.innings2TotalScore(4);
                        break;
                    case 6:
                        runs+=ballResult;
                        res.update("bowl",bowler,1,6,"t1");
                        res.update("bat", striker,0,6,"t2");
                        res.update("bat", striker,1,1,"t2");
                        res.update("bat", striker,3,1,"t2");
                        res.innings2TotalScore(6);
                        break;
                }
                if(res.getTarget() <= res.getT2Total()){
                    res.overUpdate(over,"innings2");
                    break;
                }
            }
            res.overUpdate(over,"innings2");
        }


        if(index == 12)overs = noOfOvers;
        t2.setRunsScored(t2.getRunsScored()+runs);
        t2.setOversPlayed(t2.getOversPlayed()+overs);
        t1.setRunsConceded(t1.getRunsConceded()+runs);
        t1.setOversBowled(t1.getOversBowled()+overs);

        for(int i = 0 ; i < 10 ; i++)
            if(res.team2Batting.get(i)[0] >= 100)t2.getPlayer(i).setCenturies(t2.getPlayer(i).getCenturies()+1);
            else if(res.team2Batting.get(i)[0] >= 50)t2.getPlayer(i).setHalfCenturies(t2.getPlayer(i).getHalfCenturies()+1);

    }

}
