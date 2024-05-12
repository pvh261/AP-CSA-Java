import java.util.ArrayList;

public class DiverseArray {
    public static void main(String[] args) {
        int[][] array2D={{3, 4, 5}, {0, 5, 1}, {6, 7, 8}, {0, 2, 3}};
        System.out.print(isDiverse(array2D));
    }

    public static int arraySum(int[] arr) {
        int sum=0;
        for(int i=0; i < arr.length; i++) {
            sum+=arr[i];
        };
        return sum;
    }

    public static Integer[] rowSums(int[][] arr2D) {
        ArrayList<Integer> rowSums = new ArrayList<Integer>();
        for(int i=0; i < arr2D.length; i++) {
            int sum = arraySum(arr2D[i]);
            rowSums.add(sum);
        };
        Integer[] results = rowSums.toArray(new Integer[arr2D.length]);
        return results;
    }

    public static String isDiverse(int[][] arr2D) {
        Integer[] rowSums = rowSums(arr2D);
        String result = "Diverse";
        for(int i : rowSums) {
            System.out.print(i + ", ");
        };
        for(int i = 0; i < rowSums.length-1; i++) {
            int min_id = i;
            for(int j = i + 1; j < rowSums.length; j++) {
                if(rowSums[j] < rowSums[min_id]) {
                    min_id = j;
                };
            };
            int swap = rowSums[i];
            rowSums[i] = rowSums[min_id];
            rowSums[min_id] = swap;
        };
        System.out.println();
        for(int i : rowSums) {
            System.out.print(i + ", ");
        };
        System.out.println();
        for(int i = 0; i < rowSums.length - 1; i++) {
            if(rowSums[i] == rowSums[i+1]) {
                result = "Not Diverse";
            };
        };
        return result;
    }
}