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

    public int longestHeatWave(double thresHold) {
        return 0;
    }

    public void showList() {
        for(double i : temperatures) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        double[] temp = {99.1, 142.0, 85.0, 85.1, 94.3, 124.9, 98.0, 101.0, 102.5};
        ArrayList<Double> temperatures = new ArrayList<Double>();
        for(double i : temp) {
            temperatures.add(i);
        }
        WeatherData a = new WeatherData(temperatures);
        a.showList();
        a.cleanData(85.0, 120.0);
        System.out.println();
        a.showList();
    }
}