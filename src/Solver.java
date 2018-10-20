import java.util.Arrays;

public class Solver {
	
    final static int TRIED = -1;
    static int PATH = 0;
   
    
    private int[][] grid;
    private int height;
    private int width;
    private int ax;
    private int ay;
    private int bx;
    private int by;
    private int[][] map;
    
    public Solver(int[][] grid, int ax, int ay, int bx, int by) {
        this.grid = grid;
        this.height = grid.length;
        this.width = grid[0].length;
        this.ax = ax;
        this.ay = ay;
        this.bx = bx;
        this.by = by;
        this.map = new int[height][width];
    }
    
    public boolean solve() {
    	// INITIAL COORDINATES ONLY
        return traverse(this.ax, this.ay);
    }

    private boolean traverse(int i, int j) {
        if (!isValid(i,j)) {
            return false;
        }

        if ( isEnd(i, j) ) {
            map[i][j] = PATH;
            PATH++;
            return true;
        } else {
            map[i][j] = TRIED;
        }

        // North
        if (traverse(i - 1, j)) {
            map[i-1][j] = PATH;
            PATH++;
            return true;
        }
        // East
        if (traverse(i, j + 1)) {
            map[i][j + 1] = PATH;
            PATH++;
            return true;
        }
        // South
        if (traverse(i + 1, j)) {
            map[i + 1][j] = PATH;
            PATH++;
            return true;
        }
        // West
        if (traverse(i, j - 1)) {
            map[i][j - 1] = PATH;
            PATH++;
            return true;
        }

        return false;
    }

    private boolean isEnd(int i, int j) {
    	// END COORDINATES ONLY
        return i == this.bx && j == this.by;
    }

    private boolean isValid(int i, int j) {
        if (inRange(i, j) && isOpen(i, j) && !isTried(i, j)) {
            return true;
        }

        return false;
    }

    private boolean isOpen(int i, int j) {
        return grid[i][j] == 1;
    }

    private boolean isTried(int i, int j) {
        return map[i][j] == TRIED;
    }

    private boolean inRange(int i, int j) {
        return inHeight(i) && inWidth(j);
    }

    private boolean inHeight(int i) {
        return i >= 0 && i < height;
    }

    private boolean inWidth(int j) {
        return j >= 0 && j < width;
    }

    public String toString() {
        String s = "";
        for (int[] row : map) {
            s += Arrays.toString(row) + "\n";
        }
        return s;
    }
    
    public int lengthPath() {
        int i, j, counter = 0;
        for (i = 0; i < map.length; i++) {
        	for (j = 0; j < map[0].length; j++) {
        		if (map[i][j] >= 1) {
        			counter++;
        		}
        	}
        }
        return counter - 1;
    }
    
    public int[] getNextPoint() {
    	int[] coords = new int[2];
    	int i, j;
        A: for (i = 0; i < map.length; i++) {
        	for (j = 0; j < map[0].length; j++) {
        		if (map[i][j] == 1) {
        			coords[0] = i;
        			coords[1] = j;
        			break A;
        		}
        	}
        }
    	return coords;
    }
    
    public int[] getMidPoint() {
    	int[] coords = new int[2];
    	int i, j;
        A: for (i = 0; i < map.length; i++) {
        	for (j = 0; j < map[0].length; j++) {
        		if (map[i][j] == lengthPath()/2) {
        			coords[0] = i;
        			coords[1] = j;
        			break A;
        		}
        	}
        }
    	return coords;
    }


}
