
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

	private boolean grid[][];
	private int maxSize;
	private WeightedQuickUnionUF weightedQuickUnionUF;
	private int bottomCommonPoint;
	private int topCommonPoint = 0;
	private int noOfOpenSites = 0;

	public Percolation(int n) {
		// TODO add constructor that initializes the 2x2 matrix for percolation
		maxSize = n;
		bottomCommonPoint = (n * n + 1);
		// topCommonPoint = 0;
		if (n <= 0) {
			throw new IllegalArgumentException();
		}
		grid = new boolean[n][n];
		weightedQuickUnionUF = new WeightedQuickUnionUF(n * n + 2);

	}

	// opens the site (row, col) if it is not open already
	public void open(int row, int col) {
		if (row > maxSize || row < 1 || col > maxSize || col < 1) {
			throw new IllegalArgumentException();
		}
		if (row == 1) {
			int weightedQuickUnionGridIndex = getWeightedUnionGridIndex(row, col);
			weightedQuickUnionUF.union(weightedQuickUnionGridIndex, topCommonPoint);
		}
		if (row == maxSize) {
			int weightedQuickUnionGridIndex = getWeightedUnionGridIndex(row, col);
			weightedQuickUnionUF.union(weightedQuickUnionGridIndex, bottomCommonPoint);
		}
		if (!isOpen(row, col)) {
			int weightedQuickUnionGridIndex = getWeightedUnionGridIndex(row, col);
			performConnectIfOpen(weightedQuickUnionGridIndex, row + 1, col);
			performConnectIfOpen(weightedQuickUnionGridIndex, row - 1, col);
			performConnectIfOpen(weightedQuickUnionGridIndex, row, col + 1);
			performConnectIfOpen(weightedQuickUnionGridIndex, row, col - 1);
			grid[row - 1][col - 1] = true;
			noOfOpenSites++;
		}

	}

	// is the site (row, col) open?
	public boolean isOpen(int row, int col) {
		if (row > maxSize || row < 1 || col > maxSize || col < 1) {
			throw new IllegalArgumentException();
		}
		return grid[row - 1][col - 1];

	}

	// is the site (row, col) full?
	public boolean isFull(int row, int col) {
		if (row > maxSize || row < 1 || col > maxSize || col < 1) {
			throw new IllegalArgumentException();
		}
		int weightedIndex = getWeightedUnionGridIndex(row, col);
		if (weightedQuickUnionUF.find(weightedIndex) == weightedQuickUnionUF.find(topCommonPoint)) {
			return true;
		} else {
			return false;
		}

	}

	// returns the number of open sites
	public int numberOfOpenSites() {
		return noOfOpenSites;

	}

	// does the system percolate?
	public boolean percolates() {
		return weightedQuickUnionUF.find(topCommonPoint) == weightedQuickUnionUF.find(bottomCommonPoint);

	}

	// test client (optional)
	public static void main(String[] args) {

	}

	private void performConnectIfOpen(int WQFgridIndex, int row, int column) {
		try {
			if (isOpen(row, column)) {
				int consecutiveIndex = getWeightedUnionGridIndex(row, column);
				weightedQuickUnionUF.union(WQFgridIndex, consecutiveIndex);
			}

		} catch (IndexOutOfBoundsException e) {

		}

	}

	private int getWeightedUnionGridIndex(int row, int column) {
		return (row - 1) * maxSize + column;
	}

}
