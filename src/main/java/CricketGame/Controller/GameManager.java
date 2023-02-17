package CricketGame.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class GameManager {
    public static void main(String args[])throws IOException {
        Calendar dt = new GregorianCalendar();
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("*********** Welcome to the annual Cricket Pg Cup "+ dt.get(dt.YEAR) + " ***********");
        System.out.println("Powered by Tekion Corp and sponsored by ChatGPT.");
        System.out.println("The following simulation will simulate a gaming tournament\n\n\n");
        System.out.println("Enter the number of teams");
        int noOfTeams = sc.nextInt();sc.nextLine();
        System.out.println("Please Enter the number of Matches to be Played between Each Team");
        int noOfMatches = sc.nextInt();sc.nextLine();
        TournamentFactory tf = new TournamentFactory();
        Tournament tour = tf.createTournament("T20", noOfMatches,noOfTeams);
//        tour.displayTeams();
        System.out.println("Pick any "+noOfTeams+" Teams:");
        ArrayList<String> teams = new ArrayList<String>();
        for(int i = 0;i < noOfTeams;i++){
            teams.add(sc.nextLine());
        }
        tour.initializeTournament(teams);
        tour.displaySchedule();
        tour.tournamentBegins();



    }
}
