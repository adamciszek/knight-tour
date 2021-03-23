package chess;

import java.util.ArrayList;
import java.util.List;

public class Knight {

	private Location knight;
	private List<Location> visited_locations;
	private int width;
	private int height;
	
	/*
	 * This initiates the knight to a location
	 */
	public Knight(int width, int height) {
		this.knight = new Location();
		this.visited_locations = new ArrayList<>();
		this.width = width;
		this.height = height;
	}
	
	/*
	 * This method moves the knight to the location provided
	 */
	public void moveTo(Location loc) {
		this.knight = loc;
	}
	
	/*
	 * This method return a list of all possible moves
	 */
	public List<Location> moves(Location from){
		List<Location> result = new ArrayList<>();
		int[][] offset = {{-2,1}, {-2,-1}, {-1,2},{-1,-2},{1,2},{1,-2},{2,1}, {2,-1}};
		
		for (int[] delta : offset) {
			Location newLoc = new Location(from.x()+delta[0], from.y()+delta[1]);
			result.add(newLoc);
		}
		return result;
		
	}
	
	/*
	 * This method return a boolean value of whether a specific location is on the board
	 */
	public boolean isValid(Location loc) {
		if (loc.x()< 1 || loc.x()> this.width || loc.y() < 1 || loc.y() > this.height || this.visited_locations.contains(loc)) {
			return false;
		}
		return true;
	
	}
	/*
	 * This method returns a List of locations which are valid for the knight to move to
	 */
	public List<Location> validMoves(Location loc){
		List<Location> moves = this.moves(loc);
		List<Location> validMoves = new ArrayList<>();
		
		for (Location move : moves) {
			if (this.isValid(move)) {
				validMoves.add(move);
			}
		}
		
		return validMoves;
	}
	
	/*
	 * Returns the Location of the knight
	 */
	public Location get_location() {
		return knight;
	}
	/*
	 * This method adds a location that has been visited to the visited_locations list
	 */
	public void addToVisited(Location loc) {
		this.visited_locations.add(loc);
	}
	
}
	
