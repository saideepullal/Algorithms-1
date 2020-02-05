package unionfind.algs;
// Weighted Quick Union
public class WQU {
	
	private int[] connections;
	private int[] size; //maintaining size of each tree
	
	public WQU(Integer n) {
		connections = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			connections[i] = i; // Takes n times
			size[i] = 1; // each tree is initially 
		}
	}
	
	public Integer root(int p) {
		while (connections[p] != p) {
			connections[p] = connections[connections[p]];
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
		if(size[p]< size[q]) {
			size[q] += size[p];
			connections[proot] = qroot;
		}
		else {
			size[p] += size[q];
			connections[qroot] = proot;
		}
		connections[proot] = connections[qroot];
		
	}

}
