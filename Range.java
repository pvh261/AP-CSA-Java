import java.util.ArrayList;

interface NumberGroup {
    public boolean contains(int n);
}

public class Range implements NumberGroup {
    private int min;
    private int max;
    private ArrayList<Integer> group = new ArrayList<Integer>();

    public Range(int min, int max) {
        this.min = min;
        this.max = max;
        for(int i = min; i <= max; i++) {
            group.add(i);
        }
    }

    public boolean contains(int n) {
        return n >= min && n <= max;
    }

    public static void main(String[] args) {
        NumberGroup range = new Range(-3, 2);
    }
}


//MultipleGroups class contains() method
// public boolean contains(int n) {
//     for(NumberGroup list : groupList) {
//         if(list.contains(n)) {
//             return true;
//         }
//     }
//     return false;
// }