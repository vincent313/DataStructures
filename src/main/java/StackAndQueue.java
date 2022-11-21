/**
 * @author Zhiyong
 */
public class StackAndQueue {
	public static ArrayStack getArrayStack(int i){
		return new ArrayStack(i);
	}

	public static LinkedListStack getLinkedListStack(){
		return new LinkedListStack();
	}

}

class ArrayStack{
	int arrayCapacity;
	int index;

	int currentAmount;
	String[] stack;

	ArrayStack(int arrayCapacity){
		index=-1;
		this.currentAmount=0;
		this.arrayCapacity=arrayCapacity;
		this.stack=new String[this.arrayCapacity];
	}

	public int getCurrentAmount(){
		System.out.println("The current amount of elements in stack is "+currentAmount);
		return currentAmount;
	}

	public String peek(){
		return stack[index];
	}

	public boolean isEmpty(){
		if (currentAmount==0){
			return true;
		}
		return false;
	}

	public void push(String s){
		if (currentAmount==arrayCapacity){
			System.out.println("Stack overflow");
			return;
		}
		currentAmount++;
		stack[++index]=s;
		System.out.print(stack[index]+" ");
	}

	public String pop(){
		if (currentAmount==0){
			System.out.println("Stack underflow");
			return null;
		}
		String s=stack[index--];
		currentAmount--;
		return s;
	}
}

class LinkedListStack{
	private StackNode top;
	private int nodeAmount=0;

	public void push(String value){
		StackNode node=new StackNode(value);
		if(nodeAmount==0){
			top=node;
			nodeAmount++;
			return;
		}
		node.previousNode=top;
		top=node;
		nodeAmount++;
	}

	public String pop(){
		if (nodeAmount==0){
			System.out.println("Stack underflow");
			return null;
		}

		String value=top.value;
		top=top.previousNode;
		nodeAmount--;
		return value;
	}

	public int getNodeAmount(){
		return nodeAmount;
	}
	private static class StackNode{
		String value;
		StackNode previousNode=null;
		StackNode(String value){
			this.value=value;
		}

		String getValue(){
			return value;
		}
	}

}

class ArrayQueue{
	int capacity;

	String[] array;
	int currentAmount;
	int head;
	int tail;
	ArrayQueue(int capacity){
		this.capacity=capacity;
		array=new String[capacity];
		currentAmount=0;
		head=0;
		tail=0;
	}

	void enqueue(String s){
		if (currentAmount==capacity){
			System.out.println("Enqueue fail, queue is full");
			return;
		}

		if (currentAmount==0){
			array[head]=s;
			tail++;
			currentAmount++;
			return;
		}

		array[(tail)%capacity]=s;
		tail++;
		currentAmount++;
	}

	String dequeue(){
		if (currentAmount==0){
			System.out.println("Dequeue fail,queue is empty");
			return null;
		}
		String s=array[head%capacity];
		head++;
		currentAmount--;
		return s;
	}
}

class LinkedListQueue{
	QueueNode head;
	QueueNode tail;
	int nodeAmount;

	LinkedListQueue (){
		nodeAmount=0;
	}

	void enqueue(String s){
		QueueNode queueNode=new QueueNode(s);
		if (nodeAmount==0){
			head=queueNode;
			tail=queueNode;
			nodeAmount++;
			return;
		}

		tail.nextNode=queueNode;
		tail=queueNode;
		nodeAmount++;
	}

	String dequeue(){
		if (nodeAmount==0){
			System.out.println("Dequeue fail,queue is empty.");
			return null;
		}

		String s= head.value;
		head=head.nextNode;
		nodeAmount--;
		return s;
	}
	private static class QueueNode{
		QueueNode nextNode;
		String value;

		QueueNode(String s){
			this.value=s;
		}
	}
}