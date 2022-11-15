public class PriorityQueue {
	Node head=null;
	int size=0;
	public void insert(int value,String info){
		Node newNode=new Node(value,info);
		size++;
		if (head==null){
			head=newNode;
			return;
		} else if (value> head.value) {
			newNode.nextNode=head;
			head=newNode;
			return;
		}

		Node current=head;
		while(current.nextNode!=null&&current.nextNode.value>value){
			current=current.nextNode;
		}
		newNode.nextNode=current.nextNode;
		current.nextNode=newNode;

	}


	public void traverse(){
	Node current=head;
		System.out.println("Size: "+size);
	while(current!=null){
		System.out.print(current.value+",");
		current=current.nextNode;
	}

	}

	public String pop(){
		if (head==null){
			System.out.println("Queue is empty");
			return null;
		}
		Node node=head;
		head=head.nextNode;
		size--;
		return node.toString();
	}
	private static class Node{
		int value;
		String info;
		Node nextNode=null;

		public Node(int value, String info) {
			this.value = value;
			this.info = info;
		}

		@Override
		public String toString() {
			return "Node{" +
					"value=" + value +
					", info='" + info + '\'' +
					'}';
		}
	}
}
