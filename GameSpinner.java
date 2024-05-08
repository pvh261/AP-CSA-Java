public class GameSpinner {
    int sector;
    int current = 0;
    int lastSpin = 0;

    public static void main(String[] args) {
        GameSpinner g = new GameSpinner(4);
        System.out.println("Current run: " + g.currentRun());
        System.out.println(g.spin());
        System.out.println("Current run: " + g.currentRun());
        System.out.println(g.spin());
        System.out.println("Current run: " + g.currentRun());
        System.out.println(g.spin());
        System.out.println("Current run: " + g.currentRun());
        System.out.println(g.spin());
        System.out.println("Current run: " + g.currentRun());
        System.out.println(g.spin());
        System.out.println(g.spin());
        System.out.println(g.spin());
        System.out.println("Current run: " + g.currentRun());
    }

    public GameSpinner(int sector) {
        this.sector = sector;
    }

    public int spin() {
        int output = (int)(sector * Math.random()) + 1;
        if(current == 0) {
            current++;
        } else {
            if(output == lastSpin) {
                current++;
            } else {
                current = 1;
            }
        }
        lastSpin = output;
        return output;
    }

    public int currentRun() {
        return current;
    }
}