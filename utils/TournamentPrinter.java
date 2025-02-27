package utils;

import wrestlers.Wrestler;
import tournaments.TournamentTracker;
import java.util.Map;

public class TournamentPrinter {
    public static void printPointsTable() {
        System.out.println("\n Updated Points Table:");
        for (Map.Entry<Wrestler, Integer> entry : TournamentTracker.getInstance().getPointsTable().entrySet()) {
            System.out.println(entry.getKey().getName() + " : " + entry.getValue() + " points");
        }
        System.out.println("--------------------------------");
    }

    // ✅ Add this missing method
    public static void printFinalStandings() {
        TournamentTracker tracker = TournamentTracker.getInstance();
        System.out.println("\nFinal Tournament Standings:");
        tracker.getSortedPointsTable()
                .forEach((wrestler, points) -> System.out.println(wrestler.getName() + " => " + points + " points"));
        System.out.println("--------------------------------");
    }

    public static void printFinalShowdown(Wrestler w1, Wrestler w2) {
        System.out.println("\n FINAL SHOWDOWN: " + w1.getName() + " vs " + w2.getName() + "\n");
    }

    public static void printTournamentWinner(String winnerName) {
        System.out.println("\n--------------------------------");
        System.out.println(winnerName + " is the TOURNAMENT CHAMPION!");
        System.out.println("--------------------------------\n");
    }
}
