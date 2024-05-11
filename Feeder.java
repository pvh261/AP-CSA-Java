public class Feeder {
    private int currentFood;

    public static void main(String[] args) {
        // Feeder f1 = new Feeder(500);
        // Feeder f2 = new Feeder(1000);
        // Feeder f3 = new Feeder(100);
        // f1.simulateOneDay(12);
        // f2.simulateOneDay(22);
        // f3.simulateOneDay(5);

        Feeder f4 = new Feeder(2400);
        System.out.println(f4.simulateManyDays(5, 10));
    }

    public Feeder(int cfood) {
        currentFood = cfood;
    }

    public int getFood() {
        return currentFood;
    }

    public void simulateOneDay(int numBirds) {
        double chance = Math.random();
        System.out.println("Chance: " + chance);
        if(chance <= 0.95) {
            int foodEaten = numBirds * (int)(Math.random() * 41 + 10);
            System.out.println("Food Eaten Per Bird: " + foodEaten / numBirds);
            if(foodEaten > currentFood) {
                currentFood = 0;
            } else {
                currentFood -= foodEaten;
            }
        } else {
            currentFood = 0;
        }
        System.out.println("Remaining Food: " + currentFood);
        System.out.println();
    }

    public int simulateManyDays(int numBirds, int numDays) {
        int days = 0;
        while(days < numDays && currentFood > 0) {
            simulateOneDay(numBirds);
            days++;
        }
        return days;
    }
}