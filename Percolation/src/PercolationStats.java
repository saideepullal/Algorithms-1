import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

	private double mean;
	private double stddev;
	private double confidenceLo;
	private double confidenceHi;

	private int noOfOpenCells;

	// perform independent trials on an n-by-n grid
	public PercolationStats(int n, int trials) {

		if (n <= 0 || trials <= 0) {
			throw new IllegalArgumentException();
		}
		double[] percolationTresholdList = new double[trials];
		for (int i = 0; i < trials; i++) {
			Percolation percolation = new Percolation(n);
			while (!percolation.percolates()) {
				int row = StdRandom.uniform(n);
				int column = StdRandom.uniform(n);
				percolation.open(row, column);
				noOfOpenCells = percolation.numberOfOpenSites();
			}
			percolationTresholdList[i] = noOfOpenCells / (n * n);
			mean = StdStats.mean(percolationTresholdList);
			stddev = StdStats.stddev(percolationTresholdList);
			confidenceLo = mean - ((1.96 * stddev) / (Math.sqrt(trials)));
			confidenceLo = mean + ((1.96 * stddev) / (Math.sqrt(trials)));

		}

	}

	// sample mean of percolation threshold
	public double mean() {
		return mean;

	}

	// sample standard deviation of percolation threshold
	public double stddev() {
		return stddev;

	}

	// low endpoint of 95% confidence interval
	public double confidenceLo() {
		return confidenceLo;

	}

	// high endpoint of 95% confidence interval
	public double confidenceHi() {
		return confidenceHi;

	}

	// test client (see below)
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int trials = Integer.parseInt(args[1]);

		PercolationStats stats = new PercolationStats(n, trials);
		System.out.println(stats.mean());
		System.out.println(stats.stddev());
		System.out.println(stats.confidenceLo());
		System.out.println(stats.confidenceHi());
	}

}