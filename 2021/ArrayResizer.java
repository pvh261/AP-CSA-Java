public class ArrayResizer {
    public static void main(String[] args) {
        int[][] arr = { {2, 1, 0},
                        {1, 3, 2},
                        {0, 0, 0},
                        {4, 5, 6}};
        for(int i = 0; i < arr.length; i++) {
            ArrayResizer.isNonZeroRow(arr, i);
        }
        System.out.println();
        int[][] arr2 = {{2, 1, 0},
                        {1, 3, 2},
                        {0, 0, 0},
                        {4, 5, 6}};
        int[][] smaller = resize(arr2);
        for(int i = 0; i < smaller.length; i++) {
            for(int j = 0; j < smaller[i].length; j++) {
                System.out.print("[" + smaller[i][j] + "] ");
            }
            System.out.println();
        }
    }

    public static boolean isNonZeroRow(int[][] array2D, int r) {
        for(int i = 0; i < array2D[r].length; i++) {
            if(array2D[r][i] == 0) {
                System.out.println(false);
                return false;
            }
        }
        System.out.println(true);
        return true;
    }

    public static int numNonZeroRows(int[][] array2D) {
        int count = 0;
        for(int i = 0; i < array2D.length; i++) {
            if(isNonZeroRow(array2D, i)) {
                count++;
            }
        }
        return count;
    }

    public static int[][] resize(int[][] array2D) {
        int[][] smaller = new int[numNonZeroRows(array2D)][array2D[0].length];
        int index = 0;
        for(int i = 0; i < array2D.length; i++) {
            if(isNonZeroRow(array2D, i)) {
                smaller[index] = array2D[i];
                index++;
            }
        }
        return smaller;
    }
}