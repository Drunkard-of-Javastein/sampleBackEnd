import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int cycle = 0;
        
        int[][] GRID = { 
                { 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0 },
                { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } 
            };
        
        // Create player
        Player player = new Player(0, 0, "player", GRID);
        
        // Create enemies then add them to arraylist
        ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
        
        Hunter hunter = new Hunter(0, 1, "hunter", GRID);
        enemyList.add(hunter);
        Strategist strategist = new Strategist(0, 1, "strategist", GRID);
        enemyList.add(strategist);
        Coward coward = new Coward(0, 1, "coward", GRID);
        enemyList.add(coward);
        Hound hound = new Hound(0, 1, "hound", GRID);
        enemyList.add(hound);
        
        
        Iterator<Enemy> enemy_Iterator = enemyList.iterator();
        while (enemy_Iterator.hasNext()) {
    		Enemy EI = enemy_Iterator.next();
    		EI.setPlayerCoords(player.getX(), player.getY());
        }
        
        int[] playerCoords = new int[2];
        playerCoords = player.getNextMove();
        System.out.println("playerCoords = "+playerCoords[0]+" "+playerCoords[1]);
        player.setX(playerCoords[1]);
        player.setY(playerCoords[0]);
        playerCoords = player.getNextMove();
        System.out.println("playerCoords = "+playerCoords[0]+" "+playerCoords[1]);
        while(true) {
        	if (cycle == 10) {
        		// Player makes move
        		
        		
        		// Strategist makes move
        		
        		// Hunter makes move
        		
        		// Hound makes move
        		
        		// Coward makes move
        		break;
        	}
        	cycle++;
        }
        
        Solver newSolver = new Solver(GRID,0,5,0,0);
        boolean solved = newSolver.solve();
        //System.out.println("Solved: " + solved);
        int []coords = new int[2];
        System.out.println("Length is: " + newSolver.lengthPath());
        int []coords1 = new int[2];
        coords1 = newSolver.getMidPoint();
        System.out.println("coords1[0] = "+coords1[0]+", coords1[1] = "+coords1[1]);
        System.out.println(newSolver.toString());
	}
	


}
