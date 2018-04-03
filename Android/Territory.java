import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Territory {
    int id, group, owner, armies;
    String name;
    List<Integer> adjacent;
    
    public Territory(int id, String name, Integer[] adjacent) {
	this.id = id;
	this.group = id / 100;
	this.owner = 0;
	this.name = name;
	this.armies = 0;
	this.adjacent = new ArrayList<Integer>(Arrays.asList(adjacent));
    }

    public String toString() {
	return String.format("%d %s owner: %d armies: %d adjacent: %s",
			     id, name, owner, armies, adjacent);
    }
    
    static Map<Integer, Territory> territories;

    // Sample territory names from https://en.wikipedia.org/wiki/Risk_%28game%29
    static void makeTerritories() {
	territories = new HashMap<Integer, Territory>();
	Territory[] newts = {
	    new Territory(201, "Argentina", new Integer[]{202, 203}),
	    new Territory(202, "Brazil", new Integer[]{201, 203, 204, 405}),
	    new Territory(203, "Peru", new Integer[]{201, 202, 204}),
	    new Territory(204, "Venezuela", new Integer[]{202, 203}),
	    new Territory(401, "Congo", new Integer[]{402, 405, 406}),
	    new Territory(402, "East Africa", new Integer[]{401, 403, 404,
							    405, 406}),
	    new Territory(403, "Egypt", new Integer[]{402, 405}),
	    new Territory(404, "Madagascar", new Integer[]{402, 406}),
	    new Territory(405, "North Africa", new Integer[]{401, 402,
							     403, 202}),
	    new Territory(406, "South Africa", new Integer[]{401, 402, 404})
	};
	
	for (Territory newt: newts) {
	    territories.put(newt.id, newt);
	}
    }

    static Territory getTerritory(int id) {
	return territories.get(id);
    }
    
    public static void main(String[] args) {
	makeTerritories();
	for (Territory territory: territories.values()) {
	    System.out.printf("%s\n", territory);
	}
	System.out.printf("\nTerritory 403: %s\n", getTerritory(403));
    }
}