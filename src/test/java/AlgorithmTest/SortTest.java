package AlgorithmTest;

import Algorithm.Sort;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class SortTest {
	int size;

	int[] array;

	Sort sort;
	@Before
	public void generateArray(){
		size=10;
		Random random=new Random();
		array=new int[size];
		for (int i=0;i<size;i++){
			int z= random.nextInt(100);
			array[i]=z;
			System.out.print(z+" ");
		}
		System.out.println();
	}

	@Test
	public void insertSort(){
		sort=new Sort();
		int[] insertsort= sort.insertSort(array);
		for (int i:insertsort){
			System.out.print(i+" ");
		}
	}
}
