public class SingleTable {
    private int numSeats;
    private int height;
    private double viewQuality;

    public static void main(String[] args) {
        SingleTable t1 = new SingleTable(4, 74, 60);
        SingleTable t2 = new SingleTable(8, 74, 70);
        SingleTable t3 = new SingleTable(12, 76, 75);

        CombinedTable c1 = new CombinedTable(t1, t2);
        System.out.println(c1.canSeat(9));
        System.out.println(c1.canSeat(11));
        System.out.println(c1.getDesirability());
        
        CombinedTable c2 = new CombinedTable(t2, t3);
        System.out.println(c2.canSeat(18));
        System.out.println(c2.getDesirability());
        t2.setViewQuality(80);
        System.out.println(c2.getDesirability());
    }

    public SingleTable(int s, int h, double vq) {
        numSeats = s;
        height = h;
        viewQuality = vq;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public int getHeight() {
        return height;
    }

    public double getViewQuality() {
        return viewQuality;
    }

    public void setViewQuality(double value) {
        viewQuality = value;
    }
}

class CombinedTable {
    private int numSeats;
    private double desirability;
    private SingleTable table1;
    private SingleTable table2;

    public CombinedTable(SingleTable t1, SingleTable t2) {
        numSeats = t1.getNumSeats() + t2.getNumSeats() - 2;
        table1 = t1;
        table2 = t2;
    }

    public boolean canSeat(int n) {
        if(numSeats >= n) {
            return true;
        } else {
            return false;
        }
    }

    public double getDesirability() {
        desirability = (table1.getViewQuality() + table2.getViewQuality()) / 2;
        if(table1.getHeight() != table2.getHeight()) {
            desirability -= 10;
        }
        return desirability;
    }
}