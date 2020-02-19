package code;

public class FixedCapacityStack<Item> {
	
	
	private Item []stack;
	private Integer size;
	
	public FixedCapacityStack(int size) {
		this.stack =  (Item[])new Object[size];
	
	}
	public Boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void push(Item item) {
		stack[size++] = item;
	}

	public Item pop() {
		return stack[size--];
	}

}
