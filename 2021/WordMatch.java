public class WordMatch {
    private String secret;

    public static void main(String[] args) {
        WordMatch w = new WordMatch("mississippi");
        System.out.println(w.scoreGuess("mississippi"));

        WordMatch game = new WordMatch("concatenation");
        System.out.println(game.scoreGuess("ten"));
        System.out.println(game.scoreGuess("nation"));
        System.out.println(game.findBetterGuess("ten", "nation"));
        System.out.println(game.scoreGuess("con"));
        System.out.println(game.scoreGuess("cat"));
        System.out.println(game.findBetterGuess("con", "cat"));
    }

    public WordMatch(String word) {
        secret = word;
    }

    public int scoreGuess(String guess) {
        int count = 0;
        for(int i = 0; i <= secret.length() - guess.length(); i++) {
            if(secret.substring(i, i + guess.length()).equals(guess)) {
                count++;
            }
        }
        return count * guess.length() * guess.length();
    }

    public String findBetterGuess(String guess1, String guess2) {
        if(scoreGuess(guess1) > scoreGuess(guess2)) {
            return guess1;
        } else if(scoreGuess(guess2) > scoreGuess(guess1)) {
            return guess2;
        } else {
            if(guess1.compareTo(guess2) >= 0) {
                return guess1;
            } else {
                return guess2;
            }
        }
    }
}