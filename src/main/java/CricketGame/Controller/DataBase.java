package CricketGame.Controller;

import java.util.*;

public class DataBase {


    private List<String> teamList;
    private Map<String, ArrayList<String>> teamPlayers;


    public DataBase(){
        this.teamList = new ArrayList<>(Arrays.asList("India", "Pakistan", "Australia"));
        this.teamPlayers = new HashMap<String, ArrayList<String>>();
    }
    public Map<String, ArrayList<String>> getTeamPlayers() {
        return teamPlayers;
    }
    public void setTeamList(List<String> teamList) {
        this.teamList = teamList;
    }
    public void displayTeamsList(){
        System.out.println("Currently Available Teams are:");
        teamList.forEach((x) -> System.out.println(x));
    }


    public List<String> getTeamList() {
        return teamList;
    }

}
