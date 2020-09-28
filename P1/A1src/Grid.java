/**
 * Class representing the polar coordinate grid
 */
public class Grid {

    private State[][] grid;
    private int levels;

    public Grid(int levels) {
        this.grid = new State[levels-1][8];
        this.levels = levels;
        for (int i = 0; i < levels-1; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j] = new State(i+1, j*45);
            }
        }
    }

    public void printGrid() {
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j].toString());
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public State[][] getGrid() {
        return grid;
    }

    public int getLevels() {
        return levels;
    }

}
