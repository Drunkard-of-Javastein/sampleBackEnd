
public class Enemy extends Entity{
	protected int playerX;
	protected int playerY;
	public Enemy(int x, int y, String name, int[][] grid) {
		super(x, y, name, grid);
	}
	
	public void setPlayerCoords(int playerX, int playerY) {
		this.playerX = playerX;
		this.playerY = playerY;
	}
	
	public int distanceToPlayer(int x, int y) {
		int dist = 0;
		Solver newSolver = new Solver(grid, x, y, playerX, playerY);
		boolean solved = newSolver.solve();
		return newSolver.lengthPath();
	}
	
	// If player is invincible
	public int[] invincibleAlg() {
		int curr_dist = distanceToPlayer(getX(), getY());
		
		if (getX() >= 1) {
			if (grid[getY()][getX()-1] != 0) {
				int[] coords = new int[2];
			    coords[0] = getY();
			    coords[1] = getX() - 1;
			    int next_dist = distanceToPlayer(coords[0], coords[1]);
			    if (next_dist > curr_dist) {
			    	return coords;
			    }
			}
		}
		if (getX() <= grid[0].length) {
			if (grid[getY()][getX()+1] != 0) {
				int[] coords = new int[2];
			    coords[0] = getY();
			    coords[1] = getX() + 1;
			    int next_dist = distanceToPlayer(coords[0], coords[1]);
			    if (next_dist > curr_dist) {
			    	return coords;
			    }
			}
		}
		if (getY() >= 1) {
			if (grid[getY()-1][getX()] != 0) {
				int[] coords = new int[2];
			    coords[0] = getY() - 1;
			    coords[1] = getX();
			    int next_dist = distanceToPlayer(coords[0], coords[1]);
			    if (next_dist > curr_dist) {
			    	return coords;
			    }
			}
		}
		if (getY() <= grid.length) {
			if (grid[getY()+1][getX()] != 0) {
				int[] coords = new int[2];
			    coords[0] = getY() + 1;
			    coords[1] = getX();
			    int next_dist = distanceToPlayer(coords[0], coords[1]);
			    if (next_dist > curr_dist) {
			    	return coords;
			    }
			}
		}
		int[] coords = new int[2];
		coords[0] = getY();
		coords[1] = getX();
		return coords;
	}
	
	// Like Dijkstra's algorithm
	public int[] defaultAlg() {
		Solver newSolver = new Solver(grid, x, y, playerX, playerY);
		boolean solved = newSolver.solve();
		int[] coords = new int[2];
		coords = newSolver.getNextPoint();
		return coords;
	}
	

}