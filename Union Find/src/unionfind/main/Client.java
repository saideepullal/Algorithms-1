package unionfind.main;
import unionfind.algs.QF;
import unionfind.algs.QuickUnionFind;
import unionfind.algs.WQU;

public class Client {

	public static void main(String[] args) {
		QF quickfind =  new QF(5);
		QuickUnionFind quickUnionFind = new QuickUnionFind(5);
		WQU weightedQU =  new WQU(5);
		
		System.out.println(quickfind.connected(0, 1)); // false
		quickfind.union(0, 1);
		System.out.println(quickfind.connected(0, 1)); //true
		quickfind.union(1, 2);
		System.out.println(quickfind.connected(0, 2)); //true
		System.out.println();
	
		// ---------------------------------------------------------------
		System.out.println(quickUnionFind.connected(0, 1)); // false
		quickUnionFind.union(0, 1);
		System.out.println(quickUnionFind.connected(0, 1)); //true
		quickUnionFind.union(1, 2);
		System.out.println(quickUnionFind.connected(0, 2)); //true
		System.out.println();
		
		// ---------------------------------------------------------------
		System.out.println(weightedQU.connected(0, 1)); // false
		weightedQU.union(0, 1);
		System.out.println(weightedQU.connected(0, 1)); //true
		weightedQU.union(1, 2);
		System.out.println(weightedQU.connected(0, 2)); //true
		System.out.println();
	}

}
