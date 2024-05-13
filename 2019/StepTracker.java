public class StepTracker {
    private int minSteps;
    private int activeDays = 0;
    private int days = 0;
    private int totalSteps = 0;

    public static void main(String[] args) {
        StepTracker tr = new StepTracker(10000);
        System.out.println(tr.activeDays());
        System.out.println(tr.averageSteps());
        tr.addDailySteps(9000);
        tr.addDailySteps(5000);
        System.out.println(tr.activeDays());
        System.out.println(tr.averageSteps());
        tr.addDailySteps(13000);
        System.out.println(tr.activeDays());
        System.out.println(tr.averageSteps());
        tr.addDailySteps(23000);
        tr.addDailySteps(1111);
        System.out.println(tr.activeDays());
        System.out.println(tr.averageSteps());
    }

    public StepTracker(int minNumSteps) {
        minSteps = minNumSteps;
    }

    public void addDailySteps(int steps) {
        days++;
        totalSteps += steps;
        if(steps >= minSteps) {
            activeDays++;
        }
    }

    public int activeDays() {
        return activeDays;
    }

    public double averageSteps() {
        if(days == 0) {
            return 0;
        }
        return totalSteps / (double)days;
    }
}