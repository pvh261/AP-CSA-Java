import java.util.ArrayList;
import java.util.List;

class SparseArrayEntry {
    private int row;
    private int col;
    private int value;

    public SparseArrayEntry(int r, int c, int v) {
        row = r;
        col = c;
        value = v;
    }

    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }

    public int getValue() {
        return value;
    }
}

public class SparseArray {
    private int numRows;
    private int numCols;
    private List<SparseArrayEntry> entries;

    public SparseArray(ArrayList<SparseArrayEntry> e, int r, int c) {
        entries = e;
        numRows = r;
        numCols = c;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public int getValueAt(int row, int col) {
        int value = 0;
        for(int i = 0; i < entries.size(); i++) {
            if(entries.get(i).getRow() == row && entries.get(i).getCol() == col) {
                value = entries.get(i).getValue();
                break;
            }
        }
        return value;
    }

    public void removeColumn(int col) {
        numCols--;
        for(int i = entries.size() - 1; i >= 0; i--) {
            if(entries.get(i).getCol() == col) {
                entries.remove(i);
            } else if(entries.get(i).getCol() > col) {
                entries.set(i, new SparseArrayEntry(entries.get(i).getRow(), entries.get(i).getCol() - 1, entries.get(i).getValue()));
            }
        }
    }

    public void printEntries() {
        for(SparseArrayEntry i : entries) {
            System.out.println(i.getRow() + ", " + i.getCol() + ", " + i.getValue());
        }
    }

    public static void main(String[] args) {
        ArrayList<SparseArrayEntry> entries = new ArrayList<SparseArrayEntry>();
        entries.add(new SparseArrayEntry(1, 4, 4));
        entries.add(new SparseArrayEntry(2, 0, 1));
        entries.add(new SparseArrayEntry(3, 1, -9));
        entries.add(new SparseArrayEntry(1, 1, 5));
        entries.add(new SparseArrayEntry(2, 5, 10));
        SparseArray arr = new SparseArray(entries, 5, 5);
        arr.removeColumn(1);
        arr.printEntries();
        System.out.println(arr.getNumCols());
        arr.removeColumn(0);
        arr.printEntries();
        System.out.println(arr.getNumCols());
    }
}