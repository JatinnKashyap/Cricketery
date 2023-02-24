package CricketGame;
import CricketGame.Model.Tournament;
import CricketGame.Controller.TournamentFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

@SpringBootApplication
public class GameManager {
    public static void main(String args[])throws IOException {
        SpringApplication.run(GameManager.class, args);
//launcher class - google
// user input from api
        // multiple api for user inputs
        //tournamentbegins(Tournament tour) --> don't pass Tournament object .. fetch the schedule and teams from database
    }
}
