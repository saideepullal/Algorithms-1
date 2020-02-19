package code;

import java.util.Arrays;
import java.util.Scanner;

public class DynamicCapacityStack<Item> {
	private Item[] stack;
	private int size;
	
	public DynamicCapacityStack(int size) {
		this.stack = (Item[]) new Object[size];
	}
	
	public void push (Item elm) {
		if(size == stack.length) {
			resize(stack.length * 2);
		}
		stack[size++] = elm;
	}
	
	public Item pop () {
		Item poppedItem =  stack[--size];
		stack[size] = null;
		if(size > 0 && size == stack.length/4) {
			resize(stack.length /2);
		}
		return poppedItem;
	}

	private void resize(int size) {
		Item[] temp =  (Item[]) new Object[size];
		
		for( int i=0;i<stack.length;i++) {
			temp[i] = stack[i];
		}
		stack = temp;
	}
	
	public Boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {
		return "DynamicCapacityStack [stack=" + Arrays.toString(stack) + ", size=" + size + "]";
	}
	
	public static void main (String[] args) {
		Scanner sc =  new Scanner(System.in);
		Integer size = sc.nextInt();
		DynamicCapacityStack<Integer> stack =  new DynamicCapacityStack<Integer>(size);
		
		for(int i=0;i<size;i++) {
			Integer stackItem = sc.nextInt();
			stack.push(stackItem);
		}
		
		stack.push(7); //should resize
		System.out.println(stack.toString());
		stack.pop();
		System.out.println(stack.toString());
	}
	
	
	

}
