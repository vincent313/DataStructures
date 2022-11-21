/**
 * @author Zhiyong
 */
public class HeapMax {
	int index=0;
	int capacity;
	int[] array;

	public HeapMax(int capacity) {
		this.capacity = capacity;
		array=new int[capacity];
	}

	public void insert(int value){
		if ((index+1)==capacity){
			int[] newArray=new int[capacity*2];
			for (int i=0;i<=index;i++){
				newArray[i]=array[i];
			}
			array=newArray;
			capacity=(capacity*2);
			System.out.println("Resizing...current size: "+capacity);
		}
		array[index]=value;
		int currentIndex=index;
		int parentIndex=getParentIndex(currentIndex);
		while(parentIndex>=0&&array[currentIndex]>array[parentIndex]){
			int temp=array[currentIndex];
			array[currentIndex]=array[parentIndex];
			array[parentIndex]=temp;
			currentIndex=parentIndex;
			parentIndex=getParentIndex(parentIndex);
		}
		index++;
	}

	public Integer pop(){
		//System.out.println(capacity);
		//System.out.println(index);
		if (index==0){
			System.out.println("Heap is empty");
			return null;
		}
	int value=array[0];
	array[0]=array[index];
	index--;
	boolean leftStop=false;
	boolean rightStop=false;
	int currentIndex=0;
	/**if both child either not exist or smaller than parent, break loop*/
	while(true){
		int leftChildIndex=getLeftChildIndex(currentIndex);
		int rightChildIndex=getRightChildIndex(currentIndex);

		if (leftChildIndex>index||array[leftChildIndex]<array[currentIndex]){
			leftStop=true;
		}

		if (rightChildIndex>index||array[rightChildIndex]<array[currentIndex]) {
			rightStop=true;
		}
		if (leftStop&&rightStop){break;}

		/**if left child and right child all larger than parent,parent value swap with the bigger child ,go next loop*/
		if (!leftStop&&!rightStop){
			if (array[leftChildIndex]>array[rightChildIndex]){
				swap(array,currentIndex,leftChildIndex);
				currentIndex=leftChildIndex;
			}else{
				swap(array,currentIndex,rightChildIndex);
				currentIndex=rightChildIndex;
			}
			continue;
		}
		/**left child node > current, and right child is null or right < current node : current swap with left child node
		 * else: current node swap with right child node
		 * */
		if (!leftStop){
			swap(array,currentIndex,leftChildIndex);
			currentIndex=leftChildIndex;
		}else if(!rightStop){
			swap(array,currentIndex,rightChildIndex);
			currentIndex=rightChildIndex;
		}
	}
	return value;
	}

	private void swap(int[] array,int index,int index2){
		int temp=array[index];
		array[index]=array[index2];
		array[index2]=temp;
	}
	public int getParentIndex(double childIndex){
		double parentIndex=((childIndex-1)/2);
		if (parentIndex<0){return -1;}
		return (int)parentIndex;
	}

	public int getLeftChildIndex(int parentIndex){
		return parentIndex*2+1;
	}

	public int getRightChildIndex(int parentIndex){
		return parentIndex*2+2;
	}
	@Override
	public String toString(){
		String s="";
		for (int i:array){
			s+=i+" ";
		}
		return s;
	}
}
