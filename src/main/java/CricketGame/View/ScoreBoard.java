package CricketGame.View;

import CricketGame.Model.Player;

public class ScoreBoard {
    public ScoreBoard(){

    }
    public void displayResult(Result result){

//        System.out.println("Displaying result");
        System.out.println(result.t1.getTeamName() +" won the toss and have elected to bat first\n");
        System.out.println("Innings 1 ScoreBoard : \n\n"+result.t1.getTeamName()+" Batting!");

        System.out.println("Player no.\t\tPlayer name\t\tRuns Scored\t\t Balls Faced\t\tSixes/Fours\t\tStrike Rate\n");
        for(int i = 0;i < result.t1.getNoOfPlayers();i++ ){
            Player player = result.t1.getPlayer(i);
            Integer[] playerStats = result.getPlayerStats("bat","t1",player.getPlayerNo());
            String no = String.format("%1$" + 10 + "s", player.getPlayerNo());
            String name = String.format("%1$" + 10 + "s", player.getPlayerName());
            String run = String.format("%1$" + 10 + "s", playerStats[0]);
            String balls = String.format("%1$" + 10 + "s", playerStats[3]);
            String sf = String.format("%1$" + 10 + "s", (playerStats[1]+" / "+playerStats[2]));
            float sr;
            try{
                sr =  (float)playerStats[0]/playerStats[3];
            }catch(Exception e){
                sr = 0;
            }
            String sra = String.format("%1$" + 10 + "s", String.format("%.2f",sr*100));
            System.out.println(no+"\t\t"+name+(playerStats[4] == -1?"*":"")+"\t\t"+run+"\t\t"+balls+"\t\t"+sf+"\t\t"+sra+"\t\t"+(playerStats[4] !=-1 ? (playerStats[4] == 0 ?"Did not Bat":"Bowled out by "+result.t2.getPlayer(playerStats[4]-1).getPlayerName()):"Not Out"));
        }
        System.out.println("\n"+result.t2.getTeamName()+" Bowling!");

        System.out.println("Player no.\t\tPlayer name\t\tRuns Conceded\t\t Overs Bowled\t\tWickets\t\tEconomy\n");
        for(int i = 0;i < result.t1.getNoOfBowlers();i++ ){
            Player player = result.t2.getBowler(i);
            Integer[] playerStats = result.getPlayerStats("bowl","t2",player.getPlayerNo());
            String no = String.format("%1$" + 10 + "s", player.getPlayerNo());
            String name = String.format("%1$" + 10 + "s", player.getPlayerName());
            String run = String.format("%1$" + 10 + "s", playerStats[1]);
            String overs = String.format("%1$" + 10 + "s", playerStats[0]);
            String wickets = String.format("%1$" + 10 + "s", playerStats[2]);
            float economy;
            try{
                economy =  (float)playerStats[1]/playerStats[0];
            }catch(Exception e){
                economy = 0;
            }
            String eco = String.format("%1$" + 10 + "s", String.format("%.2f",economy));
            System.out.println(no+"\t\t"+name+"\t\t"+run+"\t\t"+overs+"\t\t"+wickets+"\t\t"+eco);
        }
        System.out.println("Innings 2 ScoreBoard : \n\n"+result.t2.getTeamName()+" Batting!");

        System.out.println("Player no.\t\tPlayer name\t\tRuns Scored\t\t Balls Faced\t\tSixes/Fours\t\tStrike Rate\n");
        for(int i = 0;i < result.t1.getNoOfPlayers();i++ ){
            Player player = result.t2.getPlayer(i);
            Integer[] playerStats = result.getPlayerStats("bat","t2",player.getPlayerNo());
            String no = String.format("%1$" + 10 + "s", player.getPlayerNo());
            String name = String.format("%1$" + 10 + "s", player.getPlayerName());
            String run = String.format("%1$" + 10 + "s", playerStats[0]);
            String balls = String.format("%1$" + 10 + "s", playerStats[3]);
            String sf = String.format("%1$" + 10 + "s", (playerStats[1]+" / "+playerStats[2]));
            float sr;
            try{
                sr =  (float)playerStats[0]/playerStats[3];
            }catch(Exception e){
                sr = 0;
            }
            String sra = String.format("%1$" + 10 + "s", String.format("%.2f",sr*100));
            System.out.println(no+"\t\t"+name+(playerStats[4] == 0?"*":"")+"\t\t"+run+"\t\t"+balls+"\t\t"+sf+"\t\t"+sra+"\t\t"+(playerStats[4] !=-1 ? (playerStats[4] == 0 ?"Did not Bat":"Bowled out by "+result.t2.getPlayer(playerStats[4]-1).getPlayerName()):"Not Out3"));
        }
        System.out.println("\n"+result.t1.getTeamName()+" Bowling!");

        System.out.println("Player no.\t\tPlayer name\t\tRuns Conceded\t\t Overs Bowled\t\tWickets\t\tEconomy\n");
        for(int i = 0;i < result.t1.getNoOfBowlers();i++ ){
            Player player = result.t1.getBowler(i);
            Integer[] playerStats = result.getPlayerStats("bowl","t1",player.getPlayerNo());
            String no = String.format("%1$" + 10 + "s", player.getPlayerNo());
            String name = String.format("%1$" + 10 + "s", player.getPlayerName());
            String run = String.format("%1$" + 10 + "s", playerStats[1]);
            String overs = String.format("%1$" + 10 + "s", playerStats[0]);
            String wickets = String.format("%1$" + 10 + "s", playerStats[2]);
            float economy;
            try{
                economy =  (float)playerStats[1]/playerStats[0];
            }catch(Exception e){
                economy = 0;
            }
            String eco = String.format("%1$" + 10 + "s", String.format("%.2f",economy));
            System.out.println(no+"\t\t"+name+"\t\t"+run+"\t\t"+overs+"\t\t"+wickets+"\t\t"+eco);
        }
        System.out.println("\n"+result.t1.getTeamName()+" Total : "+(result.getTarget()-1));
        System.out.println("Target for "+result.t2.getTeamName() +" : "+result.getTarget());
        System.out.println(result.t2.getTeamName()+" Total : "+result.getT2Total());
        if(result.getT2Total() >= result.getTarget()){
            System.out.println(result.t2.getTeamName()+" won by "+(result.t1.getNoOfPlayers()-result.getT2Wickets()-1)+" Wickets!\n\n");

        }
        else {
            System.out.println(result.t1.getTeamName()+" won by "+(result.getTarget()-1-result.getT2Total())+" runs!!\n\n");
        }
    }
}
