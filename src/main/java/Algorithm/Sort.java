package Algorithm;

public class Sort {

/*	public int[] insertSort(int[] array){
		int high=array.length-1;
		int low=0;
		for (int i=1;i<=high;i++){
			int value=array[i];
			int j=0;
			while(true){
				if (j>=i){break;}
				if (value<array[j]){
					for (int x=i;x>j;x--){
						array[x]=array[x-1];
					}
					array[j]=value;
					break;
				}
				j++;
			}
		}
		return array;
	}*/

	public int[] insertSort(int[] array){
		int lastIndex=array.length-1;

		for (int i=0;i<=lastIndex;i++){

			int value=array[i];
			int j=i;
			while(true){
				if (j==0){
					array[j]=value;
					break;}
				if (array[j-1]>value){array[j]=array[j-1];}
				if (array[j-1]<=value){
					array[j]=value;
					break;
				}
				j--;
			}
		}

		return array;
	}

	public void quickSort(int[] array,int left,int right){
	if (right -left<=0){return;}
	int pivotIndex=getPivotIndex(array, left, right);

	quickSort(array,left,pivotIndex-1);
	quickSort(array,pivotIndex+1,right);
	}

	/**
	 * 1. Set index bounds, set first element as pivot.
	 * 2. If low pointer not out of bounds and the array[low] is smaller than pivot,pointer go next index until array[low] >= pivot ,or index reach right bounds.
	 * 3. high pointer....
	 * 4. if low pointer didn't meet high pointer, swap the value in array[low] array[high]
	 * 5. if two pointer meet or cross each other. Means pointer traversed whole array.
	 * 6. swap array[left] and swap[high] ( if choose array[right] as pivot, swap array[low] and array[right])
	 * */
	private int getPivotIndex(int[] array,int left,int right){
		int i=left;
		int j=right;
		int pivot=array[left];
		while(true){
			while (i<right&&array[i]<=pivot){
				i++;
			}
			while(j>left&&array[j]>pivot){
				j--;
			}

			if (i>=j){break;}
			swap(array,i,j);
		}
		swap(array,left,j);
		return j;
	}

	private void swap(int[] array,int index1,int index2){
		int temp=array[index1];
		array[index1]=array[index2];
		array[index2]=temp;
		return;
	}

}

