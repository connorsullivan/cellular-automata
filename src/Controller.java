public class Controller {

	public static void main(String[] args) {

		KeyboardInputClass kb = new KeyboardInputClass();

		String rulePrompt = "Choose a growth rule for this simulation (1-12): ";
		String iterPrompt = "Specify a number of iterations to perform (0 to exit): ";

		// Let the user choose a rule to follow
		int userChoice = kb.getInteger(rulePrompt, 1, 12, 1);

		// Create the automaton object
		Automaton a = new Automaton(Rule.rules.get(userChoice - 1));

		while (true) {
			int iterations = kb.getInteger(iterPrompt, 0, Integer.MAX_VALUE, 1);

			if (iterations == 0) {
				break;
			}

			a.iterate(iterations);
		}

		// Explicitly exit to close any image resources
		System.exit(0);
	}
}
