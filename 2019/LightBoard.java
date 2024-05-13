public class LightBoard {
    private boolean[][] lights;

    public static void main(String[] args) {
        LightBoard lb = new LightBoard(5, 5);
        lb.showLights();
        System.out.println(lb.evaluateLight(2, 4));
        System.out.println(lb.evaluateLight(1, 2));
    }
    
    public LightBoard(int numRows, int numCols) {
        lights = new boolean[numRows][numCols];
        double chance;
        for(int r = 0; r < numRows; r++) {
            for(int c = 0; c < numCols; c++) {
                chance = Math.random();
                if(chance < 0.4) {
                    lights[r][c] = true;
                } else {
                    lights[r][c] = false;
                }
            }
        }
    }

    public boolean evaluateLight(int row, int col) {
        int countOn = 0;
        for(int r = 0; r < lights.length; r++) {
            if(lights[r][col]) {
                countOn++;
            }
        }
        if(lights[row][col] && countOn % 2 == 0) {
            return false;
        } else if(!lights[row][col] && countOn % 3 == 0) {
            return true;
        }
        return lights[row][col];
    }

    public void showLights() {
        for(boolean[] b : lights) {
            for(boolean b2 : b) {
                if(b2) {
                    System.out.print("[O] ");
                } else {
                    System.out.print("[ ] ");
                }
            }
            System.out.println();
        }
    }
}