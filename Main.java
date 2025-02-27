import matches.MatchManager;
import matches.FinalMatchManager;
import wrestlers.Wrestler;
import tournaments.TournamentTracker;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Wrestler[] wrestlers = MatchManager.createWrestlers();
        TournamentTracker tracker = TournamentTracker.getInstance();

        // Create a fixed thread pool with 2 worker threads
        ExecutorService matchPool = Executors.newFixedThreadPool(2);


        //completely random fixing
        for (int i = 0; i < 10; i += 2) {
            int w1 = i % 10;
            int w2 = (i + 1) % 10;
            int w3 = (i + 2) % 10;
            int w4 = (i + 3) % 10;

            matchPool.submit(() -> MatchManager.arena(wrestlers[w1], wrestlers[w2]));
            matchPool.submit(() -> MatchManager.arena(wrestlers[w3], wrestlers[w4]));
        }

        // Shutdown the match pool after submitting all matches
        matchPool.shutdown();
        while (!matchPool.isTerminated()) {
            // Wait for all matches to complete
        }

        // Sort wrestlers after all matches

        // use the utils function directly
        Map<Wrestler, Integer> sortedTable = tracker.getSortedPointsTable();
        List<Wrestler> topWrestlers = new ArrayList<>(sortedTable.keySet());

        // Conduct Semi-Finals & Final
        // FinalMatchManager.finalShowdown();
        FinalMatchManager.finalShowdown(topWrestlers);

    }
}
