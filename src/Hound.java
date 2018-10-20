
public class Hound extends Enemy{

	private int hunterX;
	private int hunterY;
	public Hound(int x, int y, String name, int[][] grid) {
		super(x, y, name, grid);
		// TODO Auto-generated constructor stub
	}
	
	public void setHunterCoords(int hunterX, int hunterY) {
		this.hunterX = hunterX;
		this.hunterY = hunterY;
	}

	public int[] houndAlg() {
		int coords[] = new int[2];
		
		return coords;
	}
	
	
}
