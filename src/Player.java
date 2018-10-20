import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Player extends Entity{

	private boolean invincibility;
	private boolean hover;
	public Player(int x, int y, String name, int[][] grid) {
		super(x, y, name, grid);
		this.invincibility = false;
		this.hover = false;
	}
	
	public int[] getNextMove() {
		
		List<int[]> coordList = new ArrayList<int[]>();
		
		if (getX() >= 1) {
			if (grid[getY()][getX()-1] != 0) {
				int[] coords = new int[2];
			    coords[0] = getY();
			    coords[1] = getX() - 1;
			    coordList.add(coords);
			}
		}
		if (getX() <= grid[0].length) {
			if (grid[getY()][getX()+1] != 0) {
				int[] coords = new int[2];
			    coords[0] = getY();
			    coords[1] = getX() + 1;
			    coordList.add(coords);
			}
		}
		if (getY() >= 1) {
			if (grid[getY()-1][getX()] != 0) {
				int[] coords = new int[2];
			    coords[0] = getY() - 1;
			    coords[1] = getX();
		    	coordList.add(coords);
			}
		}
		if (getY() <= grid.length) {
			if (grid[getY()+1][getX()] != 0) {
				int[] coords = new int[2];
			    coords[0] = getY() + 1;
			    coords[1] = getX();
			    coordList.add(coords);
			}
		}
        Iterator<int[]> coord_Iterator = coordList.iterator();
        int counter = 0;
        while (coord_Iterator.hasNext()) {
        	
    		int[] EI = new int[2];
    		EI = coord_Iterator.next();
    		counter++;
        }
		Collections.shuffle(coordList);
		int[] coords = new int[2];
		coords = coordList.get(0);
		coordList.clear();
		return coords;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean isInvincible() {
		return this.invincibility;
	}
	
	public boolean isHover() {
		return this.hover;
	}
}
