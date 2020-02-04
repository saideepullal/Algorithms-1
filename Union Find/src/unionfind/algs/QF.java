package unionfind.algs;
// Quick Find Algorithm
public class QF {

	private int[] connections;

	public QF(Integer n) {
		connections = new int[n];
		for (int i = 0; i < n; i++) {
			connections[i] = i; // Takes n times
		}

	}
	
	public Boolean connected(int p, int q) {
		
		return connections[p] == connections[q]; // takes O(1) time
		
	}
	
	public void union (int p, int q) {
		int pid = connections[p];
		int qid = connections[q];
		
		for(int i=0;i<connections.length;i++) {
			if(connections[i] == pid) {
				connections[i] = qid;
			}
		} // takes O(N^2) time .. needs improvement
	}

}
