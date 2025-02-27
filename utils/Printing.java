package utils;

import wrestlers.Wrestler;

public class Printing {
    public static void displayWinner(String name) {
        System.out.println("\n--------------------------------");
        System.out.println(name + " is your winner!!");
        System.out.println("--------------------------------\n");
    }

    public static Wrestler determineWinner(Wrestler w1, Wrestler w2) {
        return (w1.getHealth() <= 0) ? w2 : w1;
    }

    public static void tournamentWinner(String name) {
        System.out.println("\n--------------------------------");
        System.out.println(name + " is the TOURNAMENT CHAMPION! ");
        System.out.println("--------------------------------\n");
    }

    public static void finalShowdown(String name1, String name2) {
        System.out.println("\n FINAL SHOWDOWN: " + name1 + " vs " + name2 + "\n");
    }
}
