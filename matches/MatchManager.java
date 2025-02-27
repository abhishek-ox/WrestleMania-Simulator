package matches;

import wrestlers.Wrestler;

public class MatchManager {
    public static Wrestler[] createWrestlers() {
        return new Wrestler[] {
                new Wrestler.WrestlerBuilder().setName("Brock Lesnar").setHealth(200).setWeight(200).setPower(20)
                        .build(),
                new Wrestler.WrestlerBuilder().setName("Roman Reigns").setHealth(200).setWeight(230).setPower(25)
                        .build(),
                new Wrestler.WrestlerBuilder().setName("Rudra").setHealth(200).setWeight(220).setPower(30).build(),
                new Wrestler.WrestlerBuilder().setName("Dean Ambrose").setHealth(200).setWeight(210).setPower(35)
                        .build(),
                new Wrestler.WrestlerBuilder().setName("Shadow Phantom").setHealth(200).setWeight(240).setPower(40)
                        .build(),
                new Wrestler.WrestlerBuilder().setName("Blaze Storm").setHealth(200).setWeight(260).setPower(45)
                        .build(),
                new Wrestler.WrestlerBuilder().setName("Viper Storm").setHealth(200).setWeight(250).setPower(50)
                        .build(),
                new Wrestler.WrestlerBuilder().setName("Steel Guardian").setHealth(200).setWeight(260).setPower(55)
                        .build(),
                new Wrestler.WrestlerBuilder().setName("Dagger Fang").setHealth(200).setWeight(290).setPower(65)
                        .build(),
                new Wrestler.WrestlerBuilder().setName("Titan Fury").setHealth(200).setWeight(280).setPower(70).build()
        };
    }

    public static void arena(Wrestler w1, Wrestler w2) {
        w1.resetHealth();
        w2.resetHealth();

        System.out.println("\n--------------------------------------");
        System.out.println("Match: " + w1.getName() + " VS " + w2.getName());
        System.out.println("--------------------------------------");

        Match match = new Match(w1, w2);
        match.startMatch(); // Run match directly since it implements Runnable
    }
}


// semifinal 2 matches running parallel loosing first will become fourth.
