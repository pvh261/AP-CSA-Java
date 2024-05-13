public class ArrayTester {
    public static void main(String[] args) {
        int[][] square1 = {{1, 2, 3}, {2, 3, 1}, {3, 1, 2}};
        int[][] square2 = {{10, 30, 20, 0}, {0, 20, 30, 10}, {30, 0, 10, 20}, {20, 10, 0, 30}};
        int[][] square3 = {{1, 2, 1}, {2, 1, 1}, {1, 1, 2}};
        int[][] square4 = {{1, 2, 3}, {3, 1, 2}, {7, 8, 9}};
        int[][] square5 = {{1, 2}, {1, 2}};
        int[][] square6 = {{1, 2}, {2, 1}};

        int[][][] squares = {square1, square2, square3, square4, square5, square6};
        for(int[][] s : squares) {
            System.out.println(isLatin(s));
        }
    }

    public static int arrayIndexOf(int[] arr, int i) {
        for(int j = 0; j < arr.length; j++) {
            if(arr[j] == i) {
                return j;
            }
        }
        return -1;
    }

    public static int[] getColumn(int[][] arr2D, int c) {
        int[] column = new int[arr2D.length];
        for(int i = 0; i < arr2D.length; i++) {
            column[i] = arr2D[i][c];
        }
        return column;
    }

    public static boolean hasAllValues(int[] arr1, int[] arr2) {
        for(int i = 0; i < arr1.length; i++) {
            if(arrayIndexOf(arr2, arr1[i]) == -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsDuplicates(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isLatin(int[][] square) {
        if(containsDuplicates(square[0])) {
            return false;
        }
        for(int i = 0; i < square.length; i++) {
            if(!hasAllValues(square[0], getColumn(square, i)) || !hasAllValues(square[0], square[i])) {
                return false;
            }
        }
        return true;
    }
}