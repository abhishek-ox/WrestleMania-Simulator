package matches;

import wrestlers.Wrestler;
// import tournaments.TournamentTracker;
import utils.TournamentPrinter;
import java.util.*;
import java.util.concurrent.*;

public class FinalMatchManager {
    public static void finalShowdown(List<Wrestler> topWrestlers) {

        System.out.println("\nFinal Tournament Standings:");

        Wrestler w1 = topWrestlers.get(0);
        Wrestler w2 = topWrestlers.get(1);
        Wrestler w3 = topWrestlers.get(2);
        Wrestler w4 = topWrestlers.get(3);

        // Reset health for semi-finalists
        w1.resetHealth();
        w2.resetHealth();
        w3.resetHealth();
        w4.resetHealth();

        System.out.println("\nSEMI-FINAL MATCHES ");
        System.out.println(w1.getName() + " vs " + w3.getName());
        System.out.println(w2.getName() + " vs " + w4.getName());

        // move this code to utils (arena class)
        ExecutorService semiFinalPool = Executors.newFixedThreadPool(2);
        Match semi1 = new Match(w1, w3);
        Match semi2 = new Match(w2, w4);

        // what will be intial value of Future
        Future<?> match1 = semiFinalPool.submit(semi1::startMatch);
        Future<?> match2 = semiFinalPool.submit(semi2::startMatch);

        Wrestler thirdPlace = null;
        Wrestler fourthPlace = null;
        
        try {
            // The first match that completes determines the 4th place
            while (!match1.isDone() && !match2.isDone()) {
                Thread.sleep(500); // never use timers
            }

            //polling(E.g : payment status)

            // have to use a interface as a callback().
            // match not over yet
            if (match1.isDone()) {
                fourthPlace = semi1.looser;
                thirdPlace = semi1.winner;
            } else {
                fourthPlace = semi2.looser;
                thirdPlace = semi2.winner;
            }

            semiFinalPool.shutdownNow(); // Stop remaining matches
            semiFinalPool.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n3rd Place: " + thirdPlace.getName());
        System.out.println("\n4th Place: " + fourthPlace.getName());

        // Final Match between top 2
        Wrestler finalist1 = (thirdPlace == w1 || thirdPlace == w3) ? w2 : w1;
        Wrestler finalist2 = (thirdPlace == w1 || thirdPlace == w3) ? w4 : w3;

        finalist1.resetHealth();
        finalist2.resetHealth();

        System.out.println("\nFINAL MATCH: " + finalist1.getName() + " vs " + finalist2.getName());

        Match finalMatch = new Match(finalist1, finalist2);
        finalMatch.startFinalMatch();

        TournamentPrinter.printTournamentWinner(finalMatch.winner.getName());
    }
}
