public class Data {
    public static final int MAX = 200;
    private int[][] grid;

    public static void main(String[] args) {
        int[][] g = {{12, 3, 34}, {12, 3, 35}, {54, 3, 7}};
        Data d = new Data(g);
        d.showGrid();
        System.out.println(d.countIncreasingCols());
        d.repopulate();
        d.showGrid();
        System.out.println(d.countIncreasingCols());

        int[][] g2 = {{10, 50, 40}, {20, 40, 20}, {30, 50, 30}};
        Data d2 = new Data(g2);
        System.out.println(d2.countIncreasingCols());
        int[][] g3 = {{10, 540, 440, 440}, {220, 450, 440, 190}};
        Data d3 = new Data(g3);
        System.out.println(d3.countIncreasingCols());
    }

    public Data(int[][] g) {
        grid = g;
    }

    public void repopulate() {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                int x = 0;
                while(x % 100 == 0) {
                    x = (int)((MAX/10) * Math.random() + 1) * 10;
                }
                grid[i][j] = x;
            }
        }
    }

    public int countIncreasingCols() {
        int count = 0;
        for(int c = 0; c < grid[0].length; c++) {
            boolean inc = true;
            for(int r = 1; r < grid.length; r++) {
                if(grid[r][c] < grid[r-1][c]) {
                    inc = false;
                }
            }
            if(inc) {
                count++;
            }
        }
        return count;
    }

    public void showGrid() {
        for(int[] r : grid) {
            for(int c : r) {
                System.out.print("[" + c + "] ");
            }
            System.out.println();
        }
    }
}