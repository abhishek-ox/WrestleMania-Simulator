package tournaments;

import wrestlers.Wrestler;
import utils.TournamentSorter;
import java.util.*;

public class TournamentTracker {
    private static TournamentTracker instance;
    private Map<Wrestler, Integer> pointsTable;

    private TournamentTracker() {
        pointsTable = new HashMap<>();
    }

    // synchronized block should be used 
    public static TournamentTracker getInstance() {
        if (instance == null) {
            instance = new TournamentTracker();
        }
        return instance;
    }

    public void addWinner(Wrestler winner, int points) {
        pointsTable.put(winner, pointsTable.getOrDefault(winner, 0) + points);
    }

    public Map<Wrestler, Integer> getSortedPointsTable() {
        return TournamentSorter.getSortedPointsTable(pointsTable);
    }

    public Map<Wrestler, Integer> getPointsTable() {
        return pointsTable;
    }
}
