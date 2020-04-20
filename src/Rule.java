import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rule {

	public static final List<Rule> rules;

	static {

		rules = new ArrayList<>();

		// Rule #1
		rules.add(new Rule(2));
		rules.get(0).addNeighbor(2);

		// Rule #2
		rules.add(new Rule(1));
		rules.get(1).addNeighbor(1);
		rules.get(1).addNeighbor(2);

		// Rule #3
		rules.add(new Rule(1));
		rules.get(2).addNeighbor(1);
		rules.get(2).addNeighbor(3);

		// Rule #4
		rules.add(new Rule(3));
		rules.get(3).addNeighbor(3);
		rules.get(3).addNeighbor(4);

		// Rule #5
		rules.add(new Rule(1));
		rules.get(4).addNeighbor(1);
		rules.get(4).addNeighbor(5);

		// Rule #6
		rules.add(new Rule(1));
		rules.get(5).addNeighbor(1);
		rules.get(5).addNeighbor(3);
		rules.get(5).addNeighbor(5);

		// Rule #7
		rules.add(new Rule(5));
		rules.get(6).addNeighbor(3);
		rules.get(6).addNeighbor(6);

		// Rule #8
		rules.add(new Rule(2));
		rules.get(7).addNeighbor(2);
		rules.get(7).addNeighbor(4);
		rules.get(7).addNeighbor(6);

		// Rule #9
		rules.add(new Rule(7));
		rules.get(8).addNeighbor(3);
		rules.get(8).addNeighbor(5);
		rules.get(8).addNeighbor(6);

		// Rule #10
		rules.add(new Rule(5));
		rules.get(9).addNeighbor(3);
		rules.get(9).addNeighbor(7);

		// Rule #11
		rules.add(new Rule(2));
		rules.get(10).addNeighbor(2);
		rules.get(10).addNeighbor(5);
		rules.get(10).addNeighbor(7);

		// Rule #12
		rules.add(new Rule(13));
		rules.get(11).addNeighbor(3);
		rules.get(11).addNeighbor(5);
		rules.get(11).addNeighbor(7);

	}

	private int seedPixels;
	private Set<Integer> neighbors;

	public Rule(int seedPixels) {
		this.seedPixels = seedPixels;

		neighbors = new HashSet<>();
	}

	public int getSeedPixels() {
		return seedPixels;
	}

	public void addNeighbor(int neighbor) {
		neighbors.add(neighbor);
	}

	public boolean hasNeighbor(int neighbor) {
		return neighbors.contains(neighbor);
	}
}
