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
}

