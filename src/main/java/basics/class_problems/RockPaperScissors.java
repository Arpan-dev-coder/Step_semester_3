package basics.class_problems;

import java.util.Random;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove == null || computerMove == null) {
            return "Draw";
        }
        playerMove = playerMove.trim();
        computerMove = computerMove.trim();

        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if (playerMove.equalsIgnoreCase("Rock")) {
            return computerMove.equalsIgnoreCase("Scissors") ? "Player Wins" : "Computer Wins";
        } else if (playerMove.equalsIgnoreCase("Paper")) {
            return computerMove.equalsIgnoreCase("Rock") ? "Player Wins" : "Computer Wins";
        } else if (playerMove.equalsIgnoreCase("Scissors")) {
            return computerMove.equalsIgnoreCase("Paper") ? "Player Wins" : "Computer Wins";
        }

        return "Draw";
    }

    public static String runSimulation(int rounds) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random rand = new Random();
        int wins = 0, losses = 0, draws = 0;

        for (int i = 1; i <= rounds; i++) {
            String pMove = moves[rand.nextInt(3)];
            String cMove = moves[rand.nextInt(3)];
            String res = playRound(pMove, cMove);
            if (res.equals("Player Wins")) wins++;
            else if (res.equals("Computer Wins")) losses++;
            else draws++;
            System.out.println("Round " + i + " — Player: " + pMove + ", Computer: " + cMove + " -> " + res);
        }

        double winPct = rounds > 0 ? (wins * 100.0 / rounds) : 0.0;
        String summary = String.format("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%", wins, losses, draws, winPct);
        System.out.println("Final Summary (after " + rounds + " rounds) " + summary);
        return summary;
    }
}