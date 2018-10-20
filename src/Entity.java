
public abstract class Entity {
	int x;
	int y;
	String name;
	int[][] grid;
	
	public Entity(int x, int y, String name, int[][] grid) {
		this.x = x;
		this.y = y;
		this.name = name;
		this.grid = grid;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int[][] getGrid() {
		return this.grid;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
