import java.awt.Color;

public class Automaton {

	private static final int rows = 151;
	private static final int cols = 201;
	private static final int scale = 4;

	private boolean[][] data;
	private Rule rule;
	private ImageDisplay imageDisplay;

	public Automaton(Rule rule) {
		this.rule = rule;

		data = new boolean[rows][cols];

		int seedPixels = rule.getSeedPixels();

		int r = rows / 2;
		int c = cols / 2 - seedPixels / 2;

		for (int i = 0; i < seedPixels; i++) {
			data[r][c++] = true;
		}

		imageDisplay = new ImageDisplay(rows, cols, scale, "Cellular Automaton");

		updateImage();
	}

	private void updateImage() {

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {

				if (data[r][c]) {
					imageDisplay.image[r][c] = Color.WHITE;
				} else {
					imageDisplay.image[r][c] = Color.BLACK;
				}
			}
		}
	}

	public void iterate(int iterations) {

		for (int i = 0; i < iterations; i++) {

			// Create a copy of the array to be iterated over
			boolean[][] copy = data.clone();

			for (int j = 0; j < copy.length; j++) {
				copy[j] = data[j].clone();
			}

			// Make any updates to the copied array
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {

					// Get the number of living neighbors for this position
					int neighbors = getNeighborCount(row, col);

					if (rule.hasNeighbor(neighbors)) {
						copy[row][col] = true;
					}
				}
			}

			// Reference the copied array
			data = copy;

			// Update the image display
			updateImage();
		}
	}

	private int getNeighborCount(int row, int col) {

		int neighbors = 0;

		for (int r = row - 1; r <= row + 1; r++) {
			for (int c = col - 1; c <= col + 1; c++) {

				// Don't examine the cell itself
				if (r == row && c == col) {
					continue;
				}

				// If this neighbor is "alive", add it to the count
				if (data[mod(r, rows)][mod(c, cols)]) {
					neighbors++;
				}
			}
		}

		return neighbors;
	}

	private int mod(int a, int n) {
		if (n < 1) {
			throw new IllegalArgumentException("n must be >= 1");
		}

		while (a < 0) {
			a += n;
		}

		return a % n;
	}
}
