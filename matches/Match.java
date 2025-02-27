package matches;

import utils.*;
import java.util.Random;
import wrestlers.Wrestler;
import tournaments.TournamentTracker;

public class Match {
    Wrestler wrestler1;
    Wrestler wrestler2;
    Wrestler winner;
    Wrestler looser;

    public Match(Wrestler w1, Wrestler w2) {
        this.wrestler1 = w1;
        this.wrestler2 = w2;
    }

    public void startMatch() {
        Random random = new Random();
        TournamentTracker tracker = TournamentTracker.getInstance();

        while (!wrestler1.isEliminated() && !wrestler2.isEliminated()) {
            Wrestler attacker = (random.nextInt(2) == 0) ? wrestler1 : wrestler2;
            Wrestler defender = (attacker == wrestler1) ? wrestler2 : wrestler1;

            attacker.performMove(defender);

            if (defender.isEliminated()) {
                Timer.waitForSeconds(2);
                Printing.displayWinner(attacker.getName());
                break;
            }
        }

        winner = Printing.determineWinner(wrestler1, wrestler2);
        looser = (winner == wrestler1) ? wrestler2 : wrestler1;

        tracker.addWinner(winner, 2);
        tracker.addWinner(looser, 1);

        System.out.println("Match Over! Winner: " + winner.getName());

        TournamentPrinter.printPointsTable();
    }

    public void startFinalMatch() {
        Random random = new Random();
        TournamentTracker tracker = TournamentTracker.getInstance();

        Wrestler lastAttacker = null;
        int consecutiveAttacks = 0;

        while (!wrestler1.isEliminated() && !wrestler2.isEliminated()) {
            Wrestler attacker;
            Wrestler defender;

            if (consecutiveAttacks == 2) {
                // Apply Power Move after 2 consecutive attacks
                attacker = lastAttacker;
                defender = (attacker == wrestler1) ? wrestler2 : wrestler1;
                System.out.println(attacker.getName() + " performs a POWER MOVE!");
                attacker.SpecialMove(defender);
                ; // Ensure this method exists in Wrestler
                consecutiveAttacks = 0; // Reset counter after Power Move
            } else {
                attacker = (random.nextInt(2) == 0) ? wrestler1 : wrestler2;
                defender = (attacker == wrestler1) ? wrestler2 : wrestler1;
                attacker.performMove(defender);

                // Track consecutive attacks for Power Move
                if (attacker == lastAttacker) {
                    consecutiveAttacks++;
                } else {
                    consecutiveAttacks = 1;
                }
                lastAttacker = attacker;
            }

            if (defender.isEliminated()) {
                Timer.waitForSeconds(2);
                Printing.displayWinner(attacker.getName());
                break;
            }
        }

        winner = Printing.determineWinner(wrestler1, wrestler2);
        looser = (winner == wrestler1) ? wrestler2 : wrestler1;

        tracker.addWinner(winner, 2);
        tracker.addWinner(looser, 1);

        System.out.println("Match Over! Winner: " + winner.getName());

        TournamentPrinter.printPointsTable();
    }
}
