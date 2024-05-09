import java.util.ArrayList;

public class WeatherData {
    private ArrayList<Double> temperatures;

    public WeatherData(ArrayList<Double> temperatures) {
        this.temperatures = temperatures;
    }

    public void cleanData(double lower, double upper) {
        for(int i = 0; i < temperatures.size(); i++) {
            if(temperatures.get(i) < lower || temperatures.get(i) > upper) {
                temperatures.remove(i);
            }
        }
    }

    public int longestHeatWave(double threshold) {
        int count = 0;
        int max = 0;
        for(int i = 0; i < temperatures.size(); i++) {
            if(temperatures.get(i) > threshold) {
                count++;
            } else {
                if(count > max) {
                    max = count;
                }
                count = 0;
            }
        }
        if(max > count) {
            return max;
        } else {
            return count;
        }
    }

    public void showList() {
        for(double i : temperatures) {
            System.out.println(i);
        }
    }
    
    public static void main(String[] args) {
        double[] temp1 = {99.1, 142.0, 85.0, 85.1, 94.3, 124.9, 98.0, 101.0, 102.5};
        ArrayList<Double> temperatures1 = new ArrayList<Double>();
        for(double i : temp1) {
            temperatures1.add(i);
        }
        WeatherData a = new WeatherData(temperatures1);
        a.showList();
        a.cleanData(85.0, 120.0);
        System.out.println();
        a.showList();

        double[] temp2 = {100.5, 98.5, 102.0, 103.9, 87.5, 105.2, 90.3, 94.8, 109.1, 102.1, 107.4, 93.2};
        ArrayList<Double> temperatures2 = new ArrayList<Double>();
        for(double i : temp2) {
            temperatures2.add(i);
        }
        WeatherData b = new WeatherData(temperatures2);
        System.out.println(b.longestHeatWave(100.5));
        System.out.println(b.longestHeatWave(95.2));
    }
}