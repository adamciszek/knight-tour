package chess;

import java.util.List;

public class Tour {

	private Knight knight; //keeps track of the knights location
	
	
	/*
	 * This constructor sets the width and height to the given width and height, 
	 * as well as initializes the unvisited and visited location, 
	 * and initializes the knights location
	 */
	public Tour(int width, int height) {
		this.knight = new Knight(width, height);
		
	}
	
	/*
	 * This method sets the knights location to the given location, 
	 * also resets the unvisited and visited locations
	 */
	public void startTour(Location loc) {
		this.knight.moveTo(loc);
	}
	
	/*
	 * This method returns true if the knight has a position to move to, otherwise returns false
	 */
	public boolean hasNext() {
		List<Location> all_moves = knight.validMoves(knight.get_location());
		
		if (all_moves.isEmpty()) {
			return false;
		}
		return true;
	}
	

	/*
	 * This method returns the Location of the next move whilst moving the knight to the location, 
	 * or returns null if the knight cannot move to a location
	 */
	public Location next() {
		List<Location> moves = knight.validMoves(knight.get_location());
		
		if (moves.isEmpty()) {
			return null;
		}
		
		int smallest = knight.validMoves(moves.get(0)).size();
		Location nextLocation = moves.get(0);
		
		for (Location move : moves) {
			if (knight.validMoves(move).size() < smallest) {
				smallest = knight.validMoves(move).size();
				nextLocation = move;
			}
		}
			
		this.knight.moveTo(nextLocation);
		this.knight.addToVisited(nextLocation);
		return nextLocation;
	}
	
		
		
}