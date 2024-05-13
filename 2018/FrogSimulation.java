public class FrogSimulation {
    private int goalDistance;
    private int maxHops;

    public FrogSimulation(int dist, int numHops) {
        goalDistance = dist;
        maxHops = numHops;
    }

    private int hopDistance() {
        //Not shown
    }

    public boolean simulate() {
        int position = 0;
        for(int i = 0; i < maxHops; i++) {
            position += hopDistance();
            if(position >= goalDistance) {
                return true;
            } else if(position < 0) {
                return false;
            }
        }
        return false;
    }

    public double runSimulations(int num) {
        int count = 0;
        for(int i = 0; i < num; i++) {
            if(simulate()) {
                count++;
            }
        }
        return (double)count / (double)num;
    }
}