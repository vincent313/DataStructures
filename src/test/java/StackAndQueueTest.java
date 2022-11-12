import org.junit.Test;

public class StackAndQueueTest {
@Test
	public void arrayStackTest(){
	ArrayStack arrayStack=new ArrayStack(10);
	for (int i=0;i<11;i++){
		arrayStack.push(String.valueOf(i));
	}

	System.out.println("current top element is "+arrayStack.peek());

	System.out.println("current stack is empty ->"+ arrayStack.isEmpty());
	String popValue;
	while(true){
		popValue= arrayStack.pop();
		if(popValue==null){
			break;
		}
		System.out.print(popValue+" ");
	}

	System.out.println("current stack is empty ->"+ arrayStack.isEmpty());
}

@Test
	public void linkedListTest(){
		LinkedListStack linkedListStack=new LinkedListStack();
		for (int i=0;i<10;i++){
			linkedListStack.push(String.valueOf(i));
		}
		System.out.println("current amount in stack "+linkedListStack.getNodeAmount());

		while(true){
			String value= linkedListStack.pop();
			if (value==null){break;}
			System.out.print(value+" ");
		}

	System.out.println("current amount in stack "+linkedListStack.getNodeAmount());
	}

@Test
	public void arrayQueueTest(){
	int capacity=100;
	ArrayQueue arrayQueue=new ArrayQueue(capacity);
	for (int i=0;i<(capacity+1);i++){
		arrayQueue.enqueue(String.valueOf(i));
	}

	String value;
	while(true){
		value=arrayQueue.dequeue();
		if (value==null){
			break;
		}
		System.out.print(value+" ");
	}
}

@Test
	public void linkedListQueueTest(){

	LinkedListQueue linkedListQueue=new LinkedListQueue();
	for (int i=0;i<10;i++){
		linkedListQueue.enqueue(String.valueOf(i));
	}

	System.out.println("Current queue size is:" +linkedListQueue.nodeAmount);

	while (true){
		String s=linkedListQueue.dequeue();
		if (s==null){
			break;
		}
		System.out.print(s+" ");
	}

	System.out.println("Current queue size is:" +linkedListQueue.nodeAmount);

}
}


