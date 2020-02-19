package code;

public class FixedCapacityStackOfStrings {

	private String[] stack;
	private int size;

	public FixedCapacityStackOfStrings(int N) {
		stack = new String[N];
	}

	public Boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void push(String item) {
		stack[size++] = item;
	}

	public String pop() {
		return stack[size--];
	}
	public static void main (String[] args) {
		
	}
}
