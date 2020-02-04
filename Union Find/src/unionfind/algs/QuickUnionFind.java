package unionfind.algs;
// Quick Union Find
public class QuickUnionFind {
	
	private int[] connections;
	
	public QuickUnionFind(Integer n) {
		connections = new int[n];
		for (int i = 0; i < n; i++) {
			connections[i] = i; // Takes n times
		}
	}
	
	public Integer root(int p) {
		while (connections[p] != p) {
			p = connections[p];
		}
		return p;
	}
	
	public Boolean connected(int p, int q) {
		return root(p) == root(q); // can grow to linear time
	}
	
	public void union (int p, int q) {
		int proot = root(p);
		int qroot = root(q);
		connections[proot] = connections[qroot]; // can grow to linear time and produce tall trees
		
	}

}
