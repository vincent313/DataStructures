import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/**
 * @author Zhiyong
 */
public class MyHashMap<k,v> {
	private int arraySize;
	private int currentElement;

	private double loaderFactor=0.7;
	private HashMapNode<k,v>[] array;

	public MyHashMap(int arraySize) {
		this.arraySize = arraySize;
		currentElement=0;
		array=new HashMapNode[arraySize];
	}
  public void addNode(k key,v value){

	  HashMapNode hashMapNode=new HashMapNode(key,value);
		//call method to add node to array
		putNodeToArray(hashMapNode);
	  System.out.println("Current size: "+arraySize+" Current element: "+currentElement);
		//double the array size to maintaining high performance.
		if ((double)currentElement/arraySize>=loaderFactor){
		reSize();
		}
  }

	/**
	 * This method can be use for adding node or resizing hashmap
	 * 1.if array[index] is empty,add node in to the array[index] as the first element
	 * 2.if array[index] is not empty,check every element in the linked list.If key exist ,update value, otherwise add node into the tail of linked list*/
	private void putNodeToArray(HashMapNode<k,v> hashMapNode){
		int index=hashMapNode.getKey().hashCode()%arraySize;
		hashMapNode.nextNode=null;
		if (array[index]==null){
			array[index]=hashMapNode;
			currentElement++;
			return;
		}

		HashMapNode<k,v> head=array[index];
		while(true){
			if (head.getKey().equals(hashMapNode.getKey())){
				head.value= hashMapNode.getValue();
				return;
			}
			if(head.nextNode==null){
				head.nextNode=hashMapNode;
				currentElement++;
				return;
			}
			head=head.nextNode;
		}


	}

	@Override
	public String toString() {
		String s="MyHashMap{" +
				"arraySize=" + arraySize +
				", currentElement=" + currentElement +
				"}"+"\n";
		ArrayList<HashMapNode<k,v>> list=getList();

		for (HashMapNode<k,v> hashMapNode:list){
		s+=hashMapNode.toString();
		}
		return s;
	}


	/**
	 * key exist->return value
	 * key doesn't exist->return null
	 * */
	public v query(k key){
		int index=key.hashCode()%arraySize;
		if (array[index]==null){return null;}
		HashMapNode<k,v> head=array[index];
		while(true){
			if (head.getKey().equals(key)){
				return head.getValue();
			}
			if (head.nextNode==null){return null;}
			head=head.nextNode;
		}
	}


	/**
	 * 1.key exist,delete key and return true
	 * 2.key doesn't exist,return false
	 */
	public boolean delete(k key){
		int index=key.hashCode()%arraySize;
		if (array[index]==null){
			return false;
		}

		HashMapNode<k,v> head=array[index];
		HashMapNode<k,v> previousNode=null;
		while(true){
			if (head.getKey().equals(key)){
				if (previousNode==null){
					array[index]=head.nextNode;
				}else{
					previousNode.nextNode=head.nextNode;
				}
				currentElement--;
				return true;
			}
			if (head.nextNode==null){return false;}
			previousNode=head;
			head=head.nextNode;
		}
	}

	/**Traverse hashmap,return list which contains every element in the hashmap
	 * Use for resizing() and toString()
	 * */
	private ArrayList<HashMapNode<k,v>> getList(){
		ArrayList<HashMapNode<k,v>> list=new ArrayList<>();

		for (HashMapNode<k,v> hashMapNode:array){
			if (hashMapNode!=null){
				HashMapNode head=hashMapNode;
				while(true){
					list.add(head);
					if (head.nextNode==null){
						break;
					}
					head=head.nextNode;
				}
			}
		}
		return list;
	}

	/**resizing array for maintaining good performance*/
	private void reSize(){
		System.out.println("Resizing");
		ArrayList<HashMapNode<k,v>> list=getList();
		arraySize=(arraySize*2);
		currentElement=0;
		array=new HashMapNode[arraySize];
		for (HashMapNode<k,v> node:list){
			putNodeToArray(node);
		}
	}
	private static class HashMapNode<k,v>{

		HashMapNode<k,v> nextNode;
		k key;
		v value;
		private HashMapNode(k key,v value) {
			this.key=key;
			this.value=value;
		}

		private k getKey() {
			return key;
		}

		private v getValue() {
			return value;
		}

		private HashMapNode<k, v> getPreviousNode() {
			return nextNode;
		}

		@Override
		public String toString() {
			return "HashMapNode{" +
					"key=" + key +
					", value=" + value +
					'}'+"\n";
		}
	}
}
