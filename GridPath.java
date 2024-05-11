public class GridPath {
    private int[][] grid;

    public static void main(String[] args) {
        int[][] grid = {{12, 3, 4, 13, 5}, {11, 21, 2, 14, 16}, {7, 8, 9, 15, 0}, {10, 17, 20, 19, 1}, {18, 22, 30, 25, 6}};
        GridPath gp = new GridPath(grid);
        System.out.println(gp.sumPath(1, 1));

        int[][] grid2 = {{12, 30, 40, 25, 5}, {11, 3, 22, 15, 43}, {7, 2, 9, 4, 0}, {8, 33, 18, 6, 1}};
        GridPath gp2 = new GridPath(grid2);
        System.out.println(gp2.sumPath(1, 1));
    }

    public GridPath(int[][] g) {
        grid = g;
    }

    public Location getNextLoc(int row, int col) {
        int right = Integer.MAX_VALUE;
        int below = Integer.MAX_VALUE;
        if(row < grid.length - 1) {
            below = grid[row+1][col];
        }
        if(col < grid[0].length - 1) {
            right = grid[row][col+1];
        }
        if(right > below) {
            return new Location(row+1, col);
        } else {
            return new Location(row, col+1);
        }
    }

    public int sumPath(int row, int col) {
        Location loc = new Location(row, col);
        int sum = grid[loc.getRow()][loc.getCol()];
        while((loc.getRow() < grid.length - 1 || loc.getCol() < grid.length - 1)) {
            loc = getNextLoc(loc.getRow(), loc.getCol());
            sum += grid[loc.getRow()][loc.getCol()];
        }
        return sum;
    }
}

class Location {
    private int theRow;
    private int theCol;

    public Location(int r, int c) {
        theRow = r;
        theCol = c;
    }

    public int getRow() {
        return theRow;
    }

    public int getCol() {
        return theCol;
    }
}