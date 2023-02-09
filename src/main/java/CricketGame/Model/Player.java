package CricketGame.Model;

import CricketGame.Controller.Match;

public class Player {
    private int[] probFunc = {0,0,0,0,1,1,1,1,2,2,2,3,4,4,5,6,6,-1,-1};
    private String playerName;
    private int playerNo;

    Player(int playerNo,String team){
        playerName = team + playerNo;
        this.playerNo = playerNo;
    }
    public int getRuns(){
        return probFunc[(int)(Math.random()*probFunc.length)];
    }
}
