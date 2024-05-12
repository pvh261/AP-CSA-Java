public class Game {
    private Level levelOne;
    private Level levelTwo;
    private Level levelThree;
    private boolean isBonus;

    public static void main(String[] args) {
        Game g1 = new Game(new Level(true, 200), new Level(true, 100), new Level(true, 500), true);
        System.out.println(g1.getScore());
        Game g2 = new Game(new Level(true, 200), new Level(true, 100), new Level(false, 500), false);
        System.out.println(g2.getScore());
        Game g3 = new Game(new Level(true, 200), new Level(false, 100), new Level(true, 500), true);
        System.out.println(g3.getScore());
        Game g4 = new Game(new Level(false, 200), new Level(true, 100), new Level(true, 500), false);
        System.out.println(g4.getScore());
    }

    public Game(Level l1, Level l2, Level l3, boolean bonus) {
        levelOne = l1;
        levelTwo = l2;
        levelThree = l3;
        isBonus = bonus;
    }

    public void play() {

    }

    public int getScore() {
        int score = 0;
        if(levelOne.goalReached()) {
            score += levelOne.getPoints();
            if(levelTwo.goalReached()) {
                score += levelTwo.getPoints();
                if(levelThree.goalReached()) {
                    score += levelThree.getPoints();
                }
            }
        }
        if(isBonus) {
            return score * 3;
        } else {
            return score;
        }
    }

    public int playManyTimes(int num) {
        int max = 0;
        for(int i = 0; i < num; i++) {
            play();
            int score = getScore();
            if(score > max) {
                max = score;
            }
        }
        return max;
    }
}

class Level {
    private boolean goalReached;
    private int points;

    public Level(boolean gR, int p) {
        goalReached = gR;
        points = p;
    }

    public int getPoints() {
        return points;
    }

    public boolean goalReached() {
        return goalReached;
    }
}