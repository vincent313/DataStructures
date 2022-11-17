package AlgorithmTest;

import Algorithm.Sort;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class SortTest {
	int size;

	int[] array;
	Sort sort;
@Before
	public void generateArray(){
		size=100;
		sort=new Sort();
		Random random=new Random();
		array=new int[size];
		for (int i=0;i<size;i++){
			int z= random.nextInt(100);
			array[i]=z;
		}
	}

	@Test
	public void insertSort(){
		int[] insertsort= sort.insertSort(array);
		for (int i:insertsort){
			System.out.print(i+" ");
		}
	}

	@Test
	public void quickSortTest(){
	sort.quickSort(array,0, array.length-1);
		for (int i:array){
			System.out.print(i+" ");
		}
	}
}
