public class Scoreboard {
    private String team1;
    private String team2;
    private String active;
    private int t1points = 0;
    private int t2points = 0;

    public static void main(String[] args) {
        Scoreboard game = new Scoreboard("Red", "Blue");
        System.out.println(game.getScore());
        game.recordPlay(1);
        System.out.println(game.getScore());
        game.recordPlay(0);
        System.out.println(game.getScore());
        System.out.println(game.getScore());
        game.recordPlay(3);
        System.out.println(game.getScore());
        game.recordPlay(1);
        game.recordPlay(0);
        System.out.println(game.getScore());
        game.recordPlay(0);
        game.recordPlay(4);
        game.recordPlay(0);
        System.out.println(game.getScore());
        Scoreboard match = new Scoreboard("Lions", "Tigers");
        System.out.println(match.getScore());
        System.out.println(game.getScore());
    }

    public Scoreboard(String t1, String t2) {
        team1 = t1;
        team2 = t2;
        active = team1;
    }

    public void recordPlay(int point) {
        if(active == team1) {
            if(point == 0) {
                active = team2;
            } else {
                t1points += point;
            }
        } else {
            if(point == 0) {
                active = team1;
            } else {
                t2points += point;
            }
        }
    }

    public String getScore() {
        return t1points + " - " + t2points + " - " + active;
    }
}